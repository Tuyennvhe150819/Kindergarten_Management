/*
 * list student
 * 18-02-2023
 */
package controller.parent;

import dao.impl.StudentDAOImpl;
import entity.Parent;
import entity.Student;
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


@WebServlet(name = "ListStudent", urlPatterns = {"/ListStudent"})
public class ListStudentController extends HttpServlet {

    /**
     * list student by parent id
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Parent parent = (Parent) request.getSession().getAttribute("parent");
            if (parent != null) {
                int parentID = Integer.parseInt(request.getParameter("parentID"));
                StudentDAOInterface studentDAOInterface = new StudentDAOImpl();
                List<Student> students = studentDAOInterface.ListStudent(parentID);
                request.setAttribute("listStudent", students);
                request.getRequestDispatcher("Parent/ViewStudent.jsp").forward(request, response);
            } else {
                response.sendRedirect("Login");
            }
        }catch(Exception e) {
            Logger.getLogger(ListStudentController.class.getName()).log(Level.SEVERE, null, e);
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
