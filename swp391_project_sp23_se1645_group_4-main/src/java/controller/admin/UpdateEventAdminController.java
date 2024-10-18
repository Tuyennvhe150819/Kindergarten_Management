/*
 * update event admin
 * 24-02-2023
 */
package controller.admin;

import controller.admin.CreateEventAdminController;
import dao.impl.ClassDAOImpl;
import dao.impl.EventDAOImpl;
import entity.Event;
import java.io.IOException;
import entity.ViewClass;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ClassDAOInterface;
import dao.EventDAOInterface;


@WebServlet(name = "UpdateEventAdmin", urlPatterns = {"/UpdateEventAdmin"})
public class UpdateEventAdminController extends HttpServlet {

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
        try {
            EventDAOInterface eventDAOImplement = new EventDAOImpl();
            ClassDAOInterface classDAOImpl = new ClassDAOImpl();
            // take event id of Event which you want to update
            int id = Integer.parseInt(request.getParameter("id"));

            // list all class name and class id
            List<ViewClass> viewClasses = classDAOImpl.showAClass();
            request.setAttribute("class", viewClasses);
            // From event id which you take all information of event
            Event event = eventDAOImplement.ViewEventByID(id);
            request.setAttribute("event", event);
            request.getRequestDispatcher("Admin/UpdateEventAdmin.jsp").forward(request, response);
        } catch (Exception e) {
            Logger.getLogger(UpdateEventAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // Update Event *ADMIN*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            // take event id from form Update Event
            int id = Integer.parseInt(request.getParameter("eid"));
            // take image from form Update Event
            String image = request.getParameter("image");
            // take name of Event from form Update Event
            String name = request.getParameter("name");
            // take start Event from form Update Event
            String startEvent = request.getParameter("startEvent");
            // take end Event from form Update Event
            String endEvent = request.getParameter("endEvent");
            // take organizational Sponsor from form Update Event 
            String organizationalSponsor = request.getParameter("organizationalSponsor");
            // take Class id from form Update Event
            int ClassId = Integer.parseInt(request.getParameter("ClassId"));
            

            EventDAOInterface eventDAOImplement = new EventDAOImpl();
            Event event = new Event(id, ClassId, image, name, startEvent, endEvent, organizationalSponsor);
            // add a Event to database
            eventDAOImplement.UpdateEvent(event);
            response.sendRedirect("ListAllEventAdmin");
        } catch (Exception e) {
            Logger.getLogger(CreateEventAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
