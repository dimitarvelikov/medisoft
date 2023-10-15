package com.medisoft.model.lab;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LabExam {
    private long id;
    private String name;
    private double value;
    private LabExamRefType refType;
    private List<LabExamRefValue> refValues;

    public LabExamRefValueType getRefValueType(String sex, int age) {

        LabExamRefValue rv = getRefValue(sex, age);

        if (value < rv.getLow()) {
            return LabExamRefValueType.LOW;
        }

        if (value < rv.getNormal()) {
            return LabExamRefValueType.NORMAL;
        }


        if (value > rv.getNormal() && (rv.getCritical() == null || value < rv.getCritical())) {
            return LabExamRefValueType.HIGH;
        }

        if (value > rv.getCritical()) {
            return LabExamRefValueType.CRITICAL;
        }

        return LabExamRefValueType.UNKNOWN;
    }

    private LabExamRefValue getRefValue(String sex, int age) {

        if (refValues.size() == 1) {
            return refValues.get(0);
        }

        return refValues.stream()
                .filter(val -> val.getSex().equals(sex))
                .filter(val -> age > val.getAgeLow() && age < val.getAgeHigh())
                .findFirst()
                .orElseThrow();
    }

}
