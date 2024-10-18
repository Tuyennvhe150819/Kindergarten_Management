/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import entity.Parent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.ParentDAOInterface;

/**
 *
 * @author Asus
 */
public class ParentDAOImpl extends DBContext implements ParentDAOInterface{
    
    @Override
    public Parent Profile (int accountID){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select p.* from Parent p where p.accountID = ?";
        try{
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while(rs.next()) {
                Parent parent = new Parent();
                parent.setParentID(rs.getInt("parentID"));
                parent.setParentImage(rs.getString("parentImage"));
                parent.setParentFirstName(rs.getString("parentFirstName"));
                parent.setParentLastName(rs.getString("parentLastName"));
                parent.setAccountID(rs.getInt("accountID"));
                parent.setPhone(rs.getString("phone"));
                parent.setDatebirth(rs.getString("datebirth"));
                parent.setAddress(rs.getString("address"));
                parent.setJob(rs.getString("job"));
                return parent;
            }
        }catch(SQLException ex) {
            Logger.getLogger(ParentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ParentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    @Override
    public Parent ViewInfoByID (int id){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select p.* from Parent p where p.parentID = ?";
        try{
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()) {
                Parent parent = new Parent();
                parent.setParentID(rs.getInt("parentID"));
                parent.setParentImage(rs.getString("parentImage"));
                parent.setParentFirstName(rs.getString("parentFirstName"));
                parent.setParentLastName(rs.getString("parentLastName"));
                parent.setAccountID(rs.getInt("accountID"));
                parent.setPhone(rs.getString("phone"));
                parent.setDatebirth(rs.getString("datebirth"));
                parent.setAddress(rs.getString("address"));
                parent.setJob(rs.getString("job"));
                return parent;
            }
        }catch(SQLException ex) {
            Logger.getLogger(ParentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ParentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    @Override
    public void UpdateProfileParent(Parent parent) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "update Parent set parentFirstName = N'"+parent.getParentFirstName()+"', parentLastName = N'"+parent.getParentLastName()+"', ParentImage = '"+parent.getParentImage()+"', "
                + "Phone = '"+parent.getPhone()+"', [address] = N'"+parent.getAddress()+"', job = N'"+parent.getJob()+"', datebirth = '"+parent.getDatebirth()+"'\n" +
                        "where parentID = '"+parent.getParentID()+"'";
        try{
            con = connection;
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        }catch(SQLException ex) {
            Logger.getLogger(ParentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ParentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //   *List All Infomation of Parent
    @Override
    public List<Parent> getAllParent() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Parent> list = new ArrayList<Parent>();
        String query = "SELECT * FROM Parent";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Parent parent = new Parent();
                parent.setParentID(rs.getInt("parentID"));
                parent.setParentImage(rs.getString("parentImage"));
                parent.setParentFirstName(rs.getString("parentFirstName"));
                parent.setParentLastName(rs.getString("parentLastName"));
                parent.setAccountID(rs.getInt("accountID"));
                parent.setPhone(rs.getString("phone"));
                parent.setDatebirth(rs.getString("datebirth"));
                parent.setAddress(rs.getString("address"));
                parent.setJob(rs.getString("job"));
                list.add(parent);
            }
        }catch(SQLException ex) {
            Logger.getLogger(ParentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ParentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
   
    // List 5 Parent by page
    @Override
    public List<Parent> PagingParent(int index) {
        Connection con = null;
        List<Parent> list = new ArrayList<Parent>();
        String query = "SELECT * FROM Parent\n" +
                        "ORDER BY parentID\n" +
                        "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, (index - 1)*10);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Parent parent = new Parent();

                parent.setParentID(rs.getInt("parentID"));
                parent.setParentImage(rs.getString("parentImage"));
                parent.setParentFirstName(rs.getString("parentFirstName"));
                parent.setParentLastName(rs.getString("parentLastName"));
                parent.setAccountID(rs.getInt("accountID"));
                parent.setPhone(rs.getString("phone"));
                parent.setDatebirth(rs.getString("datebirth"));
                parent.setAddress(rs.getString("address"));
                parent.setJob(rs.getString("job"));

                list.add(parent);
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(ParentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ParentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
    // Get end page
    @Override
    public int getNumberEndPageParent() {
        Connection con = null;
        String query = "SELECT COUNT(*) FROM Parent";
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
            Logger.getLogger(ParentDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
}
