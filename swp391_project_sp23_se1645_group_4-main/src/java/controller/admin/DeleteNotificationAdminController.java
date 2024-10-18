/*
 * Delete notification
 * 16-02-2023
 */
package controller.admin;

import dao.impl.NotificationDAOImpl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.NotificationDAOInterface;


@WebServlet(name = "DeleteNotificationAD", urlPatterns = {"/DeleteNotiAD"})
public class DeleteNotificationAdminController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *///Delete Notification *Admin*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            // delete Notification by id of Notification
            int id = Integer.parseInt(request.getParameter("deid"));
            NotificationDAOInterface notificationDAOImplement = new NotificationDAOImpl();
            notificationDAOImplement.deleteNotification(id);
            //change to the Notification Admin
            response.sendRedirect("listN");
        } catch (Exception e) {
            Logger.getLogger(DeleteNotificationAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
