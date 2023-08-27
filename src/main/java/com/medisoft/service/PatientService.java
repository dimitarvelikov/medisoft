package com.medisoft.service;

import com.medisoft.model.Address;
import com.medisoft.model.Patient;
import com.medisoft.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public void create(Patient patient) {
        var adr = new Address();

        adr.setCity("Varna");
        adr.setLine("Nayden Gerov 6");
        adr.setCounty("Varna");
        adr.setPostalCode("9000");
        adr.setCountry("Bulgaria");

        patient.setAddress(adr);

        patientRepository.save(patient);
    }

}
