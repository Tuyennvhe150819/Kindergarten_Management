/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author quang
 */
public class FeedBackTeacher {

    private int teacherID;
    private int parentID;
    private String teacherFirstName;
    private String teacherLastName;
    private String parentFirstName;
    private String parentLastName;
    private String note;
    private String rank;
    private String attitude;
    private String feedbackDay;
    private int classID;

    public FeedBackTeacher() {
    }

    public FeedBackTeacher(int teacherID, int parentID, String teacherFirstName, String teacherLastName, String parentFirstName, String parentLastName, String note, String rank, String attitude, String feedbackDay) {
        this.teacherID = teacherID;
        this.parentID = parentID;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.parentFirstName = parentFirstName;
        this.parentLastName = parentLastName;
        this.note = note;
        this.rank = rank;
        this.attitude = attitude;
        this.feedbackDay = feedbackDay;
    }

    public FeedBackTeacher(int teacherID, int parentID, String note, String rank, String attitude) {
        this.teacherID = teacherID;
        this.parentID = parentID;
        this.note = note;
        this.rank = rank;
        this.attitude = attitude;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
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

    public String getParentFirstName() {
        return parentFirstName;
    }

    public void setParentFirstName(String parentFirstName) {
        this.parentFirstName = parentFirstName;
    }

    public String getParentLastName() {
        return parentLastName;
    }

    public void setParentLastName(String parentLastName) {
        this.parentLastName = parentLastName;
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
        return "FeedBackTeacher{" + "teacherID=" + teacherID + ", parentID=" + parentID + ", teacherFirstName=" + teacherFirstName + ", teacherLastName=" + teacherLastName + ", parentFirstName=" + parentFirstName + ", parentLastName=" + parentLastName + ", note=" + note + ", rank=" + rank + ", attitude=" + attitude + ", feedbackDay=" + feedbackDay + '}';
    }
}
