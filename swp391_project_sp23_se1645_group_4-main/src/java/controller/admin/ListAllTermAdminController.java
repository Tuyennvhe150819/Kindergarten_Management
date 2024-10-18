/*
 * List term admin
 * 19-02-2023
 */
package controller.admin;

import dao.impl.TermDAOImpl;
import entity.Account;
import entity.Term;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.TermDAOInterface;


@WebServlet(name = "ListAllTermAD", urlPatterns = {"/ListAllTermAD"})
public class ListAllTermAdminController extends HttpServlet {
    //View 5 term by page number *ADMIN*
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

                    TermDAOInterface termDAOImpl = new TermDAOImpl();

                    // get end page
                    int endPageTerm = termDAOImpl.getNumberEndPageTerm();
                    // List  5 term by page number
                    List<Term> term = termDAOImpl.PagingTerm(index);

                    request.setAttribute("listTerm", term);
                    request.setAttribute("endPageTerm", endPageTerm);
                    request.setAttribute("numPage", index);
                    //change to the List All Term 
                    request.getRequestDispatcher("Admin/TermAdmin.jsp").forward(request, response);
                } else {
                    response.sendRedirect("Login");
                }
            } else {
                response.sendRedirect("Login");
            }

        } catch (Exception e) {
            Logger.getLogger(ListAllTermAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
