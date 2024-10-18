/*
 * list notification admin
 * 20-02-2023
 */
package controller.admin;

import dao.impl.NotificationDAOImpl;
import entity.Account;
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


@WebServlet(name = "ListAllNotification", urlPatterns = {"/listN"})
public class ListAllNotificationAdminController extends HttpServlet {

    //View 5 notifications by page number *ADMIN*
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
                    NotificationDAOInterface notificationDAOImplement = new NotificationDAOImpl();

                    int endPageNotification = notificationDAOImplement.getNumberEndPageNotificationAdmin();
                    // List  5 Notification by page number
                    List<Notification> notifications = notificationDAOImplement.PagingNotification(index);
                    for(Notification c : notifications) {
                        System.out.println(c);
                    }
                    request.setAttribute("listNotification", notifications);
                    request.setAttribute("endPageNotification", endPageNotification);
                    request.setAttribute("numPage", index);

                    //change to the NotificationAdmin.jsp
                    request.getRequestDispatcher("Admin/NotificationAdmin.jsp").forward(request, response);
                } else {
                    response.sendRedirect("Login");
                }
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(ListAllNotificationAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
