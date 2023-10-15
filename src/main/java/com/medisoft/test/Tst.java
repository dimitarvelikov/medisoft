package com.medisoft.test;

import com.medisoft.repository.HospitalDepartmentRepository;
import com.medisoft.repository.HospitalRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Tst {

    private final HospitalRepository hospitalRepository;
    private final HospitalDepartmentRepository hospitalDepartmentRepository;

    @PostConstruct
    @Transactional
    public void init() {
//        var h = hospitalRepository.findAll().get(0);
//        var hd = HospitalDepartment.builder().capacity(100).name("heart").hospital(h).build();
//        hospitalDepartmentRepository.save(hd);

 //       var allhd = hospitalRepository.findAll();

    }

}
