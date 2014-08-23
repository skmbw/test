package com.vteba.test;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**
 * 测试xml worker 页面包含中文字符的转换
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class TestPdf2 {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        String pdfFile = "d:/htmlcn.pdf";
        String htmlFile = "d:/aa.html";

        Document document = new Document();
        PdfWriter pdfwriter = PdfWriter.getInstance(document,
                new FileOutputStream(pdfFile));
        pdfwriter.setViewerPreferences(PdfWriter.HideToolbar);
        document.open();

     // 定义字体,可以正常显示中文
        BaseFont bfComic = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font font = new Font(bfComic, 12, Font.NORMAL);
        
        
        // html文件
        InputStreamReader isr = new InputStreamReader(new FileInputStream(
                htmlFile), "UTF-8");
        XMLWorkerHelper.getInstance().parseXHtml(pdfwriter, document, isr);
        document.close();

    }

}
