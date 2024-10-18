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
public class Teacher {
    private int teacherID;
    private String teacherImg;
    private int accountID;
    private String teacherFirstName;
    private String teacherLastName;
    private String phone;
    private String gender;
    private String address;
    private String birthdate;
    private int yearOfEXp;
    private double salaryFixed;

    public Teacher() {
    }

    public Teacher(String teacherImg, String teacherFirstName, String teacherLastName, String phone, String gender, String address, String birthdate, int yearOfEXp, double salaryFixed) {
        this.teacherImg = teacherImg;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.birthdate = birthdate;
        this.yearOfEXp = yearOfEXp;
        this.salaryFixed = salaryFixed;
    }
        
    public Teacher(int teacherID, String teacherImg, String teacherFirstName, String teacherLastName, String phone, String gender, String address, String birthdate, int yearOfEXp, double salaryFixed) {
        this.teacherID = teacherID;
        this.teacherImg = teacherImg;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.birthdate = birthdate;
        this.yearOfEXp = yearOfEXp;
        this.salaryFixed = salaryFixed;
    }

    public Teacher(int teacherID, String teacherImg, int accountID, String teacherFirstName, String teacherLastName, String phone, String gender, String address, String birthdate, int yearOfEXp, double salaryFixed) {
        this.teacherID = teacherID;
        this.teacherImg = teacherImg;
        this.accountID = accountID;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.birthdate = birthdate;
        this.yearOfEXp = yearOfEXp;
        this.salaryFixed = salaryFixed;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherImg() {
        return teacherImg;
    }

    public void setTeacherImg(String teacherImg) {
        this.teacherImg = teacherImg;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getYearOfEXp() {
        return yearOfEXp;
    }

    public void setYearOfEXp(int yearOfEXp) {
        this.yearOfEXp = yearOfEXp;
    }

    public double getSalaryFixed() {
        return salaryFixed;
    }

    public void setSalaryFixed(double salaryFixed) {
        this.salaryFixed = salaryFixed;
    }

    @Override
    public String toString() {
        return "Teacher{" + "teacherID=" + teacherID + ", teacherImg=" + teacherImg + ", accountID=" + accountID + ", teacherFirstName=" + teacherFirstName + ", teacherLastName=" + teacherLastName + ", phone=" + phone + ", gender=" + gender + ", address=" + address + ", birthdate=" + birthdate + ", YearOfEXp=" + yearOfEXp + ", salaryFixed=" + salaryFixed + '}';
    }

    
    
}
