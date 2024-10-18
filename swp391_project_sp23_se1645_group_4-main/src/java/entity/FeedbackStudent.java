/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Asus
 */
public class FeedbackStudent {

    private int teacherID;
    private int studentID;
    private String teacherFirstName;
    private String teacherLastName;
    private String studentFirstName;
    private String studentLastName;
    private String note;
    private String rank;
    private String attitude;
    private String feedbackDay;

    public FeedbackStudent() {
    }

    public FeedbackStudent(int teacherID, int studentID, String teacherFirstName, String teacherLastName, String studentFirstName, String studentLastName, String note, String rank, String attitude, String feedbackDay) {
        this.teacherID = teacherID;
        this.studentID = studentID;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.note = note;
        this.rank = rank;
        this.attitude = attitude;
        this.feedbackDay = feedbackDay;
    }
    public FeedbackStudent(int teacherID, int studentID, String note, String rank, String attitude) {
        this.teacherID = teacherID;
        this.studentID = studentID;
        this.note = note;
        this.rank = rank;
        this.attitude = attitude;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getAttitude() {
        return attitude;
    }

    public void setAttitude(String attitude) {
        this.attitude = attitude;
    }

    public String getFeedbackDay() {
        return feedbackDay;
    }

    public void setFeedbackDay(String feedbackDay) {
        this.feedbackDay = feedbackDay;
    }

    @Override
    public String toString() {
        return "FeedbackStudent{" + "teacherID=" + teacherID + ", studentID=" + studentID + ", teacherFirstName=" + teacherFirstName + ", teacherLastName=" + teacherLastName + ", studentFirstName=" + studentFirstName + ", studentLastName=" + studentLastName + ", note=" + note + ", rank=" + rank + ", attitude=" + attitude + ", feedbackDay=" + feedbackDay + '}';
    }

}
