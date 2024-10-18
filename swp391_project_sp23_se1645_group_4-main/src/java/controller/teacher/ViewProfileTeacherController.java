/*
 * view teacher (teacher)
 * 16-02-2023
 */
package controller.teacher;

import entity.Teacher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ViewProfileTeacher", urlPatterns = {"/ViewProfileTeacher"})
public class ViewProfileTeacherController extends HttpServlet {
    /**
     * view profile that teacher
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Teacher teacher = (Teacher) request.getSession().getAttribute("teach");
        if(teacher != null) {
            request.getRequestDispatcher("Teacher/profileTeacher.jsp").forward(request, response);
        }else {
            response.sendRedirect("Login");
        }
    }
}
