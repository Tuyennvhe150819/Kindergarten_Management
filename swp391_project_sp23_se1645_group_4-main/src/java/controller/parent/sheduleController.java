/*
 * list schedule (parent)
 * 22-02-2023
 */
package controller.parent;

import dao.impl.AttendanceDAOImpl;
import entity.Attendance;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.impl.StudentDAOImpl;
import entity.Parent;
import entity.Student;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.AttendanceDAOInterface;
import dao.StudentDAOInterface;

/**
 *
 * Shedule student
 */
@WebServlet(name = "sheduleController", urlPatterns = {"/shedule"})
public class sheduleController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method. xem lịch học của học sinh đó
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Parent parent = (Parent) request.getSession().getAttribute("parent");
            if (parent != null) {
                int studentID = Integer.parseInt(request.getParameter("studentID"));
                StudentDAOInterface studentDAOInterface = new StudentDAOImpl();
                Student students = studentDAOInterface.ViewStudent(studentID);
                request.setAttribute("st", students);
                request.getRequestDispatcher("Parent/Shedule.jsp").forward(request, response);
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(sheduleController.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    /**
     * list schedule follow week
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Parent parent = (Parent) request.getSession().getAttribute("parent");
            if (parent != null) {
                int studentID = Integer.parseInt(request.getParameter("studentId"));
                AttendanceDAOInterface attendanceRepository = new AttendanceDAOImpl();
                String week = request.getParameter("week");
                List<Attendance> attendance = attendanceRepository.showAttendance(studentID, week.substring(6, 8), week.substring(0, 4));
                StudentDAOInterface studentDAOInterface = new StudentDAOImpl();
                Student students = studentDAOInterface.ViewStudent(studentID);
                request.setAttribute("st", students);
                request.setAttribute("listA", attendance);
                request.getRequestDispatcher("Parent/Shedule.jsp").forward(request, response);
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(sheduleController.class.getName()).log(Level.SEVERE, null, e);
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
