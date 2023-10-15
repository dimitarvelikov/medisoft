package com.medisoft.model.lab;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class LabTest {
    private int id;
    private LocalDateTime requestedAt;
    private LocalDateTime examinedAt;
    private LocalDateTime createdAt;
}
