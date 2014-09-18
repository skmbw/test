package com.vteba.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class PdfGenerator {
    /**
     * 通过PDF模板生成PDF
     * @param tempFilePath
     * @param targetFilePath
     * @param fieldValueMap
     * @return
     */
    public boolean generatePdfByTemplate(String tempFilePath,String targetFilePath, Map<String, String> fieldValueMap) {
        boolean isNewTargetFile = true;
        try {
            File tempFile = new File(tempFilePath);
            if (!tempFile.exists()) {
                throw new FileNotFoundException(tempFilePath + " 不存在...");
            }
            // 删除已有文件
            File targetFile = new File(targetFilePath);
            if (targetFile.exists()) {
                targetFile.delete();
            }
            PdfReader reader = new PdfReader(tempFilePath);// 模版文件目录
            PdfStamper ps = new PdfStamper(reader, new FileOutputStream(targetFilePath)); // 生成的输出流
            AcroFields s = ps.getAcroFields();// 获取pdf模板中所有的文本域

            BaseFont bfChinese = BaseFont.createFont("STSong-Light",
                    "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            for (Object key : fieldValueMap.keySet()) {
                s.setFieldProperty(key.toString(), "textfont", bfChinese, null);// 设置中文字符集
                s.setField(key.toString(), fieldValueMap.get(key));
            }
            ps.setFormFlattening(true);// 这句不能少
            ps.close();
            reader.close();
        } catch (FileNotFoundException e) {
            isNewTargetFile = false;
            e.printStackTrace();
        } catch (IOException e) {
            isNewTargetFile = false;
            e.printStackTrace();
        } catch (DocumentException e) {
            isNewTargetFile = false;
            e.printStackTrace();
        }finally{
        }
        return isNewTargetFile;
    }
    /**
     * 通过File对象生成PDF
     * @param targetFilePath
     * @param htmlFile
     * @return
     */
    public boolean generatePdfByHtml(String targetFilePath, File htmlFile) {
        boolean isSuccsee = false;
        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(htmlFile), "utf-8"));
            String data = null;
            StringBuffer b = new StringBuffer();
            while ((data = br.readLine()) != null) {
                b.append(data);
            }
            br.close();
            isSuccsee = generatePdfByHtml(targetFilePath, b.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  
        return isSuccsee;
    }
    /**
     * 通过HTML字符串生成PDF
     * @param targetFilePath
     * @param htmlStr
     * @return
     */
    public boolean generatePdfByHtml(String targetFilePath, String htmlStr) {
        boolean isSuccsee = false;
        isSuccsee = generatePdfByHtml(null,null,targetFilePath, htmlStr, false);
        return isSuccsee;
    }

    @SuppressWarnings("static-access")
    public boolean generatePdfByHtml(Document doc,Font fontChinese,String targetFilePath, String htmlStr,boolean isSetVersion) {
        boolean isSuccsee = false;
        OutputStream os;
        try {
            os = new FileOutputStream(targetFilePath);
            if(null==doc){
                doc = new Document();
            }
            if(null==fontChinese){
                //中文字符设置
                BaseFont baseFontChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
                fontChinese = new Font(baseFontChinese, 12, Font.NORMAL);
            }
            //创建监听器
            PdfWriter writer = PdfWriter.getInstance(doc, os);
            if (isSetVersion) {
                //加权限 
                writer.setPdfVersion(writer.PDF_VERSION_1_7);
                int perssion = writer.ALLOW_PRINTING | writer.HideMenubar
                        | writer.HideToolbar | writer.HideWindowUI | writer.ALLOW_FILL_IN;
                writer.setEncryption(null, null, perssion,writer.STANDARD_ENCRYPTION_40);
            }
            Paragraph context = new Paragraph();
            //context.add(htmlStr);
            
            FileInputStream fis = new FileInputStream("d:/bb.xml");
            
            doc.setPageCount(1);
            
            XMLWorkerHelper.getInstance().parseXHtml(writer, doc, fis);
            
            
            
            
//            StyleSheet ss = new StyleSheet();
//            List htmlList = HTMLWorker.parseToList(new StringReader(htmlStr),ss);
//            for (int i = 0; i < htmlList.size(); i++) {
//                Element e = (Element) htmlList.get(i);
//                // 为表格里面的内容设字体
//                if (htmlList.get(i) instanceof PdfPTable) {
//                    PdfPTable pt = (PdfPTable) htmlList.get(i);
//                    for (int j = 0; j < pt.getRows().size(); j++) {
//                        for (PdfPCell item : pt.getRow(j).getCells()) {
//                            if (item != null) {
//                                item.getCompositeElements();
//                                for (Element el : item.getCompositeElements()) {
//                                    for (Chunk ck : el.getChunks()) {
//                                        ck.setFont(fontChinese);
//                                    }
//                                }
//                            }
//                        }
//                    }
//                } else {
//                    context.setFont(fontChinese);
//                }
//                for (Chunk ck : e.getChunks()) {
//                    ck.setFont(fontChinese);
//                }
//                context.add(e);
//            }
            doc.open();
            doc.add(context);
            doc.close();
            isSuccsee = true;
        } catch (DocumentException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return isSuccsee;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        //String tempFilePath = "d:/FirstPdf0.pdf";
        String targetFilePath = "d:/FirstPdf1.pdf";
        Map<String, String> filedValueMap = new HashMap<String, String>();
        filedValueMap.put("t0", "this is t0    好好");
        filedValueMap.put("Text1", "this is t1   测试");
        filedValueMap.put("t2", "this is t2    成功");
        long begTime = System.currentTimeMillis();
        boolean isSucc = new PdfGenerator().generatePdfByHtml(targetFilePath,new File("d:/aa.html"));
        System.out.println("run time:"+(System.currentTimeMillis()-begTime));
        System.out.println(isSucc);
    }

}

