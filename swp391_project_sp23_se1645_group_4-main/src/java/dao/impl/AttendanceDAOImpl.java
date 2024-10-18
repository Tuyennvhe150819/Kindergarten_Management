/*
 * AttendanceDAO
 * 25/02/2023
 * 
 */
package dao.impl;

import entity.Attendance;
import entity.CheckAttendance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Student;
import dao.AttendanceDAOInterface;
import dao.StudentDAOInterface;

public class AttendanceDAOImpl extends DBContext implements AttendanceDAOInterface {

    @Override
    public List<CheckAttendance> checkAttendance(int classID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CheckAttendance> list = new ArrayList<CheckAttendance>();
        String query = "select distinct st.*, a.AttendanceID, c.className, s.note, s.[status]\n"
                + "from shedule s, Student st, Class c, Attendance a\n"
                + "where s.AttendanceID = a.AttendanceID\n"
                + "and st.studentID = s.studentID \n"
                + "and a.classID = c.classID\n"
                + "and st.classID = c.classID\n"
                + "and a.attendanceDate = FORMAT(GETDATE(), 'yyyy-MM-dd')\n"
                + "and st.classID = ?";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, classID);
            rs = ps.executeQuery();
            while (rs.next()) {
                CheckAttendance checkAttendance = new CheckAttendance();
                checkAttendance.setStudentID(rs.getInt("studentID"));
                checkAttendance.setStudentImg(rs.getString("studentImg"));
                checkAttendance.setStudentFirstName(rs.getString("studentFirstName"));
                checkAttendance.setStudentLastName(rs.getString("studentLastName"));
                checkAttendance.setGender(rs.getString("gender"));
                checkAttendance.setLikeSomething(rs.getString("likeSomething"));
                checkAttendance.setHateSomething(rs.getString("hateSomething"));
                checkAttendance.setFavoriteFood(rs.getString("favoriteFood"));
                checkAttendance.setHateFood(rs.getString("hateFood"));
                checkAttendance.setBirthdate(rs.getString("birthdate"));
                checkAttendance.setParentID(rs.getInt("parentID"));
                checkAttendance.setClassID(rs.getInt("classID"));
                checkAttendance.setAttendanceID(rs.getInt("attendanceID"));
                checkAttendance.setClassName(rs.getString("className"));
                checkAttendance.setNote(rs.getString("note"));
                checkAttendance.setStatus(rs.getString("status"));
                list.add(checkAttendance);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AttendanceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public List<CheckAttendance> viewAttendance(int classID, String date) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CheckAttendance> list = new ArrayList<CheckAttendance>();
        String query = "select distinct st.*, a.AttendanceID, c.className, s.note, s.[status]\n"
                + "from shedule s, Student st, Class c, Attendance a\n"
                + "where s.AttendanceID = a.AttendanceID\n"
                + "and st.studentID = s.studentID \n"
                + "and a.classID = c.classID\n"
                + "and st.classID = c.classID\n"
                + "and a.attendanceDate = '" + date + "'\n"
                + "and st.classID = ?";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, classID);
            rs = ps.executeQuery();
            while (rs.next()) {
                CheckAttendance checkAttendance = new CheckAttendance();
                checkAttendance.setStudentID(rs.getInt("studentID"));
                checkAttendance.setStudentImg(rs.getString("studentImg"));
                checkAttendance.setStudentFirstName(rs.getString("studentFirstName"));
                checkAttendance.setStudentLastName(rs.getString("studentLastName"));
                checkAttendance.setGender(rs.getString("gender"));
                checkAttendance.setLikeSomething(rs.getString("likeSomething"));
                checkAttendance.setHateSomething(rs.getString("hateSomething"));
                checkAttendance.setFavoriteFood(rs.getString("favoriteFood"));
                checkAttendance.setHateFood(rs.getString("hateFood"));
                checkAttendance.setBirthdate(rs.getString("birthdate"));
                checkAttendance.setParentID(rs.getInt("parentID"));
                checkAttendance.setClassID(rs.getInt("classID"));
                checkAttendance.setAttendanceID(rs.getInt("attendanceID"));
                checkAttendance.setClassName(rs.getString("className"));
                checkAttendance.setNote(rs.getString("note"));
                checkAttendance.setStatus(rs.getString("status"));
                list.add(checkAttendance);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AttendanceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public void Attended(String studentID, String attendanceID, String status, String note) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "UPDATE shedule set note = N'" + note + "', [status] = " + status + " where AttendanceID = " + attendanceID + " and studentID = " + studentID + "";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Attendance> showAttendance(int studentID, String week, String year) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Attendance> list = new ArrayList<Attendance>();
        String query = "select DatePart(\"w\", a.attendanceDate) dateweek, a.*, s.[status], s.studentID, s.note, c.className\n"
                + "from shedule s, Student st, Class c, Attendance a\n"
                + "where s.studentID = " + studentID + "\n"
                + "and st.studentID = s.studentID\n"
                + "and s.AttendanceID = a.AttendanceID\n"
                + "and st.classID = c.classID\n"
                + "and DatePart(\"ww\", a.attendanceDate) = " + week + "\n"
                + "and DatePart(\"yyyy\", a.attendanceDate) = " + year + "";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Attendance attendance = new Attendance();
                attendance.setDateweek(rs.getInt("dateweek"));
                attendance.setAttendanceID(rs.getInt("AttendanceID"));
                attendance.setAttendanceDate(rs.getString("attendanceDate"));
                attendance.setTitle(rs.getString("title"));
                attendance.setClassID(rs.getInt("classID"));
                attendance.setStatus(rs.getInt("status"));
                attendance.setStudentID(rs.getInt("studentID"));
                attendance.setNote(rs.getString("note"));
                attendance.setClassName(rs.getString("className"));
                list.add(attendance);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AttendanceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public List<Attendance> showTeacherSchedule(int teacherID, String week, String year) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Attendance> list = new ArrayList<Attendance>();
        String query = "select distinct DatePart(\"w\", a.attendanceDate) dateweek, a.*, c.className, \n"
                + "CASE WHEN s.[status] = 0 THEN 0 ELSE 1 END [status]\n"
                + "from Class c, Attendance a, Teacher t, shedule s\n"
                + "where c.teacherID = t.teacherID\n"
                + "and s.AttendanceID = a.AttendanceID\n"
                + "and t.teacherID = " + teacherID + "\n"
                + "and DatePart(\"ww\", a.attendanceDate) = " + week + "\n"
                + "and DatePart(\"yyyy\", a.attendanceDate) = " + year + "";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Attendance attendance = new Attendance();
                attendance.setDateweek(rs.getInt("dateweek"));
                attendance.setAttendanceID(rs.getInt("AttendanceID"));
                attendance.setAttendanceDate(rs.getString("attendanceDate"));
                attendance.setTitle(rs.getString("title"));
                attendance.setClassID(rs.getInt("classID"));
                attendance.setClassName(rs.getString("className"));
                attendance.setStatus(rs.getInt("status"));
                list.add(attendance);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AttendanceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public void AddAttendance(Attendance attendance) {
        Connection con = null;
        try {
            String query = "insert into Attendance values(?, ?, ?)";
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, attendance.getAttendanceDate());
            ps.setString(2, attendance.getTitle());
            ps.setInt(3, attendance.getClassID());
            ps.executeUpdate();

            String query1 = "Select top 1 a.AttendanceID from Attendance a\n"
                    + "where a.classID = ?\n"
                    + "order by a.AttendanceID DESC";
            PreparedStatement ps1 = con.prepareStatement(query1);
            ps1.setInt(1, attendance.getClassID());
            ResultSet rs1 = ps1.executeQuery();
            if (rs1.next()) {
                int attendID = rs1.getInt(1);
                StudentDAOInterface studentDAOInterface = new StudentDAOImpl();
                List<Student> students = studentDAOInterface.ListViewStudent(attendance.getClassID());
                for (Student st : students) {
                    String query2 = "insert into shedule values(?, ?, 0, NULL)";
                    PreparedStatement ps3 = con.prepareStatement(query2);
                    ps3.setInt(1, attendID);
                    ps3.setInt(2, st.getStudentID());
                    ps3.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AttendanceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Attendance> PagingAttendance(int index) {
        Connection con = null;
        List<Attendance> list = new ArrayList<Attendance>();
        String query = "SELECT distinct a.*, c.className,\n"
                + "CASE WHEN sh.[status] = 0 THEN 0 ELSE 1 END [status]\n"
                + "FROM Attendance a LEFT JOIN Class c ON a.classID = c.classID\n"
                + "LEFT JOIN shedule sh ON a.AttendanceID = sh.AttendanceID\n"
                + "LEFT JOIN Student s ON sh.studentID = s.studentID\n"
                + "ORDER BY AttendanceID\n"
                + "OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY";
        try {
            // Open the database connection
            con = connection;   
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Attendance attendance = new Attendance();

                attendance.setAttendanceID(rs.getInt("AttendanceID"));
                attendance.setAttendanceDate(rs.getString("attendanceDate"));
                attendance.setTitle(rs.getString("title"));
                attendance.setClassID(rs.getInt("classID"));
                attendance.setClassName(rs.getString("className"));
                attendance.setStatus(rs.getInt("status"));
                list.add(attendance);
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(AttendanceDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AttendanceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    // Get end page
    @Override
    public int getNumberEndPageAttendance() {
        Connection con = null;
        String query = "SELECT COUNT(*) FROM Attendance";
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
            Logger.getLogger(AttendanceDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    // View Attendance by id
    @Override
    public Attendance ViewAttendanceByID(int id) {
        Connection con = null;
        String query = "SELECT * FROM Attendance\n"
                + "WHERE AttendanceID = ?";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Attendance attendance = new Attendance();

                attendance.setAttendanceID(rs.getInt("AttendanceID"));
                attendance.setAttendanceDate(rs.getString("attendanceDate"));
                attendance.setTitle(rs.getString("title"));
                attendance.setClassID(rs.getInt("classID"));

                return attendance;
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(AttendanceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AttendanceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    //    *Update a Attendance
    @Override
    public void UpdateAttendance(Attendance attendance) {
        Connection con = null;
        String query = "UPDATE Attendance SET attendanceDate = ?, title = ?, classID = ?\n"
                + "WHERE AttendanceID = ?";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, attendance.getAttendanceDate());
            ps.setString(2, attendance.getTitle());
            ps.setInt(3, attendance.getClassID());
            ps.setInt(4, attendance.getAttendanceID());

            ps.executeUpdate();
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(AttendanceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AttendanceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        AttendanceDAOImpl p = new AttendanceDAOImpl();
        List<Attendance> a = p.showAttendance(1, "10", "2023");
        for (Attendance s : a) {
            System.out.println(s);
        }
    }
}
