/*
 * update notification admin
 * 23-02-2023
 */
package controller.admin;

import dao.impl.NotificationDAOImpl;
import entity.Notification;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.NotificationDAOInterface;


@WebServlet(name = "UPNotificationAD", urlPatterns = {"/UPNotificationAD"})
public class UpdateNotificationAdminController extends HttpServlet {

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
            NotificationDAOInterface notificationDAOImplement = new NotificationDAOImpl();
            // take notification id of Notification which you want to update
            int id = Integer.parseInt(request.getParameter("id"));
            // From notification id which you take all information of notification
            Notification notification = notificationDAOImplement.ViewNotificationByID(id);
            request.setAttribute("notification", notification);
            request.getRequestDispatcher("Admin/UpdateNotificationAdmin.jsp").forward(request, response);
        } catch (Exception e) {
            Logger.getLogger(UpdateNotificationAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // Update Notification *ADMIN*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            // take notificationid from form Update Notification
            int id = Integer.parseInt(request.getParameter("nid"));
            // take notification image from form Update Notification
            String image = request.getParameter("image");
            // take notification subject from form Update Notification
            String subject = request.getParameter("subject");
            // take notification describe from form Update Notification
            String describe = request.getParameter("describe");
            // take start Date from form Update Notification
            String startDate = request.getParameter("startDate");
            // take  end Date from form Update Notification
            String endDate = request.getParameter("endDate");
            // take create By from form Update Notification
            String createBy = request.getParameter("createBy");

            NotificationDAOInterface notificationDAOImplement = new NotificationDAOImpl();
            Notification notification = new Notification(id, image, subject, describe, startDate, endDate, createBy);
            // Update information of notification to database
            notificationDAOImplement.UpdateNotification(notification);
            //change to the Notification Admin
            response.sendRedirect("listN");
        } catch (Exception e) {
            Logger.getLogger(UpdateNotificationAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
