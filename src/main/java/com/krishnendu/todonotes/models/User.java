package com.krishnendu.todonotes.models;


import javax.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String password;
    private Boolean active;
    private String roles;

    public User() {
        this.active = true;
        this.roles = "ROLE_USER";
    }
    public User(String userName, String password, Boolean active, String roles) {
        this.userName = userName;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.active = active;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public String getRoles() {
        return roles;
    }
    public void setRoles(String roles) {
        this.roles = roles;
    }
}
