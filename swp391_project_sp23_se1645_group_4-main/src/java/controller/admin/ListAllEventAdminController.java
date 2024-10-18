/*
 * list event admin
 * 23-02-2023
 */
package controller.admin;

import dao.impl.EventDAOImpl;
import entity.Account;
import entity.Event;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.EventDAOInterface;


@WebServlet(name = "ListAllEventAdmin", urlPatterns = {"/ListAllEventAdmin"})
public class ListAllEventAdminController extends HttpServlet {
    //View 5 events by page number *ADMIN*
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

                    EventDAOInterface eventDAOImplement = new EventDAOImpl();
                    // get end page
                    int endPageEvent = eventDAOImplement.getNumberEndPageEvent();
                    // List  5 events by page number
                    List<Event> events = eventDAOImplement.PagingEvent(index);

                    request.setAttribute("listEvent", events);
                    request.setAttribute("endPageEvent", endPageEvent);
                    request.setAttribute("numPage", index);
                    //change to the EventAdmin.jsp
                    request.getRequestDispatcher("Admin/EventAdmin.jsp").forward(request, response);
                } else {
                    response.sendRedirect("Login");
                }
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(ListAllEventAdminController.class.getName()).log(Level.SEVERE, null, e);
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
