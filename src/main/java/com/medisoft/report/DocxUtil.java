package com.medisoft.report;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.docx4j.Docx4J;
import org.docx4j.jaxb.Context;
import org.docx4j.model.table.TblFactory;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.Br;
import org.docx4j.wml.CTVerticalJc;
import org.docx4j.wml.Color;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.HpsMeasure;
import org.docx4j.wml.Jc;
import org.docx4j.wml.JcEnumeration;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import org.docx4j.wml.R;
import org.docx4j.wml.STBrType;
import org.docx4j.wml.STVerticalJc;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.Tc;
import org.docx4j.wml.Text;
import org.docx4j.wml.Tr;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;

public class DocxUtil {

    private static final ObjectFactory DOCX_FACTORY = Context.getWmlObjectFactory();

    public static P createPageBreak() {
        Br br = DOCX_FACTORY.createBr();
        br.setType(STBrType.PAGE);
        R r = DOCX_FACTORY.createR();
        r.getContent().add(br);
        P p = DOCX_FACTORY.createP();
        p.getContent().add(r);

        return p;
    }

    public static P parseParagraph(Paragraph paragraph) {
        R run = DOCX_FACTORY.createR();
        run.setRPr(DOCX_FACTORY.createRPr());

        if (paragraph.getFontSize() != null) {
            HpsMeasure size = new HpsMeasure();
            size.setVal(paragraph.getFontSize());
            run.getRPr().setSz(size);
        }

        if (paragraph.isBold()) {
            run.getRPr().setB(DOCX_FACTORY.createBooleanDefaultTrue());
        }

        if (paragraph.getColor() != null) {
            Color color = DOCX_FACTORY.createColor();
            color.setVal(paragraph.getColor());
            run.getRPr().setColor(color);
        }

        Text text = createText(paragraph.getText());
        run.getContent().add(text);

        P p = DOCX_FACTORY.createP();
        p.setPPr(DOCX_FACTORY.createPPr());

        if (paragraph.isCentered()) {
            Jc justification = DOCX_FACTORY.createJc();
            justification.setVal(JcEnumeration.CENTER);
            p.getPPr().setJc(justification);
        }

        p.getContent().add(run);

        return p;
    }

    private static Text createText(String text) {
        Text t = DOCX_FACTORY.createText();
        t.setValue(text);
        return t;
    }

    private static void populateTableCell(Tbl table, int row, int col, Cell cell) {
        Tr tr = (Tr) table.getContent().get(row);
        Tc tc = (Tc) tr.getContent().get(col);
        tc.getContent().clear();
        //tc.getContent().add();

        if (StringUtils.isNotEmpty(cell.getBgColor())) {
            if (tc.getTcPr().getShd() == null) {
                tc.getTcPr().setShd(DOCX_FACTORY.createCTShd());
            }
            tc.getTcPr().getShd().setFill(cell.getBgColor());
            tc.getTcPr().getShd().setColor("FFFFFF");
        }

        CTVerticalJc ctVerticalJc = DOCX_FACTORY.createCTVerticalJc();
        ctVerticalJc.setVal(STVerticalJc.CENTER);
        tc.getTcPr().setVAlign(ctVerticalJc);
    }

    public static ByteArrayOutputStream convertDocxToStream(WordprocessingMLPackage template) throws Docx4JException {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        Docx4J.save(template, outStream, Docx4J.FLAG_NONE);
        return outStream;
    }

    public static void insertItemAt(ContentAccessor body, Object item, MutableInt index) {
        body.getContent().add(index.getAndIncrement(), item);
    }

    public static Tbl createAndPopulateTable(List<List<Cell>> data) {
        Tbl table = TblFactory.createTable(data.size(), data.get(0).size(), 11000);

        for (int row = 0; row < data.size(); ++row) {
            List<Cell> rowData = data.get(row);
            for (int col = 0; col < rowData.size(); ++col) {
                Cell cellData = rowData.get(col);
                populateTableCell(table, row, col, cellData);
            }
        }

        return table;
    }

    public static void saveToFile(WordprocessingMLPackage template, String fileName) {
        try {
            Docx4J.save(template, new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
