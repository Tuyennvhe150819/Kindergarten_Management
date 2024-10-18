/*
 * view teacher admin
 * 21-02-2023
 */
package controller.admin;

import dao.impl.TeacherDAOImpl;
import entity.Teacher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.TeacherDAOInterface;


@WebServlet(name = "ViewInforTeacherAD", urlPatterns = {"/ViewInforTeacherAD"})
public class ViewInforTeacherAdminController extends HttpServlet {

    
    //* View Information of teacher by Teacher ID *ADMIN CLASS*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            int teacherID = Integer.parseInt(request.getParameter("teacherID"));
            TeacherDAOInterface dao = new TeacherDAOImpl();
            Teacher t = dao.ShowInfoTeacherByID(teacherID);
            request.setAttribute("viewInfoTeacher", t);
            request.getRequestDispatcher("Admin/ListInfoTeacherInClassAdmin.jsp").forward(request, response);
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
