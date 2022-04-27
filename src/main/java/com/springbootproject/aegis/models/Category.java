package com.springbootproject.aegis.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue
    int id;

    String name;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    List<ReportItem> reportItem;

    public List<ReportItem> getReportItem() {
        return reportItem;
    }

    public void setReportItem(List<ReportItem> reportItem) {
        this.reportItem = reportItem;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
