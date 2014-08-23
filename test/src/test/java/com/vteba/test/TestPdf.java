package com.vteba.test;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class TestPdf {
    public static void main(String[] args) {
        Document document = null;
        try {
            document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("c:/12.pdf"));
            document.open();
         // 定义字体,可以正常显示中文
            BaseFont bfComic = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            
            
            
            Font font = new Font(bfComic, 12, Font.NORMAL);
            document.add(new Paragraph("wo我1", font));
            Element element;
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (document != null) {
                document.close();
            }
        }
    } 
}
