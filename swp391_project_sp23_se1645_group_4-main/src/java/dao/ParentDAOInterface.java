/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Parent;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface ParentDAOInterface {
    // get profile parent
    public Parent Profile (int accountID);
    // view profile parent follow id
    public Parent ViewInfoByID (int id);
    // update information parent
    public void UpdateProfileParent(Parent parent);
    //   *List All Infomation of Parent
    public List<Parent> getAllParent();
    // List  5 Parent by page
    public List<Parent> PagingParent(int index);

    // Get end page
    public int getNumberEndPageParent();
}
