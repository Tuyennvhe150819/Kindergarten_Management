/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Attendance;
import entity.CheckAttendance;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface AttendanceDAOInterface {
    // Shows students in class attendance today by class id
    public List<CheckAttendance> checkAttendance (int classID);
    // student attendance
    public void Attended (String studentID, String attendanceID, String status, String note);
    // weekly attendance list of students
    public List<Attendance> showAttendance(int studentID, String week, String year);
    // teacher's weekly attendance list
    public List<Attendance> showTeacherSchedule(int teacherID, String week, String year);
    // list out attendance information of students in that class
    public List<CheckAttendance> viewAttendance(int classID,String date);
    // add the attendance date for that class and the students of that class by admin
    public void AddAttendance(Attendance attendance);
     // Get end page
    public int getNumberEndPageAttendance();

    // List  5 Attendance by page
    public List<Attendance> PagingAttendance(int index);

    // View Attendance by id
    public Attendance ViewAttendanceByID(int id);

    //    *Update a Attendance
    public void UpdateAttendance(Attendance attendance);
}
