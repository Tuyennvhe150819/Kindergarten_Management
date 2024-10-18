/*
 * Create Class
 * 09-02-2023
 */
package controller.admin;

import dao.impl.ClassDAOImpl;
import dao.impl.TeacherDAOImpl;
import dao.impl.TermDAOImpl;
import entity.Account;
import entity.Teacher;
import entity.Class;
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

@WebServlet(name = "CreateClassAD", urlPatterns = {"/CreateClassAD"})
public class CreateClassAdminController extends HttpServlet {

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
            Account acc = (Account) request.getSession().getAttribute("account");
            if (acc != null) {
                if (acc.getRole() == 0) {
                    TeacherDAOInterface teacherDAOImplement = new TeacherDAOImpl();
                    TermDAOInterface termDAOImplement = new TermDAOImpl();
                    // list all teacher name and teacher id to select teacher id
                    List<Teacher> teachers = teacherDAOImplement.getAllTeacher();
                    List<Term> terms = termDAOImplement.ShowTerm();

                    request.setAttribute("terms", terms);
                    request.setAttribute("teacher", teachers);
                    //change to the Create Class 
                    request.getRequestDispatcher("Admin/CreateClassAdmin.jsp").forward(request, response);
                } else {
                    response.sendRedirect("Login");
                }
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(CreateClassAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *///Create Class
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            // take teacher images from form Create Class
            String img = request.getParameter("image");
            // take teacher name from form Create Class
            String name = request.getParameter("name");
            // take teacher id from form Create Class
            int teacherID = Integer.parseInt(request.getParameter("teacherID"));
            // take term id from form Create Class
            int termID = Integer.parseInt(request.getParameter("termID"));

            ClassDAOInterface classDAOImplement = new ClassDAOImpl();
            Class classs = new Class(img, name, teacherID, termID);
            // add a class to database
            classDAOImplement.AddClass(classs);
            response.sendRedirect("ListAllClassAdmin");
        } catch (Exception e) {
            Logger.getLogger(CreateClassAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
