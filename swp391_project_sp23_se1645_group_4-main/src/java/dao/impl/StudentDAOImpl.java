/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import entity.Student;
import entity.ViewFIFStudent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Parent;
import dao.StudentDAOInterface;

public class StudentDAOImpl extends DBContext implements StudentDAOInterface {

    @Override
    public List<Student> ListStudent(int parentID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<Student>();
        String query = "select s.*, c.className from Student s, Class c\n"
                + "where s.classID = c.classID\n"
                + "and s.parentID = ?";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, parentID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setStudentID(rs.getInt("studentID"));
                student.setStudentImg(rs.getString("studentImg"));
                student.setStudentFirstName(rs.getString("studentFirstName"));
                student.setStudentLastName(rs.getString("studentLastName"));
                student.setGender(rs.getString("gender"));
                student.setLikeSomething(rs.getString("likeSomething"));
                student.setHateSomething(rs.getString("hateSomething"));
                student.setFavoriteFood(rs.getString("favoriteFood"));
                student.setHateFood(rs.getString("hateFood"));
                student.setBirthdate(rs.getString("birthdate"));
                student.setParentID(rs.getInt("parentID"));
                student.setClassID(rs.getInt("classID"));
                student.setClassName(rs.getString("className"));
                list.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public Student ViewStudent(int studentID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select s.*, c.className from Student s, Class c\n"
                + "where s.classID = c.classID\n"
                + "and s.studentID = ?";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, studentID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setStudentID(rs.getInt("studentID"));
                student.setStudentImg(rs.getString("studentImg"));
                student.setStudentFirstName(rs.getString("studentFirstName"));
                student.setStudentLastName(rs.getString("studentLastName"));
                student.setGender(rs.getString("gender"));
                student.setLikeSomething(rs.getString("likeSomething"));
                student.setHateSomething(rs.getString("hateSomething"));
                student.setFavoriteFood(rs.getString("favoriteFood"));
                student.setHateFood(rs.getString("hateFood"));
                student.setBirthdate(rs.getString("birthdate"));
                student.setParentID(rs.getInt("parentID"));
                student.setClassID(rs.getInt("classID"));
                student.setClassName(rs.getString("className"));
                return student;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public List<Student> ListViewStudent(int classID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<Student>();
        String query = "select s.*, c.className from Student s, Class c\n"
                + "where s.classID = c.classID\n"
                + "and s.classID = ?";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, classID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setStudentID(rs.getInt("studentID"));
                student.setStudentImg(rs.getString("studentImg"));
                student.setStudentFirstName(rs.getString("studentFirstName"));
                student.setStudentLastName(rs.getString("studentLastName"));
                student.setGender(rs.getString("gender"));
                student.setLikeSomething(rs.getString("likeSomething"));
                student.setHateSomething(rs.getString("hateSomething"));
                student.setFavoriteFood(rs.getString("favoriteFood"));
                student.setHateFood(rs.getString("hateFood"));
                student.setBirthdate(rs.getString("birthdate"));
                student.setParentID(rs.getInt("parentID"));
                student.setClassID(rs.getInt("classID"));
                student.setClassName(rs.getString("className"));
                list.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    // View Full information Student
    @Override
    public ViewFIFStudent ViewFullInformationStudent(int studentID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select s.*, p.[address], p.Phone, p.parentFirstName\n"
                + "from Student s, Parent p\n"
                + "where s.parentID = p.parentID\n"
                + "and s.studentID = " + studentID + "";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                ViewFIFStudent viewFIFStudent = new ViewFIFStudent();
                viewFIFStudent.setStudentID(rs.getInt("studentID"));
                viewFIFStudent.setStudentImg(rs.getString("studentImg"));
                viewFIFStudent.setStudentFirstName(rs.getString("studentFirstName"));
                viewFIFStudent.setStudentLastName(rs.getString("studentLastName"));
                viewFIFStudent.setGender(rs.getString("gender"));
                viewFIFStudent.setLikeSomething(rs.getString("likeSomething"));
                viewFIFStudent.setHateSomething(rs.getString("hateSomething"));
                viewFIFStudent.setFavoriteFood(rs.getString("favoriteFood"));
                viewFIFStudent.setHateFood(rs.getString("hateFood"));
                viewFIFStudent.setBirthdate(rs.getString("birthdate"));
                viewFIFStudent.setParentID(rs.getInt("parentID"));
                viewFIFStudent.setClassID(rs.getInt("classID"));
                viewFIFStudent.setAddress(rs.getString("address"));
                viewFIFStudent.setPhone(rs.getString("phone"));
                viewFIFStudent.setParentFirstName(rs.getString("parentFirstName"));
                return viewFIFStudent;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    //    *Update a Student
    @Override
    public void UpdateStudent(Student student) {
        Connection con = null;
        String query = "UPDATE Student SET studentImg = ?, studentFirstName = ?, studentLastName = ?, \n"
                + "gender = ?,likeSomething= ?, hateSomething = ?, favoriteFood = ?, hateFood = ?, birthdate = ?, classID = ?\n"
                + "WHERE studentID = ?";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, student.getStudentImg());
            ps.setString(2, student.getStudentFirstName());
            ps.setString(3, student.getStudentLastName());
            ps.setString(4, student.getGender());
            ps.setString(5, student.getLikeSomething());
            ps.setString(6, student.getHateSomething());
            ps.setString(7, student.getFavoriteFood());
            ps.setString(8, student.getHateFood());
            ps.setString(9, student.getBirthdate());
            ps.setInt(10, student.getClassID());
            ps.setInt(11, student.getStudentID());

            ps.executeUpdate();
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //    *Delete a Student
    @Override
    public void deleteStudent(int sid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "DELETE FROM FeedbackStudent WHERE studentID = ?\n"
                + "DELETE FROM Attendance WHERE studentID = ?\n"
                + "DELETE FROM Student WHERE studentID = ?";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, sid);
            ps.setInt(2, sid);
            ps.setInt(3, sid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // List  5 Student by page
    @Override
    public List<Student> PagingStudent(int index) {
        Connection con = null;
        List<Student> list = new ArrayList<Student>();
        String query = "select s.*, c.className from Student s JOIN Class c on s.classID = c.classID\n"
                + "ORDER BY studentID\n"
                + "OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();

                student.setStudentID(rs.getInt("studentID"));
                student.setStudentImg(rs.getString("studentImg"));
                student.setStudentFirstName(rs.getString("studentFirstName"));
                student.setStudentLastName(rs.getString("studentLastName"));
                student.setGender(rs.getString("gender"));
                student.setLikeSomething(rs.getString("likeSomething"));
                student.setHateSomething(rs.getString("hateSomething"));
                student.setFavoriteFood(rs.getString("favoriteFood"));
                student.setHateFood(rs.getString("hateFood"));
                student.setBirthdate(rs.getString("birthdate"));
                student.setParentID(rs.getInt("parentID"));
                student.setClassID(rs.getInt("classID"));
                student.setClassName(rs.getString("className"));

                list.add(student);
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    // Get end page
    @Override
    public int getNumberEndPageStudent() {
        Connection con = null;
        String query = "SELECT COUNT(*) FROM Student";
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
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    //    *Add a Student And a Parent
    @Override
    public void AddInfoStudentParent(Parent parent, Student student) {
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
                String query = "INSERT INTO Parent VALUES(?, ?, ?," + accid + ",?, ?,?, ?)";
                PreparedStatement ps1 = con.prepareStatement(query);

                ps1.setString(1, parent.getParentImage());
                ps1.setString(2, parent.getParentFirstName());
                ps1.setString(3, parent.getParentLastName());
                ps1.setString(4, parent.getPhone());
                ps1.setString(5, parent.getDatebirth());
                ps1.setString(6, parent.getAddress());
                ps1.setString(7, parent.getJob());

                ps1.executeUpdate();
                //take id new a account
                String sql2 = "select top 1 parentID from Parent\n"
                        + "order by parentID desc";
                PreparedStatement ps2 = con.prepareStatement(sql2);
                ResultSet rs2 = ps2.executeQuery();
                if (rs2.next()) {
                    int parentID = rs2.getInt(1);
                    //add new student
                    String query2 = "INSERT INTO Student VALUES(?, ?, ?, ?,?,?,?,?,?"
                            + "," + parentID + ",?)";
                    PreparedStatement ps3 = con.prepareStatement(query2);

                    ps3.setString(1, student.getStudentImg());
                    ps3.setString(2, student.getStudentFirstName());
                    ps3.setString(3, student.getStudentLastName());
                    ps3.setString(4, student.getGender());
                    ps3.setString(5, student.getLikeSomething());
                    ps3.setString(6, student.getHateSomething());
                    ps3.setString(7, student.getFavoriteFood());
                    ps3.setString(8, student.getHateFood());
                    ps3.setString(9, student.getBirthdate());
                    ps3.setInt(10, student.getClassID());

                    ps3.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
