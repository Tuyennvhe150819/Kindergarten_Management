/*
 * update teacher (teacher)
 * 20-02-2023
 */
package controller.teacher;

import dao.impl.TeacherDAOImpl;
import entity.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.TeacherDAOInterface;


@WebServlet(name = "updateProfileTeach", urlPatterns = {"/updateProfileTeach"})
public class updateProfileTeachController extends HttpServlet {

    /**
     * view profile that teacher
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Teacher teacher = (Teacher) request.getSession().getAttribute("teach");
        if(teacher != null) {
            request.getRequestDispatcher("Teacher/UpdateProfileTeacher.jsp").forward(request, response);
        }else {
            response.sendRedirect("Login");
        }
    }
    /**
     * update profile teacher
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            Teacher teacher = (Teacher) request.getSession().getAttribute("teach");
            if (teacher != null) {
                String img = request.getParameter("img");
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                String phone = request.getParameter("phone");
                String date = request.getParameter("date");
                String address = request.getParameter("address");
                TeacherDAOInterface teacherRepository = new TeacherDAOImpl();
                teacherRepository.UpdateProfileTeacher(teacher.getTeacherID(), firstname, lastname, phone, img, address, date);
                response.sendRedirect("ViewTerm");
            } else if (teacher == null) {
                response.sendRedirect("Login");
            }
        }catch(Exception e) {
            Logger.getLogger(updateProfileTeachController.class.getName()).log(Level.SEVERE, null, e);
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
