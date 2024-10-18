/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import entity.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.TeacherDAOInterface;


public class TeacherDAOImpl extends DBContext implements TeacherDAOInterface{
    @Override
    public Teacher ProfileTeacher (int accountID){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select p.* from Teacher p where p.accountID = ?";
        try{
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while(rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setTeacherID(rs.getInt("teacherID"));
                teacher.setTeacherImg(rs.getString("teacherImg"));
                teacher.setAccountID(rs.getInt("accountID"));
                teacher.setTeacherFirstName(rs.getString("teacherFirstName"));
                teacher.setTeacherLastName(rs.getString("teacherLastName"));
                teacher.setPhone(rs.getString("phone"));
                teacher.setGender(rs.getString("gender"));
                teacher.setAddress(rs.getString("address"));
                teacher.setBirthdate(rs.getString("birthdate"));
                teacher.setYearOfEXp(rs.getInt("yearOfEXp"));
                teacher.setSalaryFixed(rs.getDouble("salaryFixed"));
                return teacher;
            }
        }catch(SQLException ex) {
            Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    @Override
    public void UpdateProfileTeacher(int teacherID ,String teacherFirstName, String teacherLastName, String phone, String teacherImg, String address, String birthdate) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "update Teacher set teacherFirstName = N'"+teacherFirstName+"', teacherLastName = N'"+teacherLastName+"', phone = '"+phone+"', "
                + "teacherImg = '"+teacherImg+"', [address] = N'"+address+"', birthdate = '"+birthdate+"'\n" +
                        "where teacherID = "+teacherID+"";
        try{
            con = connection;
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        }catch(SQLException ex) {
            Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    // Update information of Teacher
    @Override
    public void UpdateTeacher(Teacher teacher) {
        String query = "update Teacher set teacherImg = ?,teacherFirstName = ?,teacherLastName = ?, phone = ?, gender = ?,"
                + " [address] = ?,birthdate = ?, YearOfEXp =?, salaryFixed = ?\n"
                + "where teacherID = ?";
        Connection con = null;
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, teacher.getTeacherImg());
            ps.setString(2, teacher.getTeacherFirstName());
            ps.setString(3, teacher.getTeacherLastName());
            ps.setString(4, teacher.getPhone());
            ps.setString(5, teacher.getGender());
            ps.setString(6, teacher.getAddress());
            ps.setString(7, teacher.getBirthdate());
            ps.setInt(8, teacher.getYearOfEXp());
            ps.setDouble(9, teacher.getSalaryFixed());
            ps.setInt(10, teacher.getTeacherID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //   *List All Infomation of teacher
    @Override
    public List<Teacher> getAllTeacher() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Teacher> list = new ArrayList<Teacher>();
        String query = "SELECT * FROM Teacher";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setTeacherID(rs.getInt("teacherID"));
                teacher.setTeacherImg(rs.getString("teacherImg"));
                teacher.setAccountID(rs.getInt("accountID"));
                teacher.setTeacherFirstName(rs.getString("teacherFirstName"));
                teacher.setTeacherLastName(rs.getString("teacherLastName"));
                teacher.setPhone(rs.getString("phone"));
                teacher.setGender(rs.getString("gender"));
                teacher.setAddress(rs.getString("address"));
                teacher.setBirthdate(rs.getString("birthdate"));
                teacher.setYearOfEXp(rs.getInt("yearOfEXp"));
                teacher.setSalaryFixed(rs.getDouble("salaryFixed"));
                list.add(teacher);
            }
        } catch(SQLException ex) {
            Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    
    // Show information of teacher by id
    @Override
    public Teacher ShowInfoTeacherByID(int teacherID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select p.* from Teacher p where p.teacherID = ?";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, teacherID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setTeacherID(rs.getInt("teacherID"));
                teacher.setTeacherImg(rs.getString("teacherImg"));
                teacher.setAccountID(rs.getInt("accountID"));
                teacher.setTeacherFirstName(rs.getString("teacherFirstName"));
                teacher.setTeacherLastName(rs.getString("teacherLastName"));
                teacher.setPhone(rs.getString("phone"));
                teacher.setGender(rs.getString("gender"));
                teacher.setAddress(rs.getString("address"));
                teacher.setBirthdate(rs.getString("birthdate"));
                teacher.setYearOfEXp(rs.getInt("yearOfEXp"));
                teacher.setSalaryFixed(rs.getDouble("salaryFixed"));
                return teacher;
            }
        } catch(SQLException ex) {
            Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
     //    *Add a teacher
    //    *Add a teacher
    @Override
    public void AddTeacher(Teacher teacher) {
        Connection con = null;
        try {
            //take id new a account
            String sql1 = "select top 1 accountID from Account\n"
                    + "order by accountID desc";
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(sql1);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int accid = rs.getInt(1);
                //add new teacher
                String query = "INSERT INTO Teacher VALUES(?, " + accid + ", ?,?, ?, ?, ?, ?,?,?)";
                PreparedStatement ps1 = con.prepareStatement(query);

                ps1.setString(1, teacher.getTeacherImg());
                ps1.setString(2, teacher.getTeacherFirstName());
                ps1.setString(3, teacher.getTeacherLastName());
                ps1.setString(4, teacher.getPhone());
                ps1.setString(5, teacher.getGender());
                ps1.setString(6, teacher.getAddress());
                ps1.setString(7, teacher.getBirthdate());
                ps1.setInt(8, teacher.getYearOfEXp());
                ps1.setDouble(9, teacher.getSalaryFixed());

                ps1.executeUpdate();
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
    @Override
    public Teacher TeacherInfor(int studentID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select t.*\n" +
                        "from Teacher t, Class c, Student s\n" +
                        "where t.teacherID = c.teacherID\n" +
                        "and c.classID = s.classID\n" +
                        "and s.studentID = ?";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, studentID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setTeacherID(rs.getInt("teacherID"));
                teacher.setTeacherImg(rs.getString("teacherImg"));
                teacher.setAccountID(rs.getInt("accountID"));
                teacher.setTeacherFirstName(rs.getString("teacherFirstName"));
                teacher.setTeacherLastName(rs.getString("teacherLastName"));
                teacher.setPhone(rs.getString("phone"));
                teacher.setGender(rs.getString("gender"));
                teacher.setAddress(rs.getString("address"));
                teacher.setBirthdate(rs.getString("birthdate"));
                teacher.setYearOfEXp(rs.getInt("yearOfEXp"));
                teacher.setSalaryFixed(rs.getDouble("salaryFixed"));
                return teacher;
            }
        }catch(SQLException ex) {
            Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    // List  5 Teacher by page
    @Override
    public List<Teacher> PagingTeacher(int index) {
        Connection con = null;
        List<Teacher> list = new ArrayList<Teacher>();
        String query = "SELECT * FROM Teacher\n" +
                        "ORDER BY teacherID\n" +
                        "OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, (index - 1)*5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();

                teacher.setTeacherID(rs.getInt("teacherID"));
                teacher.setTeacherImg(rs.getString("teacherImg"));
                teacher.setAccountID(rs.getInt("accountID"));
                teacher.setTeacherFirstName(rs.getString("teacherFirstName"));
                teacher.setTeacherLastName(rs.getString("teacherLastName"));
                teacher.setPhone(rs.getString("phone"));
                teacher.setGender(rs.getString("gender"));
                teacher.setAddress(rs.getString("address"));
                teacher.setBirthdate(rs.getString("birthdate"));
                teacher.setYearOfEXp(rs.getInt("yearOfEXp"));
                teacher.setSalaryFixed(rs.getDouble("salaryFixed"));

                list.add(teacher);
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
     // Get end page
    @Override
    public int getNumberEndPageTeacher() {
        Connection con = null;
        String query = "SELECT COUNT(*) FROM Teacher";
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
            Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, e);       
        }
        return 0;
    }
}
