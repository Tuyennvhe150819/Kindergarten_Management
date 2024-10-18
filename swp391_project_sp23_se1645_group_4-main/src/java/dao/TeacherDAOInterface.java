/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Teacher;
import java.util.List;


public interface TeacherDAOInterface {
    // view profile teacher
    public Teacher ProfileTeacher (int accountID);
    // update profile teacher
    public void UpdateProfileTeacher(int teacherID ,String teacherFirstName, String teacherLastName, String phone, String teacherImg, String address, String birthdate);
    // list all teacher
    public List<Teacher> getAllTeacher();
    // show information by id
    public Teacher ShowInfoTeacherByID(int teacherID);
    //    *Add a teacher
    public void AddTeacher(Teacher teacher);
    // view information teacher by student id
    public Teacher TeacherInfor(int studentID);
    // Get end page
    public int getNumberEndPageTeacher();
    // List  5 Teacher by page
    public List<Teacher> PagingTeacher(int index);
    // Update information of Teacher
    public void UpdateTeacher(Teacher teacher);
}
