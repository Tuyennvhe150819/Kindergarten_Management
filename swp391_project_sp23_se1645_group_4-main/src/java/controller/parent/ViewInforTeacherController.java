/*
 * view teacher(parent)
 * 22-02-2023
 */
package controller.parent;

import dao.impl.TeacherDAOImpl;
import entity.Parent;
import entity.Teacher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.TeacherDAOInterface;

/**
 *
 * View information teacher of child
 */
@WebServlet(name = "ViewInforTeacher", urlPatterns = {"/ViewInforTeacher"})
public class ViewInforTeacherController extends HttpServlet {

    /**
     * View information of the teacher teaching that class
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Parent parent = (Parent) request.getSession().getAttribute("parent");
        if (parent != null) {
            int studentID = Integer.parseInt(request.getParameter("studentID"));
            TeacherDAOInterface teacherDAOInterface = new TeacherDAOImpl();
            Teacher teacher = teacherDAOInterface.TeacherInfor(studentID);
            request.setAttribute("teach", teacher);
            request.getRequestDispatcher("Parent/ViewProfileTeacher.jsp").forward(request, response);
        }else{
            response.sendRedirect("Login");
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
