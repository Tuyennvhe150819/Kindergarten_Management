/*
 * update student admin
 * 14-03-203
 */
package controller.admin;

import dao.impl.ClassDAOImpl;
import dao.impl.StudentDAOImpl;
import entity.Student;
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
import dao.ClassDAOInterface;
import dao.StudentDAOInterface;

@WebServlet(name = "UpdateStudentAdmin", urlPatterns = {"/UpdateStudentAdmin"})
public class UpdateStudentAdminController extends HttpServlet {

    /**
     *
     * Get id 
     * take student id of Student which you want to update
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            StudentDAOInterface studentDAOImplement = new StudentDAOImpl();
            ClassDAOInterface classDAOImplement = new ClassDAOImpl();
            Student student = studentDAOImplement.ViewStudent(id);
            List<ViewClass> viewClasses = classDAOImplement.showAClass();

            request.setAttribute("student", student);
            request.setAttribute("class", viewClasses);
            request.getRequestDispatcher("Admin/UpdateStudentAdmin.jsp").forward(request, response);
        } catch (Exception e) {
            Logger.getLogger(UpdateStudentAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     *
     * Update student from Admin
     * Update information of student to database
     * change to the Student Admin
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            int id = Integer.parseInt(request.getParameter("stid"));
            String img = request.getParameter("img");
            String firstName = request.getParameter("firstName").trim().replaceAll("\\s+", " ");
            String lastName = request.getParameter("lastName").trim().replaceAll("\\s+", " ");
            String gender = request.getParameter("gender");
            String likeSomething = request.getParameter("likeSomething").trim().replaceAll("\\s+", " ");
            String hateSomething = request.getParameter("hateSomething").trim().replaceAll("\\s+", " ");
            String favoriteFood = request.getParameter("favoriteFood").trim().replaceAll("\\s+", " ");
            String hateFood = request.getParameter("hateFood").trim().replaceAll("\\s+", " ");
            String birth = request.getParameter("birth");
            int classid = Integer.parseInt(request.getParameter("ClassId"));
            StudentDAOInterface studentDAOImplement = new StudentDAOImpl();
            Student student = new Student(id, img, firstName, lastName, gender, likeSomething, hateSomething, favoriteFood, hateFood, birth, classid);
            studentDAOImplement.UpdateStudent(student);
            response.sendRedirect("ListAllStudentAdmin");
        } catch (Exception e) {
            Logger.getLogger(UpdateStudentAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
