/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Event;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface EventDAOInterface {
    // List 4 Event by page for parent
    public List<Event> listEvent(int index);
     // List  5 Event by page for admin
    public List<Event> PagingEvent(int index);
    
    // View Event by id
    public Event ViewEventByID(int id);
    
    //    *Add a Event
    public void AddEvent(Event event);
    
    //    *Update a Event
    public void UpdateEvent(Event event);
    
    //    *Delete a Event
    public void deleteEvent(int nid);
    
    // Get end page
    public int getNumberEndPageEvent();
}
