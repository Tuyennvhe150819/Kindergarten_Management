/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Notification;
import java.util.List;



public interface NotificationDAOInterface {
    // List 4 Notification by page for parent
    public List<Notification> ListNotification(int index);
    // View Notification by id
    public Notification ViewNotificationByID (int id);
    //    *Add a Notification
    public void AddNotification(Notification notification);
     //    *Update a Notification
    public void UpdateNotification(Notification notification);
    //    *Delete a Notification
    public void deleteNotification(int nid);
    // Get end page parent
    public int getNumberEndPageNotification();
    // List  5 Notification by page for admin
    public List<Notification> PagingNotification(int index);
    // Get end page admin
    public int getNumberEndPageNotificationAdmin();
    
}
