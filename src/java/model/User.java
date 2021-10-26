/*
 * User.java
 * 
 * All Rights Reserved 
 * Copyright (c) 2020 FPT University
 */
package model;


public class User {
    /** Store username, password, email */
    private String user, pwd, email;
    /** Store role */
    private boolean role;

    /**
     * Constructor.<br>
     */
    public User() {
    }

    /**
     * Constructor.<br>
     * 
     * @param user
     * @param pwd
     * @param email
     * @param role 
     */
    public User(String user, String pwd, String email, boolean role) {
        this.user = user;
        this.pwd = pwd;
        this.email = email;
        this.role = role;
    }

    /**
     * getUser.<br>
     * 
     * @return the username
     */
    public String getUser() {
        return user;
    }

    /**
     * getPwd.<br>
     * 
     * @return the password
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * getEmail.<br>
     * 
     * @return the email 
     */
    public String getEmail() {
        return email;
    }

    /**
     * isRole.<br>
     * 
     * @return true or false
     */
    public boolean isRole() {
        return role;
    }

    /**
     * setUser.<br>
     * 
     * @param user 
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * setPwd.<br>
     * 
     * @param pwd 
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * setEmail.<br>
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * setRole.<br>
     * 
     * @param role 
     */
    public void setRole(boolean role) {
        this.role = role;
    }

    
    
    
}
