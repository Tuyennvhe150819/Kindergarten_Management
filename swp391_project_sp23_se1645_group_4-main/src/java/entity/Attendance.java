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
public class Attendance {

    private int dateweek;
    private int attendanceID;
    private String attendanceDate;
    private String title;
    private int status;
    private int studentID;
    private String note;
    private String className;
    private int classID;
    private String studentFirstName;
    private String studentLastName;

    public Attendance() {
    }

    public Attendance(int attendanceID, String attendanceDate, String title, int classID) {
        this.attendanceID = attendanceID;
        this.attendanceDate = attendanceDate;
        this.title = title;
        this.classID = classID;
    }

    public Attendance(int dateweek, int attendanceID, String attendanceDate, String title, int status, int studentID, String note, String className, int classID) {
        this.dateweek = dateweek;
        this.attendanceID = attendanceID;
        this.attendanceDate = attendanceDate;
        this.title = title;
        this.status = status;
        this.studentID = studentID;
        this.note = note;
        this.className = className;
        this.classID = classID;
    }
     public Attendance(String attendanceDate, String title, int classID) {
        this.attendanceDate = attendanceDate;
        this.title = title;
        this.classID = classID;
    }

    public int getDateweek() {
        return dateweek;
    }

    public void setDateweek(int dateweek) {
        this.dateweek = dateweek;
    }

    public int getAttendanceID() {
        return attendanceID;
    }

    public void setAttendanceID(int attendanceID) {
        this.attendanceID = attendanceID;
    }

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
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

    @Override
    public String toString() {
        return "Attendance{" + "dateweek=" + dateweek + ", attendanceID=" + attendanceID + ", attendanceDate=" + attendanceDate + ", title=" + title + ", status=" + status + ", studentID=" + studentID + ", note=" + note + ", className=" + className + ", classID=" + classID + ", studentFirstName=" + studentFirstName + ", studentLastName=" + studentLastName + '}';
    }

}
