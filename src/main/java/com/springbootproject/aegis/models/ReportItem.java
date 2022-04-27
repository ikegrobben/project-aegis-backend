package com.springbootproject.aegis.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.naming.Name;
import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "reportitem")
public class ReportItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    Long id;

    LocalDateTime reportItemDateTime;

    @Type(type = "text")
    String content;

    String status;


    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @ManyToOne
    @JoinColumn(name = "location_id")
    Location location;


// Categories, Locations, Images Users

    @Lob
    String image;

    @ManyToOne
    @JoinColumn(name = "report_id")
    Report report;

    @ManyToOne
    @JoinColumn(name = "users_id")
    Users users;

    public Users getUsers() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getReportItemDateTime() {
        return reportItemDateTime;
    }

    public void setReportItemDate(LocalDateTime reportItemDateTime) {
        this.reportItemDateTime = reportItemDateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
