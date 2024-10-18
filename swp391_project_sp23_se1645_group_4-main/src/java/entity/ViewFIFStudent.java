/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 * View Full information Student
 * @author MSII
 */
public class ViewFIFStudent {
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
    private String address;
    private String phone;
    private String parentFirstName;

    public ViewFIFStudent() {
    }

    public ViewFIFStudent(int studentID, String studentImg, String studentFirstName, String studentLastName, String gender, String likeSomething, String hateSomething, String favoriteFood, String hateFood, String birthdate, int parentID, int classID, String address, String phone, String parentFirstName) {
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
        this.address = address;
        this.phone = phone;
        this.parentFirstName = parentFirstName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getParentFirstName() {
        return parentFirstName;
    }

    public void setParentFirstName(String parentFirstName) {
        this.parentFirstName = parentFirstName;
    }

    @Override
    public String toString() {
        return "ViewFIFStudent{" + "studentID=" + studentID + ", studentImg=" + studentImg + ", studentFirstName=" + studentFirstName + ", studentLastName=" + studentLastName + ", gender=" + gender + ", likeSomething=" + likeSomething + ", hateSomething=" + hateSomething + ", favoriteFood=" + favoriteFood + ", hateFood=" + hateFood + ", birthdate=" + birthdate + ", parentID=" + parentID + ", classID=" + classID + ", address=" + address + ", phone=" + phone + ", parentFirstName=" + parentFirstName + '}';
    }

    
}
