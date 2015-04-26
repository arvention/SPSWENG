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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

    /*    
    Classname:   SaveProfilePic
    Developer:   Jet Virtusio
    Description: Saves Picture in datavase
    */



@MultipartConfig(maxFileSize = 16177215)  
public class SaveProfilePic extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
    
        Part filePart = request.getPart("filename");
        
        System.out.println("Heree");
        
        String id = request.getParameter("id");
         int intid = Integer.parseInt(id.trim());
         InputStream inputStream = filePart.getInputStream();
        String name = filePart.getSubmittedFileName();
        
        String reply="0"; 
        
        try{
      if(filePart.getSize() !=0 ){
      Database.getInstance().savePic(intid,inputStream, filePart.getSubmittedFileName());
      
      }else reply ="2";

        }catch(Exception e){
            reply = "1";
            System.out.println(e);
        }
      
      response.setContentType("text/plain");  
      response.setCharacterEncoding("UTF-8"); 
      response.getWriter().write(reply); 
      
    // response.sendRedirect("ViewEmployeeRecords.jsp");
        
   
    }


}
