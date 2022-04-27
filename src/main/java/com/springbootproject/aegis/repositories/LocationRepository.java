package com.springbootproject.aegis.repositories;

import com.springbootproject.aegis.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
