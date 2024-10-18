/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Asus
 */
public class Account {
    private int accountID;
    @NotBlank
    @Email(message = "Please enter a valid e-mail address")
    private String email;
    private String password;
    private int role;

    public Account() {
    }

    public Account(int accountID, String email, String password, int role) {
        this.accountID = accountID;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public Account(String email, String password, int role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" + "accountID=" + accountID + ", email=" + email + ", password=" + password + ", role=" + role + '}';
    }
    
    
}
