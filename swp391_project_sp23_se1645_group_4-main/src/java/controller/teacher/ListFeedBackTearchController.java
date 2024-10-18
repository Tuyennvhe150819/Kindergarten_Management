/*
 * View Feedback teacher (teacher)
 * 27-02-2023
 */
package controller.teacher;

import dao.impl.FeedbackDAOImpl;
import entity.FeedBackTeacher;
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
import dao.FeedbackDAOInterface;


@WebServlet(name = "ListFeedBackTearchController", urlPatterns = {"/listFeedBackTearch"})
public class ListFeedBackTearchController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * that teacher's feedback list
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Teacher teacher = (Teacher) request.getSession().getAttribute("teach");
            if (teacher != null) {
                String indexPage = request.getParameter("index");

                if (indexPage == null) {
                    indexPage = "1";
                }
                int index = Integer.parseInt(indexPage);

                FeedbackDAOInterface feedbackTeacherDAOImplement = new FeedbackDAOImpl();

                // get end page
                int endPageFeedBackTeacher = feedbackTeacherDAOImplement.getNumberEndPageFeedBackTeacher();
                // List  5 FeedBackTeacher by page number
                List<FeedBackTeacher> feedBackTeachers = feedbackTeacherDAOImplement.ListFeedbackTeacher(index, teacher.getTeacherID());

                request.setAttribute("listFeedBackTeachers", feedBackTeachers);
                request.setAttribute("endPageFeedBackTeacher", endPageFeedBackTeacher);
                request.setAttribute("numPage", index);
                //change to the FeedbackTeacherAdmin.jsp
                request.getRequestDispatcher("Teacher/ViewFeedBackTeacher.jsp").forward(request, response);
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(ListFeedBackTearchController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
