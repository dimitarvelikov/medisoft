package com.medisoft.repository;

import com.medisoft.model.HospitalDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalDepartmentRepository extends JpaRepository<HospitalDepartment, Integer> {
}
