package com.medisoft.repository;

import com.medisoft.model.MedicalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalCaseRepository extends JpaRepository<MedicalCase, Integer> {
}
