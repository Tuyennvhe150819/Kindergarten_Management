/*
 * list account
 * 17-02-2023
 */
package controller.admin;

import dao.impl.AccountDAOImpl;
import entity.Account;
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


@WebServlet(name = "ListAllAccountAD", urlPatterns = {"/ListAllAccountAD"})
public class ListAllAccountAdminController extends HttpServlet {
    // View 5 account follow paging *ADMIN*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Account acc = (Account) request.getSession().getAttribute("account");
            if (acc != null) {
                if (acc.getRole() == 0) {
                    String indexPage = request.getParameter("index");

                    if (indexPage == null) {
                        indexPage = "1";
                    }
                    int index = Integer.parseInt(indexPage);

                    AccountDAOInterface accountDAOImpl = new AccountDAOImpl();
                    // get end page
                    int endPageAccount = accountDAOImpl.getNumberEndPageAccount();

                    // List  5 accounts by page number
                    List<Account> accounts = accountDAOImpl.PagingAccount(index);

                    request.setAttribute("listAccount", accounts);
                    request.setAttribute("endPageAccount", endPageAccount);
                    request.setAttribute("numPage", index);

                    //change to the AccountAdmin.jsp
                    request.getRequestDispatcher("Admin/AccountAdmin.jsp").forward(request, response);
                } else {
                    response.sendRedirect("Login");
                }
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(ListAllAccountAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
