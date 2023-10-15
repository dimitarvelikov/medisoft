package com.medisoft.model;

import com.medisoft.model.lab.LabExam;
import com.medisoft.model.lab.LabExamRefValue;
import com.medisoft.model.lab.LabExamRefValueType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LabExamTest {
    private static final List<LabExamRefValue> SINGLE_REF_VALUE = List.of(
            LabExamRefValue.builder().low(2).normal(5).critical(10d).build()
    );

    private static final List<LabExamRefValue> REF_VALUES = List.of(
            LabExamRefValue.builder().sex("F").ageLow(6).ageHigh(17).low(1).normal(3).critical(6d).build(),
            LabExamRefValue.builder().sex("F").ageLow(18).ageHigh(25).low(2).normal(5).critical(10d).build(),
            LabExamRefValue.builder().sex("M").ageLow(6).ageHigh(17).low(1).normal(5).critical(7d).build(),
            LabExamRefValue.builder().sex("M").ageLow(18).ageHigh(25).low(3).normal(6).critical(15d).build()
    );

    @Test
    void testLabExamLow() {
        LabExam exam = LabExam.builder().refValues(SINGLE_REF_VALUE).value(1.0).build();
        Assertions.assertEquals(exam.getRefValueType("x", 32132), LabExamRefValueType.LOW);
    }

    @Test
    void testLabExamNormal() {
        LabExam exam = LabExam.builder().refValues(SINGLE_REF_VALUE).value(2.1).build();
        Assertions.assertEquals(exam.getRefValueType("x", 32132), LabExamRefValueType.NORMAL);
    }

    @Test
    void testLabExamHigh() {
        LabExam exam = LabExam.builder().refValues(SINGLE_REF_VALUE).value(5.1).build();
        Assertions.assertEquals(exam.getRefValueType("x", 32132), LabExamRefValueType.HIGH);
    }

    @Test
    void testLabExamCritical() {
        LabExam exam = LabExam.builder().refValues(SINGLE_REF_VALUE).value(25).build();
        Assertions.assertEquals(exam.getRefValueType("x", 32132), LabExamRefValueType.CRITICAL);
    }

    @Test
    void testExtractLabExamRefM() {
        LabExam exam = LabExam.builder().refValues(REF_VALUES).value(3.153).build();
        Assertions.assertEquals(exam.getRefValueType("M", 20), LabExamRefValueType.NORMAL);
    }

    @Test
    void testExtractLabExamRefC() {
        LabExam exam = LabExam.builder().refValues(REF_VALUES).value(0.3).build();
        Assertions.assertEquals(exam.getRefValueType("M", 7), LabExamRefValueType.LOW);
    }

    @Test
    void testExtractLabExamRefF() {
        LabExam exam = LabExam.builder().refValues(REF_VALUES).value(6.3).build();
        Assertions.assertEquals(exam.getRefValueType("F", 15), LabExamRefValueType.CRITICAL);
    }
}
