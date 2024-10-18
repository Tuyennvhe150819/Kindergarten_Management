/*
 * update attendance admin
 * 27-02-2023
 */
package controller.admin;

import dao.impl.AttendanceDAOImpl;
import dao.impl.ClassDAOImpl;
import entity.Attendance;
import entity.ViewClass;
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
import dao.ClassDAOInterface;


@WebServlet(name = "UpdateAttendanceAdmin", urlPatterns = {"/UpdateAttendanceAdmin"})
public class UpdateAttendanceAdminController extends HttpServlet {
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
            ClassDAOInterface classDAOImplement = new ClassDAOImpl();
            AttendanceDAOInterface attendanceDAOImplement = new AttendanceDAOImpl();
            
            // take attendance id of Attendance which you want to update
            int id = Integer.parseInt(request.getParameter("id"));

            Attendance attendance = attendanceDAOImplement.ViewAttendanceByID(id);
            List<ViewClass> classes = classDAOImplement.showAClass();

            request.setAttribute("attendance", attendance);
            request.setAttribute("class", classes);

            request.getRequestDispatcher("Admin/UpdateAttendanceAdmin.jsp").forward(request, response);
        } catch (Exception e) {
            Logger.getLogger(UpdateAttendanceAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *///Update Attendance *ADMIN*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            // take attendID from form Update Attendance
            int attendID = Integer.parseInt(request.getParameter("attendID"));
            // take title from form Update Attendance
            String title = request.getParameter("title");
            // take Attendance Date  from form Update Attendance
            String attendanceDate = request.getParameter("attendanceDate");
            // take classID from form Update Attendance
            int classID = Integer.parseInt(request.getParameter("classID"));

            AttendanceDAOInterface attendanceDAOImplement = new AttendanceDAOImpl();         
            Attendance attendance = new Attendance(attendID, attendanceDate, title, classID);
            // Update information of Attendance to database
            attendanceDAOImplement.UpdateAttendance(attendance);
            //change to the Class Admin
            response.sendRedirect("ListAllAttendanceAdmin");
        } catch (Exception e) {
            Logger.getLogger(UpdateClassAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
