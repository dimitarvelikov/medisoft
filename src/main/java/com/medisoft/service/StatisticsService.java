package com.medisoft.service;

import com.medisoft.model.Statistics;
import com.medisoft.repository.MedicalCaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final MedicalCaseRepository medicalCaseRepository;

    public Statistics getStats() {

        return Statistics.builder()
                .newPatientsToday(3)
                .newPatientsThisWeek(123)
                .newPatientsBeginningOfMonth(500)
                .newPatientsLast30d(1112)
                .build();
    }
}
