package com.springbootproject.aegis.repositories;


import com.springbootproject.aegis.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDate;
import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    Report findTopByOrderByIdDesc();
    List<Report> findFirstByOrderByIdDesc();
    List<Report> findByIdEquals(Long id);
}
