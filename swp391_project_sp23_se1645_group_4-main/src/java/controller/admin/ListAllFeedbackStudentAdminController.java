/*
 * list feedback student admin
 * 19-03-2023
 */
package controller.Admin;

import dao.impl.FeedbackDAOImpl;
import entity.Account;
import entity.FeedbackStudent;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.FeedbackDAOInterface;

/**
 *
 * @author Asus
 */
@WebServlet(name = "ListAllFeedbackStudentAdmin", urlPatterns = {"/ListAllFeedbackStudentAdmin"})
public class ListAllFeedbackStudentAdminController extends HttpServlet {

    /**
     * List feedback student
     */
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

                    FeedbackDAOInterface feedbackStudentDAOImplement = new FeedbackDAOImpl();

                    int endPageFeedbackStudent = feedbackStudentDAOImplement.getNumberEndPageFeedbackStudent();
                    List<FeedbackStudent> feedbackStudents = feedbackStudentDAOImplement.PagingFeedbackStudent(index);

                    request.setAttribute("feedbackStudents", feedbackStudents);
                    request.setAttribute("endPageFeedbackStudent", endPageFeedbackStudent);
                    request.setAttribute("numPage", index);
                    request.getRequestDispatcher("Admin/FeedbackStudentAdmin.jsp").forward(request, response);
                } else {
                    response.sendRedirect("Login");
                }
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(ListAllFeedbackStudentAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
