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
public class Class {

    private int classID;
    private String classImg;
    private String className;
    private int teacherID;
    private int termID;

    public Class() {
    }

    public Class(int classID, String classImg, String className, int teacherID, int termID) {
        this.classID = classID;
        this.classImg = classImg;
        this.className = className;
        this.teacherID = teacherID;
        this.termID = termID;
    }

    public Class(String classImg, String className, int teacherID, int termID) {
        this.classImg = classImg;
        this.className = className;
        this.teacherID = teacherID;
        this.termID = termID;
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

    @Override
    public String toString() {
        return "Class{" + "classID=" + classID + ", classImg=" + classImg + ", className=" + className + ", teacherID=" + teacherID + ", termID=" + termID + '}';
    }

}
