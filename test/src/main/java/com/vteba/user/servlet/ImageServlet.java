package com.vteba.user.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;

import com.vteba.utils.common.RandomNumber;
import com.vteba.web.servlet.AutowiredHttpServlet;

@Named
public class ImageServlet extends AutowiredHttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Inject
    private SolrTemplate solrTemplate;
    
    @Override
    public void servlet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        SolrInputDocument solrInputDocument = new SolrInputDocument();
        solrInputDocument.addField("id", "ids");
        solrInputDocument.addField("name", "solrs");
        //solrInputDocument.addField("solr", "这个扯淡");
        solrTemplate.saveDocument(solrInputDocument);
        solrTemplate.commit();
        try {
            solrTemplate.getSolrServer().optimize();
        } catch (SolrServerException e) {
            
        }
        Query query = new SimpleQuery("*:*");
        Bean bean = solrTemplate.queryForObject(query, Bean.class);
        System.out.println(bean);
        
        
        RandomNumber randomNumber = RandomNumber.get();
        response.getOutputStream().write(randomNumber.getImageByteArray());
        request.getRequestDispatcher("/index.jsp");
        
        
    }

}
