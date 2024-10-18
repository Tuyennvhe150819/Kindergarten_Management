/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Account;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface AccountDAOInterface {
    // Login by email and password
    public Account checkLogin (String email, String password);
    // change pass word
    public void ChangePass (String pass, int accountID);
    // List  5 accounts by page
    public List<Account> PagingAccount(int index);
    
    // view Account by id
    public Account viewAccountbyID(int id);
    
    //    *Add a account
    public void AddAccount(Account account);
    
    //    *Update a account
    public void UpdateAccount(Account account);   
    
    //Get end page
    public int getNumberEndPageAccount();
}
