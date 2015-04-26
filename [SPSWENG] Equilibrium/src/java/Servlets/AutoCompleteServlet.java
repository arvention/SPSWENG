
/*  Class Name:     AutoCompleteServlet
*   Developer:      Jet Virtusio
*   Description:    Auto Completes
*/ 

package Servlets;

import Database.Database;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutoCompleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String keyword = request.getParameter("keyword");
        String suggestions = Database.getInstance().getSuggestions(keyword);
        response.setContentType("text/plain");  
        response.setCharacterEncoding("UTF-8"); 
        response.getWriter().write(suggestions); 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
