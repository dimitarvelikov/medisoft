package com.medisoft.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Statistics {

    private int newPatientsToday;
    private int newPatientsThisWeek;
    private int newPatientsLast30d;
    private int newPatientsBeginningOfMonth;


}
