package com.mreapps.kvissnet.backend.server.servlet;

import com.mreapps.kvissnet.backend.api.QuizProtoBufApi;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuizProviderServlet extends HttpServlet
{
    private static final long serialVersionUID = 7437566378687620280L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        QuizProtoBufApi.PBCategory.Builder categoryBuilder = QuizProtoBufApi.PBCategory.newBuilder();
        categoryBuilder.setName("test");
        QuizProtoBufApi.PBCategory pbCategory = categoryBuilder.build();

        resp.setContentType("text/plain");
        resp.getWriter().println("Hello, world");
    }
}
