package com.springbootproject.aegis.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue
    Long id;

    String name;

    @OneToMany(mappedBy = "location")
    @JsonIgnore
    List<ReportItem> reportItem;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ReportItem> getReportItem() {
        return reportItem;
    }

    public void setReportItem(List<ReportItem> reportItem) {
        this.reportItem = reportItem;
    }
}
