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
public class Term {
    private int termID;
    private String termName;
    private String startdate;
    private String enddate;

    public Term() {
    }

    public Term(int termID, String termName, String startdate, String enddate) {
        this.termID = termID;
        this.termName = termName;
        this.startdate = startdate;
        this.enddate = enddate;
    }
    public Term(String termName, String startdate, String enddate) {
        this.termName = termName;
        this.startdate = startdate;
        this.enddate = enddate;
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
        return "Term{" + "termID=" + termID + ", termName=" + termName + ", startdate=" + startdate + ", enddate=" + enddate + '}';
    }

}
