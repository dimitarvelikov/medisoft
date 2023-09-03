package com.medisoft.repository;

import com.medisoft.model.MedicalCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalCaseRepository extends JpaRepository<MedicalCase, Integer> {
}
