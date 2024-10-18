/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Parent;
import entity.Student;
import entity.ViewFIFStudent;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface StudentDAOInterface {
    // list all student follow id parent
    public List<Student> ListStudent(int parentID);
    // view the information of that student
    public Student ViewStudent(int studentID);
    // view all students by class id
    public List<Student> ListViewStudent(int classID);
    // View full information of that 1 student
    public ViewFIFStudent ViewFullInformationStudent(int studentID);
    //    *Update a Student
    public void UpdateStudent(Student student);
    //    *Delete a Student
    public void deleteStudent(int sid);
    // Get end page
    public int getNumberEndPageStudent();
    // List  5 Student by page
    public List<Student> PagingStudent(int index);
    //    *Add a Student && a Parent
    public void AddInfoStudentParent(Parent parent, Student student);
}
