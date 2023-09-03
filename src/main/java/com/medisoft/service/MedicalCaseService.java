package com.medisoft.service;

import com.medisoft.repository.MedicalCaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MedicalCaseService {

    private final MedicalCaseRepository medicalCaseRepository;

}
