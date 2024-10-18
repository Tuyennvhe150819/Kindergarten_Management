/*
 * list student admin
 */
package controller.admin;

import dao.impl.StudentDAOImpl;
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
import javax.servlet.http.HttpSession;
import dao.StudentDAOInterface;


@WebServlet(name = "ListAllSTByClassId", urlPatterns = {"/ListAllSTByClassId"})
public class ListAllStudentByClassIdAdminController extends HttpServlet {

    
    //* List All Student In CLass By Class Id *Admin*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            //take class id to list all student in class 
            int classID = Integer.parseInt(request.getParameter("classID"));
            StudentDAOInterface studentDAOImplement = new StudentDAOImpl();
            List<Student> students = studentDAOImplement.ListViewStudent(classID);
            // List all students from databse and put in the variable students 
            request.setAttribute("listStudent", students);
            // set class id in ExportListAllStudentinClass to export file excel list all student in class 
            session.setAttribute("classID", classID);
            //change to the ListAllStudentInClassAdmin.jsp
            request.getRequestDispatcher("Admin/ListAllStudentInClassAdmin.jsp").forward(request, response);
        } catch (Exception e) {
            Logger.getLogger(ListAllStudentByClassIdAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
