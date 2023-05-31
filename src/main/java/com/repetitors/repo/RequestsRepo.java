package com.repetitors.repo;

import com.repetitors.model.Requests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestsRepo extends JpaRepository<Requests, Long> {

}
