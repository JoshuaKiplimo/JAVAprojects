package com.api.servlets;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import resources.GetData;

/**
 * the central point from which we run our app
 *
 */
@WebServlet("/jobsdata")
public class App extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setContentType("application/json;");
        //Get incoming info about user job
        response.getWriter().println(GetData.scraper());
    }
}
