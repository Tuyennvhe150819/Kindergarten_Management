/*
 * Login
 * 09-02-2023
 */
package controller;

import dao.impl.AccountDAOImpl;
import dao.impl.ParentDAOImpl;
import dao.impl.TeacherDAOImpl;
import entity.Account;
import entity.Parent;
import entity.Teacher;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.AccountDAOInterface;
import dao.ParentDAOInterface;
import dao.TeacherDAOInterface;

/**
 * Login
 *
 */
@WebServlet(name = "ControlLogin", urlPatterns = {"/controllogin"})
public class ControlLoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    /**
     * Handles the HTTP <code>POST</code> method. Login decentralization admin
     * teacher, parent
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String email = request.getParameter("email");
            String pass = request.getParameter("password");
            AccountDAOInterface accountDAOInterface = new AccountDAOImpl();
            ParentDAOInterface parentRepository = new ParentDAOImpl();
            TeacherDAOInterface teacherRepository = new TeacherDAOImpl();
            Account account = accountDAOInterface.checkLogin(email, pass);
            HttpSession session = request.getSession();
            if (account == null) {
                request.setAttribute("mess", "Wrong user or pass");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else if (account.getRole() == 0) {
                session.setAttribute("account", account);
                response.sendRedirect("dashboard");
            } else if (account.getRole() == 1) {
                Teacher teacher = teacherRepository.ProfileTeacher(account.getAccountID());
                session.setAttribute("account", account);
                session.setAttribute("teach", teacher);
                response.sendRedirect("ViewTerm");
            } else {
                Parent parent = parentRepository.Profile(account.getAccountID());
                session.setAttribute("account", account);
                session.setAttribute("parent", parent);
                response.sendRedirect("homePageController");
            }
        }catch(Exception e) {
            Logger.getLogger(ControlLoginController.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
