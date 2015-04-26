/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Database.Database;
import Models.modelEmployee;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Thursday
 */

/*  Class Name:     SaveMemo.java
*   Developer:      Jet Virtusio
*   Description:    Saves Award in database
*/  


@MultipartConfig(maxFileSize = 16177215)  
public class SaveAward extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SaveAward</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SaveAward at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        
  
        
        HttpSession session = request.getSession();
        modelEmployee employee = (modelEmployee) session.getAttribute("selectedemployee");
        
        if(employee == null){
            System.out.println("WHYY");
        }
        
        Part filePart = request.getPart("filename");
        int intid = employee.getEntryNum();
        String memo = request.getParameter("memoNote");
        InputStream inputStream = null;
        String dates = request.getParameter("awardreceive");
        String awardname = request.getParameter("awardname");
        
        System.out.println("date is "+dates);
        
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = null;
 
	try {
 
		date = formatter.parse(dates);
		System.out.println(date);
		System.out.println(formatter.format(date));
 
	} catch (ParseException e) {
		e.printStackTrace();
	}
        
         java.sql.Date sql = new java.sql.Date(date.getTime());
         
         
         if (awardname.length() >= 42) {
            System.out.println("Oh no too much characters");
            request.setAttribute("message", "Character Limit Reached for Award Name");
            RequestDispatcher view = request.getRequestDispatcher("addAward.jsp");
            view.forward(request, response);
        }
        
        
        if (memo.length() >= 2500) {
            System.out.println("Oh no too much characters");
            
        
            request.setAttribute("message", "Character Limit Reached");
            RequestDispatcher view = request.getRequestDispatcher("addAward.jsp");
            view.forward(request, response);
        }
        if( filePart.getSize() != 0){
            
            System.out.println("File Size is "+ filePart.getSize());
            if(filePart.getSize() >  10847412){
                request.setAttribute("message", "File Size Limit Reached");
                RequestDispatcher view = request.getRequestDispatcher("addAward.jsp");
                view.forward(request, response);
            }
            
            
        }
        
        
           Database db = Database.getInstance();
           if(filePart.getSize()!=0){
             
             inputStream = filePart.getInputStream();
             System.out.println("I am over gereee");  
             String nameoffile =  filePart.getSubmittedFileName();
           //  db.saveDisciplinary(intid, memo,typeofmemo,inputStream,nameoffile );  
             db.saveAward(intid, sql,awardname , memo, inputStream, nameoffile);
            
           }
           else{
            db.saveAward(intid, sql, awardname , memo,null,null);

           }
         //till here
         
            request.setAttribute("message","Success!");
            RequestDispatcher view = request.getRequestDispatcher("FileAwardSuccess.jsp");
            view.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
