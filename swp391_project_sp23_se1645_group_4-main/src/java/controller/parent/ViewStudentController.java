/*
 * view student parent
 * 14-02-2023
 */
package controller.parent;

import dao.impl.ClassDAOImpl;
import dao.impl.StudentDAOImpl;
import dao.impl.TeacherDAOImpl;
import entity.Parent;
import entity.Class;
import entity.Student;
import entity.Teacher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ClassDAOInterface;
import dao.StudentDAOInterface;
import dao.TeacherDAOInterface;

/**
 * view information that parent son
 * @author MSII
 */
@WebServlet(name = "ViewStudent", urlPatterns = {"/ViewStudent"})
public class ViewStudentController extends HttpServlet {

    /**
     * View all information of that student
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Parent parent = (Parent)request.getSession().getAttribute("parent");
        if(parent != null) {
            int studentID = Integer.parseInt(request.getParameter("studentID"));
            StudentDAOInterface studentDAOInterface = new StudentDAOImpl();
            ClassDAOInterface classDAOInterface = new ClassDAOImpl();
            TeacherDAOInterface teacherDAOInterface = new TeacherDAOImpl();
            Student st = studentDAOInterface.ViewStudent(studentID);
            Class clas =  classDAOInterface.ShowClass(studentID);
            Teacher teacher = teacherDAOInterface.TeacherInfor(studentID);
            request.setAttribute("teacher", teacher);
            request.setAttribute("clas", clas);
            request.setAttribute("st", st);
            request.getRequestDispatcher("Parent/profileStudent.jsp").forward(request, response);
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
