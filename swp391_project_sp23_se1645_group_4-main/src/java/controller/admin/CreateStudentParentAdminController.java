/*
 * Add student
 * 09-03-2023
 */
package controller.admin;

import dao.impl.StudentDAOImpl;
import entity.Parent;
import entity.Student;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.StudentDAOInterface;

/**
 *
 */
@WebServlet(name = "CreateSTParent", urlPatterns = {"/CreateSTParent"})
public class CreateStudentParentAdminController extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */// Create new Student and new Parent *Admin*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            //---------------STUDENT-------------------------
            String imgST = request.getParameter("imgST");
            String firstNameST = request.getParameter("firstNameST").trim().replaceAll("\\s+"," ");;
            String lastNameST = request.getParameter("lastNameST").trim().replaceAll("\\s+"," ");;
            String genderST = request.getParameter("genderST");
            String likeSomethingST = request.getParameter("likeSomethingST").trim().replaceAll("\\s+"," ");;
            String hateSomethingST = request.getParameter("hateSomethingST").trim().replaceAll("\\s+"," ");;
            String favoriteFoodST = request.getParameter("favoriteFoodST").trim().replaceAll("\\s+"," ");;
            String hateFoodST = request.getParameter("hateFoodST").trim().replaceAll("\\s+"," ");;
            String birthST = request.getParameter("birthST");
            int classid = Integer.parseInt(request.getParameter("ClassId"));

            //---------------PARENTS-----------------
            String imgPA = request.getParameter("imgPA");
            String firstNamePA = request.getParameter("firstNamePA").trim().replaceAll("\\s+"," ");;
            String lastNamePA = request.getParameter("lastNamePA").trim().replaceAll("\\s+"," ");;
            String phonePA = request.getParameter("phonePA").trim().replaceAll("\\s+"," ");;
            String birthPA = request.getParameter("birthPA");
            String addressPA = request.getParameter("addressPA").trim().replaceAll("\\s+"," ");;
            String jobPA = request.getParameter("jobPA").trim().replaceAll("\\s+"," ");;

            StudentDAOInterface studentDAOImplement = new StudentDAOImpl();
            Parent parent = new Parent(imgPA, firstNamePA, lastNamePA, phonePA, birthPA, addressPA, jobPA);
            Student student = new Student(imgST, firstNameST, lastNameST, genderST, likeSomethingST, hateSomethingST, favoriteFoodST, hateFoodST, birthST, classid);
            // add a parent and a student
            studentDAOImplement.AddInfoStudentParent(parent, student);
            response.sendRedirect("ListAllStudentAdmin");
        } catch (Exception e) {
            Logger.getLogger(CreateStudentParentAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
