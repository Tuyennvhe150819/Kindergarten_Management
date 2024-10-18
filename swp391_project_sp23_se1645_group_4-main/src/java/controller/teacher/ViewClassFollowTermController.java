/*
 * list class
 * 18-02-2023
 */
package controller.teacher;

import dao.impl.ClassDAOImpl;
import entity.Teacher;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ClassDAOInterface;

/**
 * view class follow term by that teacher
 * @author MSII
 */
@WebServlet(name = "ViewClassFollowTerm", urlPatterns = {"/ViewClassFollowTerm"})
public class ViewClassFollowTermController extends HttpServlet {

    /**
     * view class follow term by that teacher
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Teacher teacher = (Teacher) request.getSession().getAttribute("teach");
        if(teacher != null) {
            ClassDAOInterface classDAOInterface = new ClassDAOImpl();
            int termID = Integer.parseInt(request.getParameter("termID"));
            List<entity.ViewClass> cl = classDAOInterface.ListClassTerm(termID, teacher.getTeacherID());
            request.setAttribute("classs", cl);
            request.getRequestDispatcher("Teacher/ViewClass.jsp").forward(request, response);
        }else {
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
