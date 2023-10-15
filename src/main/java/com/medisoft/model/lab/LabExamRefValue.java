package com.medisoft.model.lab;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LabExamRefValue {

    private int id;

    private String sex;
    private int ageLow;
    private int ageHigh;

    private double low; // value < low
    private double normal; // value > low && value < normal
                            // value > normal && value < critical = high
    private Double critical; // value > critical
}
