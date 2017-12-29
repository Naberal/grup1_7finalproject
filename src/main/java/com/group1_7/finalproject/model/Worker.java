package com.group1_7.finalproject.model;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "workers")
public class Worker extends UUIdModel {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String pass;
    @Transient
    private String confirmPass;
    @ManyToMany//todo
    @JoinColumn(table = "post", name = "post", referencedColumnName = "post")
    private Long post;
    @ManyToMany//todo
    @JoinColumn(table = "post", name = "post", referencedColumnName = "post")
    private long department;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
//    private Time time;//todo

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Long getPost() {
        return post;
    }

    public void setPost(Long post) {
        this.post = post;
    }


    public long getDepartment() {
        return department;
    }

    public void setDepartment(long department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", post=" + post +
                ", department=" + department;
    }
}
