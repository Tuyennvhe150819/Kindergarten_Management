/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.FeedBackTeacher;
import entity.FeedbackStudent;
import java.util.List;



public interface FeedbackDAOInterface {
    // give feedback to students
    public void feedbackStudent(FeedbackStudent feedback);
    // check if that student feedback is there or not
    public FeedbackStudent ShowFeedBackStudent (int studentID);
    // check if the teacher's feedback is there or not
    public FeedBackTeacher ShowFeedBackTeacher (int teacherID);
    // update feedback student
    public void updateFeedBackStudent(FeedbackStudent feedback);
    // give feedback to teachers
    public void feedbackTeacher(FeedBackTeacher feedBackTeacher);
    // update feedback teacher
    public void updateFeedBackTeacher(FeedBackTeacher feedBackTeacher);
     // View FeedbackStudent
    public List<FeedbackStudent> ListFeedbackStudent();

    // Get end page
    public int getNumberEndPageFeedbackStudent();

    // List  5 FeedbackStudent by page
    public List<FeedbackStudent> PagingFeedbackStudent(int index);
    // View FeedbackTeacher
    public List<FeedBackTeacher> ListFeedbackTeacher(int index, int teachID);

    // List  5 FeedBackTeacher by page
    public List<FeedBackTeacher> PagingFeedBackTeacher(int index);

    // Get end page
    public int getNumberEndPageFeedBackTeacher();
}
