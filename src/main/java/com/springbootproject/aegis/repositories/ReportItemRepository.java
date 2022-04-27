package com.springbootproject.aegis.repositories;


import com.springbootproject.aegis.models.ReportItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportItemRepository extends JpaRepository<ReportItem, Long> {
    List<ReportItem> findByStatus(String status);
    List<ReportItem> findAllByOrderByCategoryNameAsc();
}
