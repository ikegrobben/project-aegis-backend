package com.springbootproject.aegis.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    Long id;

    String username;
    String firstname;
    String lastname;
    @JsonIgnore
    String password;
    String role;

    @ManyToOne
    @JoinColumn(name = "job_id")
    JobRole job;

    @OneToMany(mappedBy = "users")
    @JsonIgnore
    List<ReportItem> reportItems;

    public List<ReportItem> getReportItems() {
        return reportItems;
    }

    public void setReportItem(List<ReportItem> reportItems) {
        this.reportItems = reportItems;
    }

    public JobRole getJob() {
        return job;
    }

    public void setJob(JobRole job) {
        this.job = job;
    }

    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean enabled;


    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
