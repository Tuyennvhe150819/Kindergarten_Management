/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import entity.Notification;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.NotificationDAOInterface;

/**
 *
 * @author MSII
 */
public class NotificationDAOImpl extends DBContext implements NotificationDAOInterface {

    // View Notification
    @Override
    public List<Notification> ListNotification(int index) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Notification> list = new ArrayList<Notification>();
        String query = "select n.* from [Notification] n\n"
                + "order by n.notID DESC\n"
                + "OFFSET ? ROWS FETCH NEXT 4 ROWS ONLY";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, (index - 1)*4);
            rs = ps.executeQuery();
            while (rs.next()) {
                Notification notification = new Notification();
                notification.setNotID(rs.getInt("notID"));
                notification.setNotImg(rs.getString("notImg"));
                notification.setSubject(rs.getString("subject"));
                notification.setDescribe(rs.getString("describe"));
                notification.setStartDate(rs.getString("startDate"));
                notification.setEndDate(rs.getString("endDate"));
                notification.setCreateBy(rs.getString("createBy"));
                list.add(notification);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotificationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NotificationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    // View Notification by id

    @Override
    public Notification ViewNotificationByID(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select n.* from Notification n where n.notID = ?";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Notification notification = new Notification();
                notification.setNotID(rs.getInt("notID"));
                notification.setNotImg(rs.getString("notImg"));
                notification.setSubject(rs.getString("subject"));
                notification.setDescribe(rs.getString("describe"));
                notification.setStartDate(rs.getString("startDate"));
                notification.setEndDate(rs.getString("endDate"));
                notification.setCreateBy(rs.getString("createBy"));
                return notification;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotificationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NotificationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    //    *Add a Notification

    @Override
    public void AddNotification(Notification notification) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "INSERT INTO [Notification] VALUES('" + notification.getNotImg() + "', '" + notification.getSubject() + "', '" + notification.getDescribe() + "', '" + notification.getStartDate() + "', '" + notification.getEndDate() + "', '" + notification.getCreateBy() + "')";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NotificationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NotificationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //    *Update a Notification
    @Override
    public void UpdateNotification(Notification notification) {
        Connection con = null;
        String query = "UPDATE [Notification] SET notImg = ?, subject = ?, describe = ?,startDate = ?,endDate = ?, createBy = ?"
                + " WHERE notID = ?";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, notification.getNotImg());
            ps.setString(2, notification.getSubject());
            ps.setString(3, notification.getDescribe());
            ps.setString(4, notification.getStartDate());
            ps.setString(5, notification.getEndDate());
            ps.setString(6, notification.getCreateBy());
            ps.setInt(7, notification.getNotID());

            ps.executeUpdate();
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(NotificationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NotificationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //    *Delete a Notification
    @Override
    public void deleteNotification(int nid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "DELETE FROM [Notification] WHERE notID = ?";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, nid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NotificationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
    @Override
    public int getNumberEndPageNotification() {
        Connection con = null;
        String query = "SELECT COUNT(*) FROM [Notification]";
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
            Logger.getLogger(NotificationDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
    @Override
    public List<Notification> PagingNotification(int index) {
        Connection con = null;
        List<Notification> list = new ArrayList<Notification>();
        String query = "SELECT * FROM Notification\n"
                + "ORDER BY notID\n"
                + "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, (index - 1) * 10);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Notification notification = new Notification();

                notification.setNotID(rs.getInt("notID"));
                notification.setNotImg(rs.getString("notImg"));
                notification.setSubject(rs.getString("subject"));
                notification.setDescribe(rs.getString("describe"));
                notification.setStartDate(rs.getString("startDate"));
                notification.setEndDate(rs.getString("endDate"));
                notification.setCreateBy(rs.getString("createBy"));

                list.add(notification);
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(NotificationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return list;
    }
    // Get end page
    @Override
    public int getNumberEndPageNotificationAdmin() {
        Connection con = null;
        String query = "SELECT COUNT(*) FROM [Notification]";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int totalItem = rs.getInt(1);
                int endPage = 0;
                endPage = totalItem / 10;
                if (totalItem % 10 != 0) {
                    endPage++;
                }
                return endPage;
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(NotificationDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
}
