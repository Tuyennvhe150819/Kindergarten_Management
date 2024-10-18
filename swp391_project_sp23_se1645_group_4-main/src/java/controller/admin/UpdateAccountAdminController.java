/*
 * update account admin
 * 26-02-2023
 */
package controller.admin;


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


@WebServlet(name = "UPAccountAD", urlPatterns = {"/UPAccountAD"})
public class UpdateAccountAdminController extends HttpServlet {
      /**
       * Get id
       **/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            AccountDAOInterface accountDAOImpl = new AccountDAOImpl();
            // take account id of Account which you want to update
            int id = Integer.parseInt(request.getParameter("id"));
            // From account id which you take all information of account
            Account account = accountDAOImpl.viewAccountbyID(id);
            request.setAttribute("account", account);
            request.getRequestDispatcher("Admin/UpdateAccountAdmin.jsp").forward(request, response);
        } catch (Exception e) {
           Logger.getLogger(UpdateAccountAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

      /**
       * Update Account *ADMIN*
       **/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int accountid = Integer.parseInt(request.getParameter("aid"));
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");
            int role = Integer.parseInt(request.getParameter("role"));

            AccountDAOInterface accountDAOImpl = new AccountDAOImpl();
            Account account = new Account(accountid, email, pass, role);
            accountDAOImpl.UpdateAccount(account);
            response.sendRedirect("ListAllAccountAD");
        } catch (Exception e) {
            Logger.getLogger(UpdateAccountAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
