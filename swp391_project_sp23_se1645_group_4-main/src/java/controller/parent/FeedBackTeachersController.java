/*
 * Create feedback teacher && Update feedback teacher
 * 20-02-2023
 */
package controller.parent;

import dao.impl.FeedbackDAOImpl;
import dao.impl.TeacherDAOImpl;
import entity.FeedBackTeacher;
import entity.Parent;
import entity.Teacher;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.FeedbackDAOInterface;
import dao.TeacherDAOInterface;

@WebServlet(name = "FeedBackTeacher", urlPatterns = {"/FeedBackTeacher"})
public class FeedBackTeachersController extends HttpServlet {
    /**
     * Create feedback teacher && Update feedback teacher
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Parent parent = (Parent) request.getSession().getAttribute("parent");
        if (parent != null) {
            int teacherID = Integer.parseInt(request.getParameter("teacherID"));
            TeacherDAOInterface teacherDAOInterface = new TeacherDAOImpl();
            Teacher teacher = teacherDAOInterface.ShowInfoTeacherByID(teacherID);
            FeedbackDAOInterface feedbackRepository = new FeedbackDAOImpl();
            FeedBackTeacher feedBackTeacher = feedbackRepository.ShowFeedBackTeacher(teacherID);
            request.setAttribute("feedback", feedBackTeacher);
            request.setAttribute("teach", teacher);
            request.getRequestDispatcher("Parent/FeedBackTeacher.jsp").forward(request, response);
        } else {
            response.sendRedirect("Login");
        }
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            int teacherID = Integer.parseInt(request.getParameter("teacherID"));
            FeedbackDAOInterface feedbackDAOInterface = new FeedbackDAOImpl();
            String classID = request.getParameter("classID");
            FeedBackTeacher feedBackTeacher = feedbackDAOInterface.ShowFeedBackTeacher(teacherID);
            Parent parent = (Parent) request.getSession().getAttribute("parent");
            if (feedBackTeacher == null) {
                String note = request.getParameter("assessment");
                String rank = request.getParameter("rating");
                String attitude = request.getParameter("attitude");
                FeedBackTeacher feedBackTeacher1 = new FeedBackTeacher(teacherID, parent.getParentID(), note, rank, attitude);
                feedbackDAOInterface.feedbackTeacher(feedBackTeacher1);
                response.sendRedirect("ListStudent?parentID=" + classID );
            } else {
                String note = request.getParameter("assessment");
                String rank = request.getParameter("rating");
                String attitude = request.getParameter("attitude");
                FeedBackTeacher feedBackTeacher1 = new FeedBackTeacher(teacherID, parent.getParentID(), note, rank, attitude);
                feedbackDAOInterface.updateFeedBackTeacher(feedBackTeacher1);
                response.sendRedirect("ListStudent?parentID=" + classID );
            }
        }catch(Exception e) {
            Logger.getLogger(FeedBackTeachersController.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}
