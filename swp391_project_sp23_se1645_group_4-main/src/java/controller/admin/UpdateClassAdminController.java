/*
 * update class admin
 * 18-02-2023
 */
package controller.admin;

import dao.impl.ClassDAOImpl;
import dao.impl.TeacherDAOImpl;
import dao.impl.TermDAOImpl;
import entity.Class;
import entity.Teacher;
import entity.Term;
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
import dao.TeacherDAOInterface;
import dao.TermDAOInterface;


@WebServlet(name = "UpdateClassAdmin", urlPatterns = {"/UpdateClassAdmin"})
public class UpdateClassAdminController extends HttpServlet {

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
            TeacherDAOInterface teacherDAOImplement = new TeacherDAOImpl();
            TermDAOInterface termDAOImplement = new TermDAOImpl();
            // take class id of Class which you want to update
            int id = Integer.parseInt(request.getParameter("id"));
            // From class id which you take all information of class
            Class classs = classDAOImplement.ViewClassByID(id);
            List<Teacher> teachers = teacherDAOImplement.getAllTeacher();
            List<Term> terms = termDAOImplement.ShowTerm();

            request.setAttribute("class", classs);
            request.setAttribute("terms", terms);
            request.setAttribute("teacher", teachers);
            request.getRequestDispatcher("Admin/UpdateClassAdmin.jsp").forward(request, response);
        } catch (Exception e) {
            Logger.getLogger(UpdateClassAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *///Update Class *ADMIN*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            // take classid from form Update Class
            int id = Integer.parseInt(request.getParameter("cid"));
            // take class image from form Update Class
            String image = request.getParameter("image");
            // take class name from form Update Class
            String name = request.getParameter("name");
            // take teacher id from form Update Class
            int teacherID = Integer.parseInt(request.getParameter("teacherID"));
            // take term id from form Update Class
            int termID = Integer.parseInt(request.getParameter("termID"));

            ClassDAOInterface classDAOImplement = new ClassDAOImpl();
            Class classs = new Class(id, image, name, teacherID, termID);
            // Update information of class to database
            classDAOImplement.UpdateClass(classs);
            //change to the Class Admin
            response.sendRedirect("ListAllClassAdmin");
        } catch (Exception e) {
            Logger.getLogger(UpdateClassAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
