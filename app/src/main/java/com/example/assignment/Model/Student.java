package com.example.assignment.Model;

public class Student {
    private String address;
    private String fullname;
    private String phone;

    private String degree_title;

    public Student(String address, String fullname, String phone, String degree_title) {
        this.address = address;
        this.fullname = fullname;
        this.phone = phone;
        this.degree_title = degree_title;
    }

    public Student() {

    }

    public void setDegree_title(String degree_title) {
        this.degree_title = degree_title;
    }

    public String getDegree_title() {
        return degree_title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
