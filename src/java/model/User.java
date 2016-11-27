/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */
public class User {
    private int user_id;
    private String user_name;
    private String user_email;
    private String user_password;
    private String user_phonenumber;
    private boolean user_role;

    public User(String user_name, String user_email, String user_password, String user_phonenumber, boolean user_role) {
        
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_phonenumber = user_phonenumber;
        this.user_role = user_role;
    }

    public User() {
        this.user_id = 0;
        this.user_name = "";
        this.user_email = "";
        this.user_password = "";
        this.user_phonenumber = "";
        this.user_role = false;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }




    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_phonenumber() {
        return user_phonenumber;
    }

    public void setUser_phonenumber(String user_phonenumber) {
        this.user_phonenumber = user_phonenumber;
    }

    public boolean isUser_role() {
        return user_role;
    }

    public void setUser_role(boolean user_role) {
        this.user_role = user_role;
    }
    
    
}
