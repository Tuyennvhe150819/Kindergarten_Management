/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import entity.Class;
import entity.ViewClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.ClassDAOInterface;

/**
 *
 * @author Asus
 */
public class ClassDAOImpl extends DBContext implements ClassDAOInterface {

    //List All clas
    @Override
    public List<ViewClass> showAClass() {
        Connection con = null;
        List<ViewClass> list = new ArrayList<ViewClass>();
        String query = "select c.*, t.teacherFirstName, tm.termName \n"
                + "from Class c LEFT JOIN Teacher t ON c.teacherID = t.teacherID \n"
                + "LEFT JOIN Term tm ON c.termID = tm.termID ";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ViewClass viewClass = new ViewClass();

                viewClass.setClassID(rs.getInt("classID"));
                viewClass.setClassImg(rs.getString("classImg"));
                viewClass.setClassName(rs.getString("className"));
                viewClass.setTeacherID(rs.getInt("teacherID"));
                viewClass.setTermID(rs.getInt("termID"));
                viewClass.setTermName(rs.getString("termName"));
                viewClass.setTeacherFirstName(rs.getString("teacherFirstName"));

                list.add(viewClass);
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    // View class follow term by termID and teacherID
    @Override
    public List<ViewClass> ListClassTerm(int termID, int teacherID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ViewClass> list = new ArrayList<ViewClass>();
        String query = "select c.*, t.termName, t.startdate, t.enddate\n"
                + "from Class c, Term t, Teacher tc\n"
                + "where c.termID = t.termID\n"
                + "and tc.teacherID = c.teacherID\n"
                + "and t.termID = ?\n"
                + "and tc.teacherID = ?";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, termID);
            ps.setInt(2, teacherID);
            rs = ps.executeQuery();
            while (rs.next()) {
                ViewClass viewClass = new ViewClass();
                viewClass.setClassID(rs.getInt("classID"));
                viewClass.setClassImg(rs.getString("classImg"));
                viewClass.setClassName(rs.getString("className"));
                viewClass.setTeacherID(rs.getInt("teacherID"));
                viewClass.setTermID(rs.getInt("termID"));
                viewClass.setTermName(rs.getString("termName"));
                viewClass.setStartdate(rs.getString("startdate"));
                viewClass.setEnddate(rs.getString("enddate"));
                list.add(viewClass);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public Class ShowClass(int studentID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select c.*\n"
                + "from Teacher t, Class c, Student s\n"
                + "where t.teacherID = c.teacherID\n"
                + "and c.classID = s.classID\n"
                + "and s.studentID = ?";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, studentID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Class cl = new Class();
                cl.setClassID(rs.getInt("classID"));
                cl.setClassImg(rs.getString("classImg"));
                cl.setClassName(rs.getString("className"));
                cl.setTeacherID(rs.getInt("teacherID"));
                cl.setTermID(rs.getInt("termID"));
                return cl;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    // List  5 Class by page
    @Override
    public List<ViewClass> PagingClass(int index) {
        Connection con = null;
        List<ViewClass> list = new ArrayList<ViewClass>();
        String query = "select c.*, t.teacherFirstName, tm.termName\n"
                + "from Class c LEFT JOIN Teacher t ON c.teacherID = t.teacherID\n"
                + "LEFT JOIN Term tm ON c.termID = tm.termID\n"
                + "ORDER BY classID\n"
                + "OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ViewClass viewClass = new ViewClass();

                viewClass.setClassID(rs.getInt("classID"));
                viewClass.setClassImg(rs.getString("classImg"));
                viewClass.setClassName(rs.getString("className"));
                viewClass.setTeacherID(rs.getInt("teacherID"));
                viewClass.setTermID(rs.getInt("termID"));
                viewClass.setTermName(rs.getString("termName"));
                viewClass.setTeacherFirstName(rs.getString("teacherFirstName"));

                list.add(viewClass);
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    //List class by teacher ID
    @Override
    public List<ViewClass> ListClass(int teachID) {
        Connection con = null;
        List<ViewClass> list = new ArrayList<ViewClass>();
        String query = "select c.*, t.termID, t.termName, t.startdate, t.enddate\n"
                + "from Class c, Term t\n"
                + "where c.termID = t.termID\n"
                + "and c.teacherID = ?";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, teachID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ViewClass viewClass = new ViewClass();
                viewClass.setClassID(rs.getInt("classID"));
                viewClass.setClassImg(rs.getString("classImg"));
                viewClass.setClassName(rs.getString("className"));
                viewClass.setTeacherID(rs.getInt("teacherID"));
                viewClass.setTermID(rs.getInt("termID"));
                viewClass.setTermName(rs.getString("termName"));
                viewClass.setStartdate(rs.getString("startdate"));
                viewClass.setEnddate(rs.getString("enddate"));

                list.add(viewClass);
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    // View Class by id
    @Override
    public Class ViewClassByID(int id) {
        Connection con = null;
        String query = "select * from class\n"
                + "where classID = ?";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Class classs = new Class();

                classs.setClassID(rs.getInt("classID"));
                classs.setClassImg(rs.getString("classImg"));
                classs.setClassName(rs.getString("className"));
                classs.setTeacherID(rs.getInt("teacherID"));
                classs.setTermID(rs.getInt("termID"));

                return classs;
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    //    *Add a Class
    @Override
    public void AddClass(Class classs) {
        Connection con = null;
        String query = "INSERT INTO Class VALUES(?, ?,?,?)";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, classs.getClassImg());
            ps.setString(2, classs.getClassName());
            ps.setInt(3, classs.getTeacherID());
            ps.setInt(4, classs.getTermID());

            ps.executeUpdate();
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //    *Update a Class
    @Override
    public void UpdateClass(Class classs) {
        Connection con = null;
        String query = "UPDATE Class SET classImg = ?, className = ?, teacherID = ?,termID = ?\n"
                + "WHERE classID = ?";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, classs.getClassImg());
            ps.setString(2, classs.getClassName());
            ps.setInt(3, classs.getTeacherID());
            ps.setInt(4, classs.getTermID());
            ps.setInt(5, classs.getClassID());

            ps.executeUpdate();
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Get end page
    @Override
    public int getNumberEndPageClass() {
        Connection con = null;
        String query = "SELECT COUNT(*) FROM Class";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int totalItem = rs.getInt(1);
                int endPage = 0;
                endPage = totalItem / 5;
                if (totalItem % 5 != 0) {
                    endPage++;
                }
                return endPage;
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
}
