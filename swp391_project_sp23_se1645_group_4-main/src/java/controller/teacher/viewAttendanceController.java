/*
 * view attendance (teacher)
 * 23-02-2023
 */
package controller.teacher;

import dao.impl.AttendanceDAOImpl;
import entity.CheckAttendance;
import entity.Teacher;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AttendanceDAOInterface;

/**
 *
 * @author Asus
 */
@WebServlet(name = "viewAttendance", urlPatterns = {"/viewAttendance"})
public class viewAttendanceController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * view information about attending class on that day
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Teacher teacher = (Teacher) request.getSession().getAttribute("teach");
            if (teacher != null) {
                AttendanceDAOInterface attendanceDAOInterface = new AttendanceDAOImpl();
                int classID = Integer.parseInt(request.getParameter("classID"));
                String date = request.getParameter("date");
                List<CheckAttendance> checkAttendances = attendanceDAOInterface.viewAttendance(classID, date);
                request.setAttribute("Attendance", checkAttendances);
                request.getRequestDispatcher("Teacher/viewAttendance.jsp").forward(request, response);
            } else if (teacher == null) {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(viewAttendanceController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
