/*
 * list student
 * 15-02-2023
 */
package controller.parent;

import dao.impl.StudentDAOImpl;
import entity.Parent;
import entity.Student;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.StudentDAOInterface;

/**
 *
 * @author MSII
 */
@WebServlet(name = "ViewStudentToSchedule", urlPatterns = {"/viewStudentToSchedule"})
public class ViewStudentToScheduleController extends HttpServlet {
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * list of students to see the student's class schedule
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Parent parent = (Parent)request.getSession().getAttribute("parent");
        if(parent != null) {
            StudentDAOInterface studentDAOInterface = new StudentDAOImpl();
            List<Student> students = studentDAOInterface.ListStudent(parent.getParentID());
            request.setAttribute("ListS", students);
            request.getRequestDispatcher("Parent/StudentShedule.jsp").forward(request, response);
        }else {
            response.sendRedirect("Login");
        }
    }
}
