package com.medisoft.web;

import com.medisoft.report.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/report")
public class ReportController {

    private final ReportService reportService;

    @GetMapping("{labExamId}")
    public void downloadLabExamReport(@PathVariable("labExamId") long labExamId) {
        reportService.generateLabExamReport(labExamId);
    }

}
