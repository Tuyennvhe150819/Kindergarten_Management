/*
 * Register teacher
 * 10-03-2023
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


@WebServlet(name = "CreateTeacherAD", urlPatterns = {"/CreateTeacherAD"})
public class CreateTeacherAdminController extends HttpServlet {


    /**
     *Create a Teacher *ADMIN*
     **/ 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            String img = request.getParameter("img");
            String firstName = request.getParameter("firstName").trim().replaceAll("\\s+"," ");
            String lastName = request.getParameter("lastName").trim().replaceAll("\\s+"," ");
            String phone = request.getParameter("phone").trim().replaceAll("\\s+"," ");
            String gender = request.getParameter("gender");
            String address = request.getParameter("address").trim().replaceAll("\\s+"," ");
            String birth = request.getParameter("birth");
            int yearOfEXp = Integer.parseInt(request.getParameter("yearOfEXp"));
            double salaryFixed = Double.parseDouble(request.getParameter("salaryFixed"));

            TeacherDAOInterface teacherDAOImplement = new TeacherDAOImpl();
            Teacher teacher = new Teacher(img, firstName, lastName, phone, gender, address, birth, yearOfEXp, salaryFixed);
            teacherDAOImplement.AddTeacher(teacher);
            response.sendRedirect("ListAllTeacherAdmin");
        } catch (Exception e) {
            Logger.getLogger(CreateTeacherAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
