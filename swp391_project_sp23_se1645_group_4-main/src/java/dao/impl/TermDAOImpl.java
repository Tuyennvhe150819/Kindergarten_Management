/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import entity.Term;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.TermDAOInterface;

public class TermDAOImpl extends DBContext implements TermDAOInterface {

    @Override
    public List<Term> ShowTerm() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Term> list = new ArrayList<Term>();
        String query = "select t.* from Term t\n"
                + "order by t.termID DESC\n";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Term term = new Term();
                term.setTermID(rs.getInt("termID"));
                term.setTermName(rs.getString("termName"));
                term.setStartdate(rs.getString("startdate"));
                term.setEnddate(rs.getString("enddate"));
                list.add(term);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TermDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TermDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    // List  5 Term by page
    @Override
    public List<Term> PagingTerm(int index) {
        Connection con = null;
        List<Term> list = new ArrayList<Term>();
        String query = "SELECT * FROM Term\n" +
                        "ORDER BY termID\n" +
                        "OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, (index - 1)*5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Term term = new Term();

                term.setTermID(rs.getInt("termID"));
                term.setTermName(rs.getString("termName"));
                term.setStartdate(rs.getString("startdate"));
                term.setEnddate(rs.getString("enddate"));

                list.add(term);
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(TermDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TermDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    // View Term by id
    @Override
    public Term ShowTermByID(int id) {
        Connection con = null;
        String query = "select * from Term where termID=?";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Term term = new Term();

                term.setTermID(rs.getInt("termID"));
                term.setTermName(rs.getString("termName"));
                term.setStartdate(rs.getString("startdate"));
                term.setEnddate(rs.getString("enddate"));

                return term;
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(TermDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TermDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    //   *Search Term By termname, class name

    @Override
    public List<Term> searchTermBysubject(String txtSearch) {
        Connection con = null;
        List<Term> list = new ArrayList<Term>();
        String query = "SELECT t.* FROM Term \n"
                + "WHERE t.termName LIKE ?";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Term term = new Term();

                term.setTermID(rs.getInt("termID"));
                term.setTermName(rs.getString("termName"));
                term.setStartdate(rs.getString("startdate"));
                term.setEnddate(rs.getString("enddate"));

                list.add(term);
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(TermDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TermDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    //  *Add a Term
    @Override
    public void AddTerm(Term term) {
        Connection con = null;
        String query = "INSERT INTO Term VALUES(?,?,?)";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, term.getTermName());
            ps.setString(2, term.getStartdate());
            ps.setString(3, term.getEnddate());

            ps.executeUpdate();
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(TermDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TermDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //    *Update a Term
    @Override
    public void UpdateTerm(Term term) {
        Connection con = null;
        String query = "UPDATE Term SET termName = ?, startdate = ?, enddate = ?"
                + " WHERE termID = ?";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, term.getTermName());
            ps.setString(2, term.getStartdate());
            ps.setString(3, term.getEnddate());
            ps.setInt(4, term.getTermID());

            ps.executeUpdate();
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(TermDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TermDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //    *Delete a Term
    @Override
    public void deleteTerm(int tid) {
        Connection con = null;
        String query = "DELETE FROM Term WHERE termID = ?";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, tid);
            ps.executeUpdate();
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(TermDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TermDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Get end page
    @Override
    public int getNumberEndPageTerm() {
        Connection con = null;
        String query = "SELECT COUNT(*) FROM Term";
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
            Logger.getLogger(TermDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
}
