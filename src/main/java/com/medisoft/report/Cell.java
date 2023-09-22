package com.medisoft.report;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class Cell {

    private String text;
    private String bgColor;
    private String color;
    private boolean centered;
    private boolean bold;

    public static class CellBuilder {
        public CellBuilder centered() {
            centered = true;
            return this;
        }

        public CellBuilder bold() {
            bold = true;
            return this;
        }
    }
}
