/*
 * Change password
 * 17/03/2023
 */
package controller;

import dao.impl.AccountDAOImpl;
import entity.Account;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AccountDAOInterface;

/**
 *
 * @author Asus
 */
@WebServlet(name = "ChangePass", urlPatterns = {"/changePass"})
public class ChangePassController extends HttpServlet {
    /**
     * 
     * Change password
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Account acc = (Account) request.getSession().getAttribute("account");
            String oldPass = request.getParameter("oldpassword");
            String newPass = request.getParameter("newpassword");
            AccountDAOInterface accountDAOInterface = new AccountDAOImpl();
            if (oldPass.equals(acc.getPassword())) {
                accountDAOInterface.ChangePass(newPass, acc.getAccountID());
                response.sendRedirect("homePageController");
            }else if(!oldPass.equals(acc.getPassword())){
                request.setAttribute("smess", "your old password is wrong");
                request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
            }
        } catch (Exception e) {
            Logger.getLogger(ChangePassController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
