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
public class Event {
    private int eventID;
    private int classID;
    private String eventImg;
    private String className;
    private String eventName;
    private String dayStartEvent;
    private String dayEndEvent;
    private String organizationalSponsor;

    public Event() {
    }

    public Event(int classID, String eventImg, String eventName, String dayStartEvent, String dayEndEvent, String organizationalSponsor) {
        this.classID = classID;
        this.eventImg = eventImg;
        this.eventName = eventName;
        this.dayStartEvent = dayStartEvent;
        this.dayEndEvent = dayEndEvent;
        this.organizationalSponsor = organizationalSponsor;
    }

    public Event(int eventID, int classID, String eventImg, String eventName, String dayStartEvent, String dayEndEvent, String organizationalSponsor) {
        this.eventID = eventID;
        this.classID = classID;
        this.eventImg = eventImg;
        this.eventName = eventName;
        this.dayStartEvent = dayStartEvent;
        this.dayEndEvent = dayEndEvent;
        this.organizationalSponsor = organizationalSponsor;
    }

    public Event(int eventID, int classID, String className, String eventImg, String eventName, String dayStartEvent, String dayEndEvent, String organizationalSponsor) {
        this.eventID = eventID;
        this.classID = classID;
        this.className = className;
        this.eventImg = eventImg;
        this.eventName = eventName;
        this.dayStartEvent = dayStartEvent;
        this.dayEndEvent = dayEndEvent;
        this.organizationalSponsor = organizationalSponsor;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getEventImg() {
        return eventImg;
    }

    public void setEventImg(String eventImg) {
        this.eventImg = eventImg;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDayStartEvent() {
        return dayStartEvent;
    }

    public void setDayStartEvent(String dayStartEvent) {
        this.dayStartEvent = dayStartEvent;
    }

    public String getDayEndEvent() {
        return dayEndEvent;
    }

    public void setDayEndEvent(String dayEndEvent) {
        this.dayEndEvent = dayEndEvent;
    }

    public String getOrganizationalSponsor() {
        return organizationalSponsor;
    }

    public void setOrganizationalSponsor(String organizationalSponsor) {
        this.organizationalSponsor = organizationalSponsor;
    }

    @Override
    public String toString() {
        return "Event{" + "eventID=" + eventID + ", classID=" + classID + ", eventImg=" + eventImg + ", className=" + className + ", eventName=" + eventName + ", dayStartEvent=" + dayStartEvent + ", dayEndEvent=" + dayEndEvent + ", organizationalSponsor=" + organizationalSponsor + '}';
    }
    
}
