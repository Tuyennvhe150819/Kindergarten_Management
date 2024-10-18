/*
 * Attendance Teacher
 * 14-03-2023
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
 *
 * @author Asus
 */
@WebServlet(name = "checkAttendance", urlPatterns = {"/checkAttendance"})
public class checkAttendanceController extends HttpServlet {

    /** 
     * Take role for attendance
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
                List<CheckAttendance> checkAttendances = attendanceDAOInterface.checkAttendance(classID);
                request.setAttribute("Attendance", checkAttendances);
                request.getRequestDispatcher("Teacher/attendace.jsp").forward(request, response);
            } else if (teacher == null) {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(checkAttendanceController.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    /**
     * Attendance form
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            AttendanceDAOInterface attendanceRepository = new AttendanceDAOImpl();
            String[] attendanceID = request.getParameterValues("attendanceID");
            for (int i = 0; i < attendanceID.length; i++) {
                String[] status = request.getParameterValues("status");
                String[] note = request.getParameterValues("note");
                String[] studentID = request.getParameterValues("studentID");
                attendanceRepository.Attended(studentID[i],attendanceID[i], status[i], note[i].trim().replaceAll("\\s+"," "));
            }
            response.sendRedirect("ListClass");
        }catch(Exception e) {
            Logger.getLogger(checkAttendanceController.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}
