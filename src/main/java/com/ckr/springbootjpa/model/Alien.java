package com.ckr.springbootjpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Alien {
    @Id
    int sid;
    String sname;

    public Alien() {

    }

    public Alien(int sid, String sname) {
        this.sid = sid;
        this.sname = sname;
    }



    public String getSname() {
        return sname;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Alien [aid=" + sid + ", aname=" + sname + "]";
    }
}
