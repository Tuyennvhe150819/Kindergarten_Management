/*
 * View feedback Student parent
 * 27-02-2023
 */
package controller.parent;

import dao.impl.FeedbackDAOImpl;
import entity.FeedbackStudent;
import entity.Parent;
import java.io.IOException;
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
 * @author MSII
 */
@WebServlet(name = "ViewFeedBackStudentController", urlPatterns = {"/viewFeedBackStudent"})
public class ViewFeedBackStudentController extends HttpServlet {
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * list feedback student student of that parent
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Parent parent = (Parent) request.getSession().getAttribute("parent");
            if (parent != null) {
                int studentID = Integer.parseInt(request.getParameter("studentID"));
                FeedbackDAOInterface feedbackDAOInterface = new FeedbackDAOImpl();
                FeedbackStudent feedback = feedbackDAOInterface.ShowFeedBackStudent(studentID);
                request.setAttribute("feedback", feedback);
                request.getRequestDispatcher("Parent/ViewFeedbackStudent.jsp").forward(request, response);
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(ViewFeedBackStudentController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
