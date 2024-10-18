/*
 * list class admin
 * 21-02-2023
 */
package controller.admin;

import dao.impl.ClassDAOImpl;
import entity.Account;
import java.io.IOException;
import java.util.List;
import entity.ViewClass;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ClassDAOInterface;


@WebServlet(name = "ListAllClassAdmin", urlPatterns = {"/ListAllClassAdmin"})
public class ListAllClassAdminController extends HttpServlet {
     // List  5 Class by page number
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

                    ClassDAOInterface classDAOImplement = new ClassDAOImpl();

                    // get end page
                    int endPageClass = classDAOImplement.getNumberEndPageClass();
                    // List  5 Class by page number
                    List<ViewClass> viewClasses = classDAOImplement.PagingClass(index);

                    request.setAttribute("listClass", viewClasses);
                    request.setAttribute("endPageClass", endPageClass);
                    request.setAttribute("numPage", index);
                    //change to the ClassAdmin.jsp
                    request.getRequestDispatcher("Admin/ClassAdmin.jsp").forward(request, response);
                } else {
                    response.sendRedirect("Login");
                }
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(ListAllClassAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
