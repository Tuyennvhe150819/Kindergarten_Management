/*
 * list teacher
 */
package controller.admin;

import dao.impl.TeacherDAOImpl;
import entity.Account;
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
import dao.TeacherDAOInterface;


@WebServlet(name = "ListAllTeacherAdmin", urlPatterns = {"/ListAllTeacherAdmin"})
public class ListAllTeacherAdminController extends HttpServlet {

     //View 5 teachers by page number *ADMIN*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Account acc = (Account) request.getSession().getAttribute("account");
            if (acc != null) {
                if (acc.getRole() == 0) {
                    String indexPage = request.getParameter("index");

                    if (indexPage == null) {
                        indexPage = "1";
                    }
                    int index = Integer.parseInt(indexPage);

                    TeacherDAOInterface teacherDAOImplement = new TeacherDAOImpl();

                    // get end page
                    int endPageTeacher = teacherDAOImplement.getNumberEndPageTeacher();
                    // List  5 teachers by page number
                    List<Teacher> teachers = teacherDAOImplement.PagingTeacher(index);

                    request.setAttribute("listTeacher", teachers);
                    request.setAttribute("endPageTeacher", endPageTeacher);
                    request.setAttribute("numPage", index);
                    //change to the TeacherAdmin.jsp
                    request.getRequestDispatcher("Admin/TeacherAdmin.jsp").forward(request, response);
                } else {
                    response.sendRedirect("Login");
                }
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(ListAllTeacherAdminController.class.getName()).log(Level.SEVERE, null, e);
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
