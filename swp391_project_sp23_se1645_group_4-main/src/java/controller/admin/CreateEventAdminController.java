/*
 * Event
 * 23-02-2023
 */
package controller.admin;

import dao.impl.ClassDAOImpl;
import dao.impl.EventDAOImpl;
import entity.Account;
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


@WebServlet(name = "CreateEventAdmin", urlPatterns = {"/CreateEventAdmin"})
public class CreateEventAdminController extends HttpServlet {

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
            Account acc = (Account) request.getSession().getAttribute("account");
            if (acc != null) {
                if (acc.getRole() == 0) {
                    ClassDAOInterface classDAOImpl = new ClassDAOImpl();
                    // list all class name and class id
                    List<ViewClass> viewClasses = classDAOImpl.showAClass();
                    request.setAttribute("class", viewClasses);
                    //change to the Create Event 
                    request.getRequestDispatcher("Admin/CreateEventAdmin.jsp").forward(request, response);
                } else {
                    response.sendRedirect("Login");
                }
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(CreateEventAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */// Create a Event *ADMIN*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            // take image from form CreateEventAdminController.jsp 
            String image = request.getParameter("image");
            // take name of Event from form CreateEventAdminController.jsp 
            String name = request.getParameter("name");
            // take start Event from form CreateEventAdminController.jsp 
            String startEvent = request.getParameter("startEvent");
            // take end Event from form CreateEventAdminController.jsp 
            String endEvent = request.getParameter("endEvent");
            // take organizational Sponsor from form CreateEventAdminController.jsp 
            String organizationalSponsor = request.getParameter("organizationalSponsor");
            // take Class id from form CreateEventAdminController.jsp 
            int ClassId = Integer.parseInt(request.getParameter("ClassId"));

            EventDAOInterface eventDAOImplement = new EventDAOImpl();
            Event event = new Event(ClassId, image, name, startEvent, endEvent, organizationalSponsor);
            // add a Event to database
            eventDAOImplement.AddEvent(event);
            response.sendRedirect("ListAllEventAdmin");
        } catch (Exception e) {
            Logger.getLogger(CreateEventAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
