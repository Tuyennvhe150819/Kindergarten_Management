/*
 * list parent admin
 * 23-02-2023
 */
package controller.admin;

import dao.impl.ParentDAOImpl;
import entity.Account;
import entity.Parent;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ParentDAOInterface;


@WebServlet(name = "ListAllParentAdmin", urlPatterns = {"/ListAllParentAdmin"})
public class ListAllParentAdminController extends HttpServlet {

    //View 5 Parent by page number *ADMIN*
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

                    ParentDAOInterface parentDAOImplement = new ParentDAOImpl();

                    int endPageParent = parentDAOImplement.getNumberEndPageParent();
                    List<Parent> parents = parentDAOImplement.PagingParent(index);

                    request.setAttribute("listParent", parents);
                    request.setAttribute("endPageParent", endPageParent);
                    request.setAttribute("numPage", index);
                    request.getRequestDispatcher("Admin/ParentAdmin.jsp").forward(request, response);
                } else {
                    response.sendRedirect("Login");
                }
            } else {
                response.sendRedirect("Login");
            }

        } catch (Exception e) {
            Logger.getLogger(ListAllParentAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
