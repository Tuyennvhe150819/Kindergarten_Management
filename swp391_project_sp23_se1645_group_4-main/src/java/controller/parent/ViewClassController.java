/*
 * list class parent
 * 20-02-2023
 */
package controller.parent;

import dao.impl.StudentDAOImpl;
import entity.Parent;
import entity.Student;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.StudentDAOInterface;

/**
 * view class of son
 * @author MSII
 */
@WebServlet(name = "ViewClass", urlPatterns = {"/ViewClass"})
public class ViewClassController extends HttpServlet {

    /**
     * View all students in that class
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Parent parent = (Parent)request.getSession().getAttribute("parent");
        if(parent != null) {
            int classID = Integer.parseInt(request.getParameter("classID"));
            StudentDAOInterface studentDAOInterface = new StudentDAOImpl();
            List<Student> st = studentDAOInterface.ListViewStudent(classID);
            request.setAttribute("listStudent", st);
            request.getRequestDispatcher("Parent/StudentInAClass.jsp").forward(request, response);
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
}
