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
public class Parent {
    private int parentID;
    private String parentImage;
    private String parentFirstName;
    private String parentLastName;
    private int accountID;
    private String phone;
    private String datebirth;
    private String address;
    private String job;

    public Parent() {
    }

    public Parent(String parentImage, String parentFirstName, String parentLastName, String phone, String datebirth, String address, String job) {
        this.parentImage = parentImage;
        this.parentFirstName = parentFirstName;
        this.parentLastName = parentLastName;
        this.phone = phone;
        this.datebirth = datebirth;
        this.address = address;
        this.job = job;
    }
    public Parent(int parentID, String parentImage, String parentFirstName, String parentLastName, int accountID, String phone, String datebirth, String address, String job) {
        this.parentID = parentID;
        this.parentImage = parentImage;
        this.parentFirstName = parentFirstName;
        this.parentLastName = parentLastName;
        this.accountID = accountID;
        this.phone = phone;
        this.datebirth = datebirth;
        this.address = address;
        this.job = job;
    }
    public Parent(int parentID, String parentImage, String parentFirstName, String parentLastName, String phone, String datebirth, String address, String job) {
        this.parentID = parentID;
        this.parentImage = parentImage;
        this.parentFirstName = parentFirstName;
        this.parentLastName = parentLastName;
        this.phone = phone;
        this.datebirth = datebirth;
        this.address = address;
        this.job = job;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public String getParentImage() {
        return parentImage;
    }

    public void setParentImage(String parentImage) {
        this.parentImage = parentImage;
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

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDatebirth() {
        return datebirth;
    }

    public void setDatebirth(String datebirth) {
        this.datebirth = datebirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Parent{" + "parentID=" + parentID + ", parentImage=" + parentImage + ", parentFirstName=" + parentFirstName + ", parentLastName=" + parentLastName + ", accountID=" + accountID + ", phone=" + phone + ", datebirth=" + datebirth + ", address=" + address + ", job=" + job + '}';
    }

    
}
