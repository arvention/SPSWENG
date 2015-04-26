/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import ClassHelpers.SearchResult;
import Models.modelEmployee;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SearchEmployee extends HttpServlet {

    /*
    
    Classname:   SearchEmployee
    Developer:   Jet Virtusio
    Description: Gets a keyword and searches it in the database. Prepares the displayed information for the employee
    */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        String search = request.getParameter("searchbox");
        search= search.trim();
        
        System.out.println("Search String is "+ search);
        
        SearchResult SR = new SearchResult(Database.Database.getInstance().getSearchResult(search));
         HttpSession session = request.getSession();
         session.setAttribute("searchresult", SR);
         
         response.sendRedirect("searchresult.jsp");
         System.out.println("IN SEARCH SERVLET: "+ search);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

}
