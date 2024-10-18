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
public class Notification {
    private int notID;
    private String notImg;
    private String subject;
    private String describe;
    private String startDate;
    private String endDate;
    private String createBy;

    public Notification() {
    }

    public Notification(int notID, String notImg, String subject, String describe, String startDate, String endDate, String createBy) {
        this.notID = notID;
        this.notImg = notImg;
        this.subject = subject;
        this.describe = describe;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createBy = createBy;
    }
    public Notification(String notImg, String subject, String describe, String startDate, String endDate, String createBy) {
        this.notImg = notImg;
        this.subject = subject;
        this.describe = describe;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createBy = createBy;
    }

    public int getNotID() {
        return notID;
    }

    public void setNotID(int notID) {
        this.notID = notID;
    }

    public String getNotImg() {
        return notImg;
    }

    public void setNotImg(String notImg) {
        this.notImg = notImg;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "Notification{" + "notID=" + notID + ", notImg=" + notImg + ", subject=" + subject + ", describe=" + describe + ", startDate=" + startDate + ", endDate=" + endDate + ", createBy=" + createBy + '}';
    }
}
