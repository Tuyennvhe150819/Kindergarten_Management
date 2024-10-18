/*
 * Update teacher admin 
 * 19-03-2023
 */
package controller.admin;

import dao.impl.TeacherDAOImpl;
import entity.Teacher;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.TeacherDAOInterface;

@WebServlet(name = "UpdateTeacherAdmin", urlPatterns = {"/UpdateTeacherAdmin"})
public class UpdateTeacherAdminController extends HttpServlet {

    /**
     *
     * Get id
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            TeacherDAOInterface teacherDAOImplement = new TeacherDAOImpl();
            Teacher teacher = teacherDAOImplement.ShowInfoTeacherByID(id);

            request.setAttribute("teacher", teacher);
            request.getRequestDispatcher("Admin/UpdateTeacherAdmin.jsp").forward(request, response);
        } catch (Exception e) {
            Logger.getLogger(UpdateTeacherAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     *
     * Update teacher from admin
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            int id = Integer.parseInt(request.getParameter("tid"));
            String img = request.getParameter("img");
            String firstName = request.getParameter("firstName").trim().replaceAll("\\s+", " ");
            String lastName = request.getParameter("lastName").trim().replaceAll("\\s+", " ");
            String phone = request.getParameter("phone").trim().replaceAll("\\s+", " ");
            String gender = request.getParameter("gender");
            String address = request.getParameter("address").trim().replaceAll("\\s+", " ");
            String birth = request.getParameter("birth");
            int yearOfEXp = Integer.parseInt(request.getParameter("yearOfEXp").trim().replaceAll("\\s+", " "));
            double salaryFixed = Double.parseDouble(request.getParameter("salaryFixed").trim().replaceAll("\\s+", " "));

            TeacherDAOInterface teacherDAOImplement = new TeacherDAOImpl();
            Teacher teacher = new Teacher(id, img, firstName, lastName, phone, gender, address, birth, yearOfEXp, salaryFixed);
            teacherDAOImplement.UpdateTeacher(teacher);
            request.setAttribute("mess", "Update succesfully");
            response.sendRedirect("ListAllTeacherAdmin");
        } catch (Exception e) {
            Logger.getLogger(UpdateTeacherAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
