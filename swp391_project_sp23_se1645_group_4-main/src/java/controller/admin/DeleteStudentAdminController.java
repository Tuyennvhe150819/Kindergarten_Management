/*
 * Delete student
 * 19-02-2023
 */
package controller.admin;

import dao.impl.StudentDAOImpl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.StudentDAOInterface;

@WebServlet(name = "DeleteStudentAD", urlPatterns = {"/DeleteStudentAD"})
public class DeleteStudentAdminController extends HttpServlet {

    /**
     *Delete Student *Admin* 
     **/
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            int id = Integer.parseInt(request.getParameter("deid"));
            StudentDAOInterface studentDAOImplement = new StudentDAOImpl();
            studentDAOImplement.deleteStudent(id);
            response.sendRedirect("ListAllStudentAdmin");
        } catch (Exception e) {
            Logger.getLogger(DeleteStudentAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
