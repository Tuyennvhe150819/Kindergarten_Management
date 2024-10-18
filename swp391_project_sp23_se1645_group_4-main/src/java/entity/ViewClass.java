/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author MSII
 */
public class ViewClass {
    private int classID;
    private String classImg;
    private String className;
    private int teacherID;
    private int termID;
    private String termName;
    private String teacherFirstName;
    private String startdate;
    private String enddate;
    

    public ViewClass() {
    }

    public ViewClass(int classID, String classImg, String className, int teacherID, int termID, String termName, String teacherFirstName) {
        this.classID = classID;
        this.classImg = classImg;
        this.className = className;
        this.teacherID = teacherID;
        this.termID = termID;
        this.termName = termName;
        this.teacherFirstName = teacherFirstName;
    }

    public ViewClass(int classID, String className, int teacherID, int termID, String termName, String startdate, String enddate) {
        this.classID = classID;
        this.className = className;
        this.teacherID = teacherID;
        this.termID = termID;
        this.termName = termName;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getClassImg() {
        return classImg;
    }

    public void setClassImg(String classImg) {
        this.classImg = classImg;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public int getTermID() {
        return termID;
    }

    public void setTermID(int termID) {
        this.termID = termID;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    @Override
    public String toString() {
        return "ViewClass{" + "classID=" + classID + ", classImg=" + classImg + ", className=" + className + ", teacherID=" + teacherID + ", termID=" + termID + ", termName=" + termName + ", teacherFirstName=" + teacherFirstName + ", startdate=" + startdate + ", enddate=" + enddate + '}';
    }

}
