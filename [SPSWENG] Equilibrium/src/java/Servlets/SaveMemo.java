/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Servlets;

import Database.Database;
import ClassHelpers.EmailNotifier;
import Models.modelEmployee;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
@MultipartConfig(maxFileSize = 16177215)  
public class SaveMemo extends HttpServlet {

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
            out.println("<title>Servlet SaveMemo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SaveMemo at " + request.getContextPath() + "</h1>");
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
        
        
        String typeofmemo = request.getParameter("listTypeMemo");
        int intid = employee.getEntryNum();
        String memo = request.getParameter("memoNote");
         InputStream inputStream = null;
        
        if (memo.length() >= 2500) {
            System.out.println("Oh no too much characters");
            session.setAttribute("error", new String("* Invalid Input: Max characters reached."));
            response.sendRedirect("FileMemo.jsp");
        }
        if(filePart.getSize() != 0){
            
            System.out.println("File Size is "+ filePart.getSize());
            if(filePart.getSize() >  10847412){
                session.setAttribute("error", new String("* Maximum File Size Reached."));
                response.sendRedirect("FileMemo.jsp");
            }
            
            
        }
        
        
           Database db = Database.getInstance();
           if(filePart.getSize() != 0){
             
             inputStream = filePart.getInputStream();
             System.out.println("I am over gereee");  
             String nameoffile =  filePart.getSubmittedFileName();
             db.saveDisciplinary(intid, memo,typeofmemo,inputStream,nameoffile );  
           }
           else{
               db.saveDisciplinary(intid, memo,typeofmemo,null,null);    
               
           }
         //till here
            session.removeAttribute("error");
            RequestDispatcher view = request.getRequestDispatcher("FileMemoSuccess.jsp");
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

    }

}
