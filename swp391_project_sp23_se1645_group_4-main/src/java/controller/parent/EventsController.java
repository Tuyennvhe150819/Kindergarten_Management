/*
 * List event parent
 * 21-02-2023
 */
package controller.parent;

import dao.impl.EventDAOImpl;
import entity.Event;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.EventDAOInterface;


@WebServlet(name = "Event", urlPatterns = {"/event"})
public class EventsController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * List event
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String indexPage = request.getParameter("index");
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            EventDAOInterface eventDAOInterface = new EventDAOImpl();
            int endPage = eventDAOInterface.getNumberEndPageEvent();
            List<Event> event = eventDAOInterface.listEvent(index);
            request.setAttribute("endPage", endPage);
            request.setAttribute("ListE", event);
            request.setAttribute("numPage", index);
            request.getRequestDispatcher("Parent/Event.jsp").forward(request, response);
        } catch (Exception e) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
