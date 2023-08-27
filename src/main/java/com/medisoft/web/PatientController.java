package com.medisoft.web;

import com.medisoft.model.Patient;
import com.medisoft.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/patient")
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public List<Patient> findAll() {
        return patientService.findAll();
    }

    @PostMapping
    public void create(@RequestBody @Valid Patient patient) {
        patientService.create(patient);

    }
}
