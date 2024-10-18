/*
 * Attend 
 * 10/03/2023
 */
package controller.admin;

import dao.impl.AttendanceDAOImpl;
import entity.Account;
import entity.Attendance;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AttendanceDAOInterface;

@WebServlet(name = "AddAttendanceAdmin", urlPatterns = {"/addAttendance"})
public class AddAttendanceAdminController extends HttpServlet {

    /*
     * 
     * Get role
     * redirect to add attendance page
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Account acc = (Account) request.getSession().getAttribute("account");
            if (acc != null) {
                if (acc.getRole() == 0) {
                    int id = Integer.parseInt(request.getParameter("cid"));
                    request.setAttribute("id", id);
                    request.getRequestDispatcher("Admin/addAttendance.jsp").forward(request, response);
                } else {
                    response.sendRedirect("Login");
                }
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(AddAttendanceAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Add Attendance
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("cid"));
        String date = request.getParameter("date");
        String title = request.getParameter("title").trim().replaceAll("\\s+", "");
        Attendance attendance = new Attendance(date, title, id);
        AttendanceDAOInterface attendanceDAOInterface = new AttendanceDAOImpl();
        attendanceDAOInterface.AddAttendance(attendance);
        response.sendRedirect("ListAllClassAdmin");
    }

}
