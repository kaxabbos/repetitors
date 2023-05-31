package com.repetitors.repo;

import com.repetitors.model.AdDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdDescriptionRepo extends JpaRepository<AdDescription, Long> {
}
