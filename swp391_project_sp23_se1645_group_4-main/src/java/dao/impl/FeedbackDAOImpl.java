/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import entity.FeedBackTeacher;
import entity.FeedbackStudent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import dao.FeedbackDAOInterface;

/**
 *
 * @author Asus
 */
public class FeedbackDAOImpl extends DBContext implements FeedbackDAOInterface {

    @Override
    public void feedbackStudent(FeedbackStudent feedback) {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "insert into FeedbackStudent values (" + feedback.getTeacherID() + ", " + feedback.getStudentID() + ", N'" + feedback.getNote() + "', '" + feedback.getRank() + "', N'" + feedback.getAttitude() + "', GETDATE())";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public FeedbackStudent ShowFeedBackStudent(int studentID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select f.*, t.teacherFirstName, t.teacherLastName, s.studentFirstName, s.studentLastName\n"
                + "from Student s, Class c, Teacher t, FeedbackStudent f\n"
                + "where s.classID = c.classID\n"
                + "and c.teacherID = t.teacherID\n"
                + "and f.studentID = s.studentID\n"
                + "and f.teacherID = t.teacherID\n"
                + "and s.studentID = ?";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, studentID);
            rs = ps.executeQuery();
            while (rs.next()) {
                FeedbackStudent feedback = new FeedbackStudent();
                feedback.setTeacherID(rs.getInt("teacherID"));
                feedback.setStudentID(rs.getInt("studentID"));
                feedback.setNote(rs.getString("note"));
                feedback.setRank(rs.getString("rank"));
                feedback.setAttitude(rs.getString("attitude"));
                feedback.setFeedbackDay(rs.getString("feedbackDay"));
                feedback.setTeacherFirstName(rs.getString("teacherFirstName"));
                feedback.setTeacherLastName(rs.getString("teacherLastName"));
                feedback.setStudentFirstName(rs.getString("studentFirstName"));
                feedback.setStudentLastName(rs.getString("studentLastName"));

                return feedback;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void updateFeedBackStudent(FeedbackStudent feedback) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "update FeedbackStudent set note = N'" + feedback.getNote() + "', [rank] = " + feedback.getRank() + ", attitude = N'" + feedback.getAttitude() + "' ,feedbackDay = GETDATE()\n"
                + "where teacherID = " + feedback.getTeacherID() + " and studentID = " + feedback.getStudentID() + "";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public FeedBackTeacher ShowFeedBackTeacher(int teacherID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select f.*, c.classID\n"
                + "from Student s, Class c, Teacher t, FeedbackTeacher f, Parent p\n"
                + "where s.classID = c.classID\n"
                + "and c.teacherID = t.teacherID\n"
                + "and f.parentID = s.parentID\n"
                + "and f.teacherID = t.teacherID\n"
                + "and t.teacherID = ?";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, teacherID);
            rs = ps.executeQuery();
            while (rs.next()) {
                FeedBackTeacher feedBackTeacher = new FeedBackTeacher();
                feedBackTeacher.setTeacherID(rs.getInt("teacherID"));
                feedBackTeacher.setParentID(rs.getInt("parentID"));
                feedBackTeacher.setNote(rs.getString("note"));
                feedBackTeacher.setRank(rs.getString("rank"));
                feedBackTeacher.setAttitude(rs.getString("attitude"));
                feedBackTeacher.setFeedbackDay(rs.getString("feedbackDay"));
                feedBackTeacher.setClassID(rs.getInt("classID"));
                return feedBackTeacher;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void feedbackTeacher(FeedBackTeacher feedBackTeacher) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "insert into FeedbackTeacher values ('" + feedBackTeacher.getTeacherID() + "', '" + feedBackTeacher.getParentID() + "', N'" + feedBackTeacher.getNote() + "', '" + feedBackTeacher.getRank() + "', N'" + feedBackTeacher.getAttitude() + "', GETDATE())";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void updateFeedBackTeacher(FeedBackTeacher feedBackTeacher) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "update FeedbackTeacher set note = N'" + feedBackTeacher.getNote() + "', [rank] = '" + feedBackTeacher.getRank() + "', "
                + "attitude = N'" + feedBackTeacher.getAttitude() + "' ,feedbackDay = GETDATE()\n"
                + "where parentID = '" + feedBackTeacher.getParentID() + "' and teacherID = '" + feedBackTeacher.getTeacherID() + "'";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // View FeedbackStudent
    @Override
    public List<FeedbackStudent> ListFeedbackStudent() {
        Connection con = null;
        List<FeedbackStudent> list = new ArrayList<FeedbackStudent>();
        String query = "select ft.*, t.teacherFirstName, t.teacherLastName, st.studentFirstName, st.studentLastName\n"
                + "from FeedbackStudent ft LEFT JOIN Teacher t on ft.teacherID = t.teacherID\n"
                + "LEFT JOIN Student st on ft.studentID = st.studentID";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FeedbackStudent feedbackStudent = new FeedbackStudent();

                feedbackStudent.setTeacherID(rs.getInt("teacherID"));
                feedbackStudent.setStudentID(rs.getInt("studentID"));
                feedbackStudent.setTeacherFirstName(rs.getString("teacherFirstName"));
                feedbackStudent.setTeacherLastName(rs.getString("teacherLastName"));
                feedbackStudent.setStudentFirstName(rs.getString("studentFirstName"));
                feedbackStudent.setStudentLastName(rs.getString("studentLastName"));
                feedbackStudent.setNote(rs.getString("note"));
                feedbackStudent.setRank(rs.getString("rank"));
                feedbackStudent.setAttitude(rs.getString("attitude"));
                feedbackStudent.setFeedbackDay(rs.getString("feedbackDay"));

                list.add(feedbackStudent);
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    // List  5 FeedbackStudent by page
    @Override
    public List<FeedbackStudent> PagingFeedbackStudent(int index) {
        Connection con = null;
        List<FeedbackStudent> list = new ArrayList<FeedbackStudent>();
        String query = "select ft.*, t.teacherFirstName, t.teacherLastName, st.studentFirstName, st.studentLastName\n"
                + "from FeedbackStudent ft LEFT JOIN Teacher t on ft.teacherID = t.teacherID\n"
                + "LEFT JOIN Student st on ft.studentID = st.studentID\n"
                + "ORDER BY studentID\n"
                + "OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, (index - 1) * 10);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FeedbackStudent feedbackStudent = new FeedbackStudent();

                feedbackStudent.setTeacherID(rs.getInt("teacherID"));
                feedbackStudent.setStudentID(rs.getInt("studentID"));
                feedbackStudent.setTeacherFirstName(rs.getString("teacherFirstName"));
                feedbackStudent.setTeacherLastName(rs.getString("teacherLastName"));
                feedbackStudent.setStudentFirstName(rs.getString("studentFirstName"));
                feedbackStudent.setStudentLastName(rs.getString("studentLastName"));
                feedbackStudent.setNote(rs.getString("note"));
                feedbackStudent.setRank(rs.getString("rank"));
                feedbackStudent.setAttitude(rs.getString("attitude"));
                feedbackStudent.setFeedbackDay(rs.getString("feedbackDay"));

                list.add(feedbackStudent);
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    // Get end page

    @Override
    public int getNumberEndPageFeedbackStudent() {
        Connection con = null;
        String query = "SELECT COUNT(*) FROM FeedbackStudent";
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
            Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    // View FeedbackTeacher
    @Override
    public List<FeedBackTeacher> ListFeedbackTeacher(int index, int teachID) {
        Connection con = null;
        List<FeedBackTeacher> list = new ArrayList<FeedBackTeacher>();
        String query = "select ft.*, t.teacherFirstName, t.teacherLastName, p.parentFirstName, p.parentLastName \n"
                + "from FeedBackTeacher ft LEFT JOIN Teacher t on ft.teacherID = t.teacherID\n"
                + "LEFT JOIN Parent p on ft.parentID = p.parentID\n"
                + "where t.teacherID = "+teachID+"\n"
                + "order by t.teacherID DESC\n"
                + "OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FeedBackTeacher feedBackTeacher = new FeedBackTeacher();

                feedBackTeacher.setTeacherID(rs.getInt("teacherID"));
                feedBackTeacher.setParentID(rs.getInt("parentID"));
                feedBackTeacher.setTeacherFirstName(rs.getString("teacherFirstName"));
                feedBackTeacher.setTeacherLastName(rs.getString("teacherLastName"));
                feedBackTeacher.setParentFirstName(rs.getString("parentFirstName"));
                feedBackTeacher.setParentLastName(rs.getString("parentLastName"));
                feedBackTeacher.setNote(rs.getString("note"));
                feedBackTeacher.setRank(rs.getString("rank"));
                feedBackTeacher.setAttitude(rs.getString("attitude"));
                feedBackTeacher.setFeedbackDay(rs.getString("feedbackDay"));

                list.add(feedBackTeacher);
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    // List  5 FeedBackTeacher by page
    @Override
    public List<FeedBackTeacher> PagingFeedBackTeacher(int index) {
        Connection con = null;
        List<FeedBackTeacher> list = new ArrayList<FeedBackTeacher>();
        String query = "select ft.*, t.teacherFirstName, t.teacherLastName, p.parentFirstName, p.parentLastName\n"
                + "from FeedBackTeacher ft LEFT JOIN Teacher t on ft.teacherID = t.teacherID\n"
                + "LEFT JOIN Parent p on ft.parentID = p.parentID\n"
                + "ORDER BY teacherID\n"
                + "OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FeedBackTeacher feedBackTeacher = new FeedBackTeacher();

                feedBackTeacher.setTeacherID(rs.getInt("teacherID"));
                feedBackTeacher.setParentID(rs.getInt("parentID"));
                feedBackTeacher.setTeacherFirstName(rs.getString("teacherFirstName"));
                feedBackTeacher.setTeacherLastName(rs.getString("teacherLastName"));
                feedBackTeacher.setParentFirstName(rs.getString("parentFirstName"));
                feedBackTeacher.setParentLastName(rs.getString("parentLastName"));
                feedBackTeacher.setNote(rs.getString("note"));
                feedBackTeacher.setRank(rs.getString("rank"));
                feedBackTeacher.setAttitude(rs.getString("attitude"));
                feedBackTeacher.setFeedbackDay(rs.getString("feedbackDay"));

                list.add(feedBackTeacher);
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    // Get end page
    @Override
    public int getNumberEndPageFeedBackTeacher() {
        Connection con = null;
        String query = "SELECT COUNT(*) FROM FeedBackTeacher";
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
            Logger.getLogger(FeedbackDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
    public static void main(String[] args) {
        FeedbackDAOImpl f = new FeedbackDAOImpl();
        FeedBackTeacher a = new FeedBackTeacher(1, 1, "sa", "good", "s");
        f.updateFeedBackTeacher(a);
    }
}
