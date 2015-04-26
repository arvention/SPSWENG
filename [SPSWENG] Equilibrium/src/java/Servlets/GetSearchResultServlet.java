
/*   Class Name:     GetSearchResultServlet
 *   Developer:      Arren Antioquia
 *   Description:    servlet used to generate search result
 */
package Servlets;

import Database.Database;
import Models.modelEmployee;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetSearchResultServlet extends HttpServlet {

    /*
     *   The doGet function of the servlet.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /*
     *   The doPost function of the servlet.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String search = request.getParameter("search");
        Database db = Database.getInstance();

        ArrayList<modelEmployee> modelEmployees = db.getSearchResult(search);
        HttpSession session = request.getSession();
        session.setAttribute("searchResult", modelEmployees);
        response.sendRedirect("SearchEmp.jsp");
    }
}
