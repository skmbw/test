package com.vteba.table.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vteba.web.servlet.AutowiredHttpServlet;

/**
 * 维护分区表的servlet
 * @author yinlei
 * @since 2013-12-22
 */
@WebServlet(name = "tableServlet", urlPatterns = { "/table" }, loadOnStartup = 2)
public class TableServlet extends AutowiredHttpServlet {

	private static final long serialVersionUID = 1L;
	
//	@Inject
//	private ShardsTableDao shardsTableDaoImpl;
//	
//	private TableDetailDao tableDetailDaoImpl;

	@Override
	public void servlet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String type = request.getParameter("type");
		if (type != null && type.equals("save")) {
			
		}
		
	}

}
