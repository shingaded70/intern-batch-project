package com.example.internbatch.repository;

import com.example.internbatch.model.Intern;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface InternRepository extends JpaRepository<Intern, Long> {
    List<Intern> findByDateOfJoining(LocalDate date);
    List<Intern> findByBatchId(Long batchId);
    long countByDateOfJoiningAndIdCardType(LocalDate date, String idCardType);
    boolean existsByInternId(String internId);
}
