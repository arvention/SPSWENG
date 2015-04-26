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
*   Description:    Saves Evaluation in database
*/  



@MultipartConfig(maxFileSize = 16177215)  
public class SaveEvaluation extends HttpServlet {

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
            out.println("<title>Servlet SaveEvaluation</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SaveEvaluation at " + request.getContextPath() + "</h1>");
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
                
        Part filePart = request.getPart("filename");
        int intid = employee.getEntryNum();
        String score = request.getParameter("score");
        InputStream inputStream = null;  
        String evalname="";
        evalname = request.getParameter("evalname");
         
        if (score.length() >= 10) { 
            request.setAttribute("message", "Character Limit Reached for score");
            RequestDispatcher view = request.getRequestDispatcher("addEvaluation.jsp");
            view.forward(request, response);
        }
            
        
        if (evalname.length() >= 2500) { 
            request.setAttribute("message", "Character Limit Reached");
            RequestDispatcher view = request.getRequestDispatcher("addEvaluation.jsp");
            view.forward(request, response);
        }
        if( filePart.getSize() != 0){
            System.out.println("File Size is "+ filePart.getSize());
            if(filePart.getSize() >  10847412){
                request.setAttribute("message", "File Size Limit Reached");
                RequestDispatcher view = request.getRequestDispatcher("addEvaluation.jsp");
                view.forward(request, response);
            }
        }
        
      
           Database db = Database.getInstance();
           if(filePart.getSize()!=0){
             
             inputStream = filePart.getInputStream();
             System.out.println("I am over gereee");  
             String nameoffile =  filePart.getSubmittedFileName();
           //  db.saveDisciplinary(intid, memo,typeofmemo,inputStream,nameoffile );  
            // db.saveAward(intid, sql,awardname , memo, inputStream, nameoffile);
            db.saveEval(intid, evalname, score, inputStream, nameoffile);
            System.out.println("Saving evalll");
            
           }
           else{
            db.saveEval(intid, evalname, score ,null,null);
               
           }
         //till here
            request.setAttribute("message","Success!");
            RequestDispatcher view = request.getRequestDispatcher("addEvaluation.jsp");
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
