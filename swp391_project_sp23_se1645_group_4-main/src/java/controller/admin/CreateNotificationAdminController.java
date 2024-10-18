/*
 * Add notification
 * 18-02-2023
 */
package controller.admin;

import dao.impl.NotificationDAOImpl;
import entity.Account;
import java.io.IOException;
import entity.Notification;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.NotificationDAOInterface;


@WebServlet(name = "CreateNotificationAD", urlPatterns = {"/CreateNotiAD"})
public class CreateNotificationAdminController extends HttpServlet {

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
        Account acc = (Account) request.getSession().getAttribute("account");
        if (acc != null) {
            if (acc.getRole() == 0) {
                request.getRequestDispatcher("Admin/CreateNotificationAdmin.jsp").forward(request, response);
            } else {
                response.sendRedirect("Login");
            }
        } else {
            response.sendRedirect("Login");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */// Create a Notification *ADMIN*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            // take image from form CreateNotificationAdminController.jsp 
            String image = request.getParameter("image");
            // take subject from form CreateNotificationAdminController.jsp 
            String subject = request.getParameter("subject").trim().replaceAll("\\s+"," ");
            // take describe from form CreateNotificationAdminController.jsp 
            String describe = request.getParameter("describe").trim().replaceAll("\\s+"," ");
            // take start Date from form CreateNotificationAdminController.jsp 
            String startDate = request.getParameter("startDate");
            // take  end Date from form CreateNotificationAdminController.jsp 
            String endDate = request.getParameter("endDate");
            // take create By from form CreateNotificationAdminController.jsp 
            String createBy = request.getParameter("createBy").trim().replaceAll("\\s+"," ");

            NotificationDAOInterface notificationDAOImplement = new NotificationDAOImpl();
            Notification notification = new Notification(image, subject, describe, startDate, endDate, createBy);
            // add a Notification to database
            notificationDAOImplement.AddNotification(notification);
            response.sendRedirect("listN");
        } catch (Exception e) {
            Logger.getLogger(CreateNotificationAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
