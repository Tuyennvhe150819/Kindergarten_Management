/*
 * AccountDAO
 * 10/03/2023
 * 
 */
package dao.impl;

import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import dao.AccountDAOInterface;

/**
 *
 * @author Asus
 */
public class AccountDAOImpl extends DBContext implements AccountDAOInterface {
    @Override
    public Account checkLogin(String email, String password) {
        String query = "select a.* from Account a\n"
                + "where a.email = ?\n"
                + "and a.[password] = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setAccountID(rs.getInt("accountID"));
                account.setEmail(rs.getString("email"));
                account.setPassword(rs.getString("password"));
                account.setRole(rs.getInt("role"));
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public void ChangePass(String pass, int accountID) {
        String query = "update Account set password = '"+pass+"' where accountID = "+accountID+"";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    // List  5 accounts by page
    @Override
    public List<Account> PagingAccount(int index) {
        Connection con = null;
        List<Account> list = new ArrayList<Account>();
        String query = "SELECT * FROM Account\n" +
                        "ORDER BY accountID\n" +
                        "OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, (index - 1)*5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setAccountID(rs.getInt("accountID"));
                account.setEmail(rs.getString("email"));
                account.setPassword(rs.getString("password"));
                account.setRole(rs.getInt("role"));
                list.add(account);
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        } 
        finally {
            // Close the database connection, even if an exception occurred
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    // view Account by account id
    @Override
    public Account viewAccountbyID(int id) {
        Connection con = null;
        String query = "select a.* from Account a\n"
                + "where a.accountID = ?";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setAccountID(rs.getInt("accountID"));
                account.setEmail(rs.getString("email"));
                account.setPassword(rs.getString("password"));
                account.setRole(rs.getInt("role"));
                return account;
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Close the database connection, even if an exception occurred
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    //    *Add a account
    @Override
    public void AddAccount(Account account) {
        Connection con = null;
        String query = "INSERT INTO Account VALUES(?,?,?)";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, account.getEmail());
            ps.setString(2, account.getPassword());
            ps.setInt(3, account.getRole());

            ps.executeUpdate();
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Close the database connection, even if an exception occurred
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //    *Update a account
    @Override
    public void UpdateAccount(Account account) {
        Connection con = null;
        String query = "UPDATE Account set email = ?, password = ?, role = ?\n"
                + "WHERE accountID = ?";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, account.getEmail());
            ps.setString(2, account.getPassword());
            ps.setInt(3, account.getRole());
            ps.setInt(4, account.getAccountID());

            ps.executeUpdate();
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Close the database connection, even if an exception occurred
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Get end page
    @Override
    public int getNumberEndPageAccount() {
        Connection con = null;
        String query = "SELECT COUNT(*) FROM Account";
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
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, e);       
        }
        return 0;
    }  
}
