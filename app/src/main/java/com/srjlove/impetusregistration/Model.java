package com.srjlove.impetusregistration;

/**
 * Created by Suraj on 11/17/2017.
 */

public class Model {

    private String fname;
    private String lname;
    private String email;
    private int mob;
    private int pass;
    private byte[] image;

    public Model(String fname, String lname, String email, int mob, int pass, byte[] image) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.mob = mob;
        this.pass = pass;
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMob() {
        return mob;
    }

    public void setMob(int mob) {
        this.mob = mob;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }
}
