package com.medisoft.report;

import lombok.Builder;
import lombok.Getter;

import java.math.BigInteger;

@Getter
@Builder
public class Paragraph {

    private String text;
    private BigInteger fontSize;
    private String color;

    private boolean centered;
    private boolean bold;

    public static class ParagraphBuilder {

        public ParagraphBuilder bold() {
            bold = true;
            return this;
        }

        public ParagraphBuilder centered() {
            centered = true;
            return this;
        }
    }
}
