package com.puzikov.domain;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author APuzikov
 * @version 1.0
 * @since <pre>06/27/2016</pre>
 */
public class Spitter {
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long")
    @Pattern(regexp = "^[a-zA-Z0-9]$", message = "Username must consist only from letters and numbers")
    private String name;


    @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters long")
    private String password;

    private String fullName;
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}" ,
            message = "Invalid email address.")
    private String email;

    private boolean emailUpdates;
    private String image;

    public void setEmailUpdates(boolean emailUpdates) {
        this.emailUpdates = emailUpdates;
    }

    public void setImage(String img) {
        this.image = img;
    }

    public boolean isEmailUpdates() {
        return emailUpdates;
    }

    public String getImage() {
        return image;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Spitter(String name) {
        this.name = name;
    }
}
