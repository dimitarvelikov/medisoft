package com.medisoft.web;

import com.medisoft.model.Statistics;
import com.medisoft.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stats")
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping
    public Statistics stats() {
        return statisticsService.getStats();
    }

}
