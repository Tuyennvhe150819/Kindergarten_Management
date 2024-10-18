/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import entity.Class;
import entity.ViewClass;

/**
 *
 * @author Asus
 */
public interface ClassDAOInterface {
    //List All class
    public List<ViewClass> showAClass();
    //List class by teacher ID
    public List<ViewClass> ListClass(int teachID);
    // View class follow term by termID and teacherID
    public List<ViewClass> ListClassTerm(int termID, int teacherID);
    // display the information of that class
    public Class ShowClass(int studentID);
    // List  5 Class by page
    public List<ViewClass> PagingClass(int index);

    // View Class by id
    public Class ViewClassByID(int id);

    //    *Add a Class
    public void AddClass(Class classs);

    //    *Update a Class
    public void UpdateClass(Class classs);

    // Get end page
    public int getNumberEndPageClass();
}
