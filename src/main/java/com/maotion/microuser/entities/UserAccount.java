package com.maotion.microuser.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Map;

@Entity
public class UserAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "user name cannot be null")
    @Size(min = 3, message = "user name must not be less than 3 characters")
    private String userName;
    @Email
    private String email;
    private boolean enabled = true;
    private String role;
    @NotNull(message = "password cannot be null")
    private String password;


    @JsonProperty("user")
    private void unpackRawUserAccount(Map<String, Object> user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        this.userName = (String) user.get("user_name");
        this.email = (String) user.get("email");
        this.role = (String) user.get("role");
        this.password = bCryptPasswordEncoder.encode((String) user.get("password"));
    }

    protected UserAccount() {
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
