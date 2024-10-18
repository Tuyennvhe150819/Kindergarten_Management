/*
 * list schedule
 * 19-03-2023
 */
package controller.teacher;

import dao.impl.AttendanceDAOImpl;
import entity.Attendance;
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


@WebServlet(name = "TeacherSchedule", urlPatterns = {"/teacherSchedule"})
public class TeacherScheduleController extends HttpServlet {

    /**
     * Get role
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Teacher teacher = (Teacher) request.getSession().getAttribute("teach");
            if (teacher != null) {
                request.getRequestDispatcher("Teacher/teacherSchedule.jsp").forward(request, response);
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(TeacherScheduleController.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }

    /**
     * show schedule follow week
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Teacher teacher = (Teacher) request.getSession().getAttribute("teach");
            if (teacher != null) {
                AttendanceDAOInterface attendanceRepository = new AttendanceDAOImpl();
                String week = request.getParameter("week");
                String year = request.getParameter("week");
                String weeked = week.substring(6, 8);
                String years = year.substring(0, 4);
                System.out.println(years);
                List<Attendance> attendance = attendanceRepository.showTeacherSchedule(teacher.getTeacherID(), weeked, years);
                request.setAttribute("listA", attendance);
                request.getRequestDispatcher("Teacher/teacherSchedule.jsp").forward(request, response);
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(TeacherScheduleController.class.getName()).log(Level.SEVERE, null, e);
        }
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
