package com.vteba.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vteba.utils.common.RandomNumber;
import com.vteba.web.servlet.AutowiredHttpServlet;

public class ImageServlet extends AutowiredHttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void servlet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RandomNumber randomNumber = RandomNumber.get();
        response.getOutputStream().write(randomNumber.getImageByteArray());
        request.getRequestDispatcher("/index.jsp");
    }

}
