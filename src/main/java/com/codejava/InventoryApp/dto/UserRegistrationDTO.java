package com.codejava.InventoryApp.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRegistrationDTO {

    private Long id;

    @Email
    @NotBlank
    private String email;

    @Size(min = 5, message = "Password must be at least 5 characters")
    private String password;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Invalid input")
    private String firstName;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Invalid input")
    private String lastName;

    private boolean enabled;

    public UserRegistrationDTO() {
    }

    public UserRegistrationDTO(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
