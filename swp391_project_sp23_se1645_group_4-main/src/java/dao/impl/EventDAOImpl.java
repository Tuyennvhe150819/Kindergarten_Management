/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import entity.Event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.EventDAOInterface;

/**
 *
 * @author MSII
 */
public class EventDAOImpl extends DBContext implements EventDAOInterface {

    @Override
    public List<Event> listEvent(int index) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Event> list = new ArrayList<>();
        String query = "select e.*, c.className from [Event] e, Class c\n"
                + "where e.classID = c.classID\n"
                + "order by e.EventID DESC\n"
                + "OFFSET ? ROWS FETCH NEXT 4 ROWS ONLY";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, (index - 1)*4);
            rs = ps.executeQuery();
            while (rs.next()) {
                Event event = new Event();
                event.setEventID(rs.getInt("eventID"));
                event.setClassID(rs.getInt("classID"));
                event.setEventImg(rs.getString("eventImg"));
                event.setEventName(rs.getString("eventName"));
                event.setDayStartEvent(rs.getString("dayStartEvent"));
                event.setDayEndEvent(rs.getString("dayEndEvent"));
                event.setOrganizationalSponsor(rs.getString("organizationalSponsor"));
                event.setClassName(rs.getString("className"));
                list.add(event);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EventDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    // Get end page

    @Override
    public int getNumberEndPageEvent() {
        Connection con = null;
        String query = "SELECT COUNT(*) FROM [Event]";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int totalItem = rs.getInt(1);
                int endPage = 0;
                endPage = totalItem / 4;
                if (totalItem % 4 != 0) {
                    endPage++;
                }
                return endPage;
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(EventDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
     // List  5 Event by page
    @Override
    public List<Event> PagingEvent(int index) {
        Connection con = null;
        List<Event> list = new ArrayList<Event>();
        String query = "select e.*, c.className from Event e JOIN Class c ON e.classID = c.classID\n" +
                        "ORDER BY EventID\n" +
                        "OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, (index - 1)*5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Event event = new Event();

                event.setEventID(rs.getInt("EventID"));
                event.setClassID(rs.getInt("classID"));
                event.setClassName(rs.getString("className"));
                event.setEventImg(rs.getString("eventImg"));
                event.setEventName(rs.getString("EventName"));
                event.setDayStartEvent(rs.getString("DayStartEvent"));
                event.setDayEndEvent(rs.getString("DayEndEvent"));
                event.setOrganizationalSponsor(rs.getString("OrganizationalSponsor"));

                list.add(event);
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(EventDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EventDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
    // View Event by id
    @Override
    public Event ViewEventByID(int id) {
        Connection con = null;
        String query = "select e.* from Event e where e.EventID = ?";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Event event = new Event();

                event.setEventID(rs.getInt("EventID"));
                event.setClassID(rs.getInt("classID"));
                event.setEventImg(rs.getString("eventImg"));
                event.setEventName(rs.getString("EventName"));
                event.setDayStartEvent(rs.getString("DayStartEvent"));
                event.setDayEndEvent(rs.getString("DayEndEvent"));
                event.setOrganizationalSponsor(rs.getString("OrganizationalSponsor"));

                return event;
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(EventDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EventDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    //    *Add a Event
    @Override
    public void AddEvent(Event event) {
        Connection con = null;
        String query = "INSERT INTO [Event] VALUES(?, ?, ?, ?, ?, ?)";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, event.getClassID());
            ps.setString(2, event.getEventImg());
            ps.setString(3, event.getEventName());
            ps.setString(4, event.getDayStartEvent());
            ps.setString(5, event.getDayEndEvent());
            ps.setString(6, event.getOrganizationalSponsor());

            ps.executeUpdate();
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(EventDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EventDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //    *Update a Event
    @Override
    public void UpdateEvent(Event event) {
        Connection con = null;
        String query = "UPDATE [Event] SET classID = ?, eventImg = ?, EventName = ?,DayStartEvent = ?,DayEndEvent = ?, \n"
                + "OrganizationalSponsor = ? WHERE EventID = ?";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, event.getClassID());
            ps.setString(2, event.getEventImg());
            ps.setString(3, event.getEventName());
            ps.setString(4, event.getDayStartEvent());
            ps.setString(5, event.getDayEndEvent());
            ps.setString(6, event.getOrganizationalSponsor());
            ps.setInt(7, event.getEventID());

            ps.executeUpdate();
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(EventDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EventDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //    *Delete a Event
    @Override
    public void deleteEvent(int eid) {
        Connection con = null;
        String query = "DELETE FROM [Event] WHERE EventID = ?";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, eid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(EventDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EventDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
