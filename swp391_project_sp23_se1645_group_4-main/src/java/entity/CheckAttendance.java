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
public class CheckAttendance {
    private int studentID;
    private String studentImg;
    private String studentFirstName;
    private String studentLastName;
    private String gender;
    private String likeSomething;
    private String hateSomething;
    private String favoriteFood;
    private String hateFood;
    private String birthdate;
    private int parentID;
    private int classID;
    private int attendanceID;
    private String className;
    private String note;
    private String status;

    public CheckAttendance() {
    }

    public CheckAttendance(int studentID, String studentImg, String studentFirstName, String studentLastName, String gender, String likeSomething, String hateSomething, String favoriteFood, String hateFood, String birthdate, int parentID, int classID, int attendanceID, String className, String note, String status) {
        this.studentID = studentID;
        this.studentImg = studentImg;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.gender = gender;
        this.likeSomething = likeSomething;
        this.hateSomething = hateSomething;
        this.favoriteFood = favoriteFood;
        this.hateFood = hateFood;
        this.birthdate = birthdate;
        this.parentID = parentID;
        this.classID = classID;
        this.attendanceID = attendanceID;
        this.className = className;
        this.note = note;
        this.status = status;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentImg() {
        return studentImg;
    }

    public void setStudentImg(String studentImg) {
        this.studentImg = studentImg;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLikeSomething() {
        return likeSomething;
    }

    public void setLikeSomething(String likeSomething) {
        this.likeSomething = likeSomething;
    }

    public String getHateSomething() {
        return hateSomething;
    }

    public void setHateSomething(String hateSomething) {
        this.hateSomething = hateSomething;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public String getHateFood() {
        return hateFood;
    }

    public void setHateFood(String hateFood) {
        this.hateFood = hateFood;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public int getAttendanceID() {
        return attendanceID;
    }

    public void setAttendanceID(int attendanceID) {
        this.attendanceID = attendanceID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CheckAttendance{" + "studentID=" + studentID + ", studentImg=" + studentImg + ", studentFirstName=" + studentFirstName + ", studentLastName=" + studentLastName + ", gender=" + gender + ", likeSomething=" + likeSomething + ", hateSomething=" + hateSomething + ", favoriteFood=" + favoriteFood + ", hateFood=" + hateFood + ", birthdate=" + birthdate + ", parentID=" + parentID + ", classID=" + classID + ", attendanceID=" + attendanceID + ", className=" + className + ", note=" + note + ", status=" + status + '}';
    }

    
}
