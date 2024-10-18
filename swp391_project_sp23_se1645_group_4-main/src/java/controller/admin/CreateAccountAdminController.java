/*
 * Register teacher, parent
 * 11-03-2023
 */
package controller.admin;

import dao.impl.AccountDAOImpl;
import dao.impl.ClassDAOImpl;
import entity.Account;
import entity.ViewClass;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AccountDAOInterface;
import dao.ClassDAOInterface;

@WebServlet(name = "CreateAccountAD", urlPatterns = {"/CreateAccountAD"})
public class CreateAccountAdminController extends HttpServlet {

    /**
     *
     * Get role
     *
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Account acc = (Account) request.getSession().getAttribute("account");
            if (acc != null) {
                if (acc.getRole() == 0) {
                    //change to the Create Account 
                    request.getRequestDispatcher("Admin/CreateAccountAdmin.jsp").forward(request, response);
                } else {
                    response.sendRedirect("Login");
                }
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(CreateAccountAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Create a account for Teacher or Parent, Student
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String email = request.getParameter("email").trim().replaceAll("\\s+", " ");;
            String pass = request.getParameter("pass").trim().replaceAll("\\s+", " ");;
            int role = Integer.parseInt(request.getParameter("role"));

            AccountDAOInterface accountDAOImpl = new AccountDAOImpl();
            ClassDAOInterface classDAOImpl = new ClassDAOImpl();
            List<ViewClass> viewClasses = classDAOImpl.showAClass();

            Account account = new Account(email, pass, role);
            accountDAOImpl.AddAccount(account);
            if (role == 0) {
                response.sendRedirect("ListAllAccountAD");
            } else if (role == 1) {
                request.getRequestDispatcher("Admin/CreateTeacherAdmin.jsp").forward(request, response);
            } else {
                request.setAttribute("class", viewClasses);
                request.getRequestDispatcher("Admin/CreateStudentParentAdmin.jsp").forward(request, response);
            }
        } catch (Exception e) {
            Logger.getLogger(CreateAccountAdminController.class.getName()).log(Level.SEVERE, null, e);
        }

    }

}
