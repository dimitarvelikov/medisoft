package com.medisoft.web;

import com.medisoft.service.MedicalCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/medical-case")
public class MedicalCaseController {

    private final MedicalCaseService medicalCaseService;

    @GetMapping
    public void getByPatientId() {

    }

    @PostMapping
    public void create() {

    }

    @PutMapping
    public void update() {

    }

}
