/*
 * Create feedback student && Update feedback student
 * 19-03-2023  
 */
package controller.teacher;

import dao.impl.FeedbackDAOImpl;
import dao.impl.StudentDAOImpl;
import entity.FeedbackStudent;
import entity.Student;
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
import dao.StudentDAOInterface;

@WebServlet(name = "FeedBackStudent", urlPatterns = {"/FeedBackStudent"})
public class FeedBackStudentController extends HttpServlet {

    /**
     * Get role
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Teacher teacher = (Teacher) request.getSession().getAttribute("teach");
            if (teacher != null) {
                int studentID = Integer.parseInt(request.getParameter("studentID"));
                StudentDAOInterface studentDAOInterface = new StudentDAOImpl();
                FeedbackDAOInterface feedbackDAOInterface = new FeedbackDAOImpl();
                FeedbackStudent feedback = feedbackDAOInterface.ShowFeedBackStudent(studentID);
                Student student = studentDAOInterface.ViewStudent(studentID);
                request.setAttribute("feedback", feedback);
                request.setAttribute("student", student);
                request.getRequestDispatcher("Teacher/FeedBackStudent.jsp").forward(request, response);
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(FeedBackStudentController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Create feedback student && Update feedback student
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            int studentID = Integer.parseInt(request.getParameter("studentID"));
            String classID = request.getParameter("classID");
            FeedbackDAOInterface feedbackDAOInterface = new FeedbackDAOImpl();
            FeedbackStudent feedback = feedbackDAOInterface.ShowFeedBackStudent(studentID);
            Teacher teacher = (Teacher) request.getSession().getAttribute("teach");
            if (feedback != null) {
                String note = request.getParameter("assessment").trim().replaceAll("\\s+"," ");
                String rank = request.getParameter("rating").trim().replaceAll("\\s+"," ");
                String attitude = request.getParameter("attitude").trim().replaceAll("\\s+"," ");
                FeedbackStudent feedback1 = new FeedbackStudent(teacher.getTeacherID(), studentID, note, rank, attitude);
                feedbackDAOInterface.updateFeedBackStudent(feedback1);
                response.sendRedirect("ViewStudentInClass?classID=" + classID);

            } else {
                String note = request.getParameter("assessment").trim().replaceAll("\\s+"," ");
                String rank = request.getParameter("rating").trim().replaceAll("\\s+"," ");
                String attitude = request.getParameter("attitude").trim().replaceAll("\\s+"," ");
                FeedbackStudent feedback1 = new FeedbackStudent(teacher.getTeacherID(), studentID, note, rank, attitude);
                feedbackDAOInterface.feedbackStudent(feedback1);
                response.sendRedirect("ViewStudentInClass?classID=" + classID);
            }
        } catch (Exception e) {
            Logger.getLogger(FeedBackStudentController.class.getName()).log(Level.SEVERE, null, e);
        }

    }

}
