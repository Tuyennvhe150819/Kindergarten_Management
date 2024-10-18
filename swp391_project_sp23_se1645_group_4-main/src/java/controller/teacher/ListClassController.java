/*
 * list class
 * 14-02-2023
 */
package controller.teacher;

import dao.impl.ClassDAOImpl;
import entity.Teacher;
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

/**
 * list all class by teacher
 *
 * @author MSII
 */
@WebServlet(name = "ListClass", urlPatterns = {"/ListClass"})
public class ListClassController extends HttpServlet {

    /**
     * list class by teacher ID
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Teacher teacher = (Teacher) request.getSession().getAttribute("teach");
            if (teacher != null) {
                ClassDAOInterface classDAOInterface = new ClassDAOImpl();
                List<ViewClass> viewClasses = classDAOInterface.ListClass(teacher.getTeacherID());
                request.setAttribute("classs", viewClasses);
                request.getRequestDispatcher("Teacher/ViewClass.jsp").forward(request, response);
            } else {
                response.sendRedirect("Login");
            }
        }catch(Exception e) {
            Logger.getLogger(ListClassController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

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
        processRequest(request, response);
    }
}
