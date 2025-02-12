/*
 * list notification parent
 * 20-02-2023
 */
package controller.parent;

import dao.impl.NotificationDAOImpl;
import entity.Notification;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.NotificationDAOInterface;

/**
 * show Notification
 *
 * @author MSII
 */
@WebServlet(name = "NotificationController", urlPatterns = {"/NotificationController"})
public class NotificationController extends HttpServlet {

    /**
     * list notification parent
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String indexPage = request.getParameter("index");
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            NotificationDAOInterface notificationDAOInterface = new NotificationDAOImpl();
            int endPage = notificationDAOInterface.getNumberEndPageNotification();
            List<Notification> notifications = notificationDAOInterface.ListNotification(index);
            request.setAttribute("note", notifications);
            request.setAttribute("endPage", endPage);
            request.setAttribute("numPage", index);
            request.getRequestDispatcher("Parent/Notification.jsp").forward(request, response);
        }catch(Exception e) {
            Logger.getLogger(NotificationController.class.getName()).log(Level.SEVERE, null, e);
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
