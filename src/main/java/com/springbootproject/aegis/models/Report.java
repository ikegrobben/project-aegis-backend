package com.springbootproject.aegis.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;

@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    Long id;

    LocalDate reportDate;

    @OneToMany(mappedBy = "report")
    @JsonIgnore
    List<ReportItem> reportItem;

    public Long getId() {
        return id;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public List<ReportItem> getReportItem() {
        return reportItem;
    }

    public void setReportItem(List<ReportItem> reportItem) {
        this.reportItem = reportItem;
    }
}

