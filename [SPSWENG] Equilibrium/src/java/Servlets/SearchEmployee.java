
/*  Class Name:     SearchEmployee
*   Developer:      Jet Virtusio
*   Description:    Gets a keyword and searches it in the database. Prepares the displayed information for the employee
*/  

package Servlets;

import ClassHelpers.SearchResult;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchEmployee extends HttpServlet {

    /*
    *   The doGet function of the servlet.
    */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String search = request.getParameter("searchbox");
        search = search.trim();

        System.out.println("Search String is " + search);

        SearchResult SR = new SearchResult(Database.Database.getInstance().getSearchResult(search));
        HttpSession session = request.getSession();
        session.setAttribute("searchresult", SR);

        response.sendRedirect("searchresult.jsp");
        System.out.println("IN SEARCH SERVLET: " + search);
    }

    /*
    *   The doPost function of the servlet.
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
