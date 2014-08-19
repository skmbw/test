package com.vteba.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 生成PDF文件
 * 
 * @author 于学明
 */
public class CreatePdf {

    /**
     * 获得PDF文件所需图片
     * 
     * @param imagePath
     *            //图片文件路径
     * @return
     * @throws BadElementException
     * @throws MalformedURLException
     * @throws IOException
     */
    public Image getImageFile(String imagePath) throws BadElementException, MalformedURLException, IOException {
        Image jpg = Image.getInstance(imagePath);
        // 设置图片居中
        jpg.setAlignment(Image.MIDDLE);
        return jpg;
    }

    /**
     * 获得文字内容
     * 
     * @param inputFilePath
     *            原DOC文件路径
     * @param outputFilePath
     *            生成HTML文件路径
     * @return
     */
    public String getPdfContext(String inputFilePath, String outputFilePath) {
        // 读取DOC文件内容
        String htmlText = new FileExtracter().extractDoc(inputFilePath, outputFilePath);
        // 把读取的HTML文件,生成一个字符串
        String pdf = new FileExtracter().getContext(htmlText);

        return pdf;
    }

    /**
     * 用ITEXT生成指定PDF格式文件
     * 
     * @param imagePath0
     * @param inputFilePath
     * @param outputFilePath
     * @param imagePath1
     * @param outputPdf
     * @return
     * @throws DocumentException
     * @throws IOException
     */
    public String createPDF(String imagePath0, String inputFilePath, String outputFilePath, String imagePath1,
                            String outputPdf) throws DocumentException, IOException {

        // 返回的pdf全路径
        String returnPdf = "";
        File dir = new File("out_pdf");
        // 若目录不存在则新建该目录
        if (!dir.exists()) {
            dir.mkdir();
        }

        // 新建空白文件
        File outPdfPath = new File(dir + "/" + outputPdf);// 输出pdf文件的全路径
        try {
            outPdfPath.createNewFile();
        } catch (IOException e1) {
            e1.printStackTrace();
            returnPdf = null;
        }
        // 定义PDF文件大小和边距
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        // 生成PDF文件的路径
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outPdfPath));
        writer.setViewerPreferences(PdfWriter.PageModeFullScreen);
        document.open();
        // 文件头图片
        document.add(getImageFile(imagePath0));
        // 定义字体,可以正常显示中文
        BaseFont bfComic = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font font = new Font(bfComic, 12, Font.NORMAL);

        String pdf = getPdfContext(inputFilePath, outputFilePath);
        // String str=new String(pdf.getBytes("ISO-8859-1"),"GB2312");
        document.add(new Paragraph(pdf, font));
        // 文件尾图片
        document.add(getImageFile(imagePath1));
        document.close();
        returnPdf = outPdfPath.getAbsolutePath();
        return returnPdf;
    }

    /**
     * 用ITEXT生成指定PDF格式文件
     * 
     * @param imagePath
     * @param inputFilePath
     * @param outputFilePath
     * @param outputPdf
     * @return
     * @throws DocumentException
     * @throws IOException
     */
    public String createPDF(String imagePath, String inputFilePath, String outputFilePath, String outputPdf)
                                                                                                            throws DocumentException,
                                                                                                            IOException {

        // 返回的pdf全路径
        String returnPdf = "";
        File dir = new File("out_pdf");
        // 若目录不存在则新建该目录
        if (!dir.exists()) {
            dir.mkdir();
        }

        // 新建空白文件
        File outPdfPath = new File(dir + "/" + outputPdf);// 输出pdf文件的全路径
        try {
            outPdfPath.createNewFile();
        } catch (IOException e1) {
            e1.printStackTrace();
            returnPdf = null;
        }
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        // 生成PDF文件的路径
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outPdfPath));
        writer.setViewerPreferences(PdfWriter.PageModeFullScreen);
        document.open();
        document.add(getImageFile(imagePath));
        // 定义字体,可以正常显示中文
        BaseFont bfComic = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font font = new Font(bfComic, 12, Font.NORMAL);

        String pdf = getPdfContext(inputFilePath, outputFilePath);
        // String str=new String(pdf.getBytes("ISO-8859-1"),"GB2312");
        document.add(new Paragraph(pdf, font));
        document.close();
        returnPdf = outPdfPath.getAbsolutePath();
        return returnPdf;
    }

    public static void main(String[] args) {

        try {
            String s = new CreatePdf().createPDF("c:/a.gif", "c:/s.doc", "c:/x.html", "a.pdf");
            System.out.println(s);
        } catch (DocumentException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        }
    }
}
