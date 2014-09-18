package com.vteba.user.servlet;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vteba.utils.date.DateUtils;
import com.vteba.web.servlet.AutowiredHttpServlet;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 下载servlet
 * @author yinlei 
 * @since 2014-8-20
 */
public class DownloadServlet extends AutowiredHttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void servlet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //String htmlFile = "d:/dd.html";

        //String fileName = "好wo的.pdf";
        String fileName = "好wo的.doc";
        
        response.setContentType("application/x-download;charset=utf-8");
//        response.setContentType("application/x-msdownload;charset=utf-8");//设置响应头
        //response.setHeader("Content-Disposition", "inline;filename =" + fileName);
        response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1"));
        
        OutputStream outputStream = response.getOutputStream();
//        Demo4HTMLFile2PDF.parseHTML2PDFElement(outputStream, new FileInputStream(htmlFile));
        
        Company company = new Company();
        company.setCompanyName("保险");
        company.setNumber(222L);
        
        List<Company> fuList = new ArrayList<Company>();
        
        Company company2 = new Company();
        company2.setDatetime(DateUtils.toDateString("yyyy-MM-dd HH:mm"));
        company2.setReprint(22L);
        company2.setSource("任命日报");
        company2.setSummary("好家伙打发阿斯顿");
        company2.setSourceFile("http://www.baidu.com");
        company2.setTitle("这个是标题");
        fuList.add(company2);
        
        company.setFuList(fuList);
        
        List<Company> list = new ArrayList<Company>();
        list.add(company);
        
        Configuration configuration = new Configuration();
        configuration.setEncoding(Locale.CHINA, "UTF-8");
        configuration.setDefaultEncoding("UTF-8");
//        FileReader reader = new FileReader("C:\\Users\\Administrator\\git\\test\\test\\src\\main\\resources\\w4.xml");
        FileReader reader = new FileReader("d:\\template\\w6.xml");
        
        Template template = new Template("WordTemplate", reader, configuration);
        
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("companyList", list);
        root.put("all", company);
        root.put("fu", company2);
        
        Writer writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
        
        try {
            //FreeMarkerTemplateUtils.processTemplateIntoString(template, root);
            template.process(root, writer);
        } catch (TemplateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
//        String docFile = "d:/sse.docx";
//        
//        FileInputStream fis = new FileInputStream(docFile);
//        
//        IOUtils.copy(fis, outputStream);
        
        response.flushBuffer();
        outputStream.close();
    }

}
