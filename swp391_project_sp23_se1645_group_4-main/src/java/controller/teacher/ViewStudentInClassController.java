/*
 * list student teacher
 * 14-02-2023
 */
package controller.teacher;

import dao.impl.StudentDAOImpl;
import entity.Student;
import entity.Teacher;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.StudentDAOInterface;


@WebServlet(name = "ViewStudentInClass", urlPatterns = {"/ViewStudentInClass"})
public class ViewStudentInClassController extends HttpServlet {

    /**
     * view student in a class
     * list student int a class
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Teacher teacher = (Teacher) request.getSession().getAttribute("teach");
            if (teacher != null) {
                int classID = Integer.parseInt(request.getParameter("classID"));
                StudentDAOInterface studentDAOInterface = new StudentDAOImpl();
                List<Student> st = studentDAOInterface.ListViewStudent(classID);
                request.setAttribute("listStudent", st);
                request.getRequestDispatcher("Teacher/ViewStudentInClass.jsp").forward(request, response);
            } else {
                response.sendRedirect("Login");
            }
        }catch(Exception e){
            Logger.getLogger(ViewStudentInClassController.class.getName()).log(Level.SEVERE, null, e);
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
