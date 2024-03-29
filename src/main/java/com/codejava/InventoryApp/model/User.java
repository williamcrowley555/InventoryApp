package com.codejava.InventoryApp.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "User")
@Table(name = "user",
        uniqueConstraints = {
        @UniqueConstraint(name = "user_email_unique", columnNames = "email")
        })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, length = 45)
    @Email
    @NotBlank
    private String email;

    @Column(name = "password", nullable = false)
    @Size(min = 5, message = "Password must be at least 5 characters")
    private String password;

    @Column(name = "first_name", nullable = false)
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Invalid input")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Invalid input")
    private String lastName;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
            )
    @Valid
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(@Email @NotBlank String email, @Size(min = 5, message = "Password must be at least 5 characters") String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, boolean enabled) {
        this.email = email;
        this.password = password;
        this.enabled = enabled;
    }

    public User(String email, String password, String firstName, String lastName, boolean enabled, Set<Role> roles) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enabled = enabled;
        this.roles = roles;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public void removeRole(Role role) {
        this.roles.remove(role);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                '}';
    }
}
