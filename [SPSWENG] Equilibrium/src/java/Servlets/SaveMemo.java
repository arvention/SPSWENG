/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Bean.EmployeeBean;
import Database.EmailNotifier;
import Queries.SaveMemoQuery;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thursday
 */
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
        
         String id = request.getParameter("listEmployees");
         int intid = Integer.parseInt(id.trim());
         String memo= request.getParameter("memoNote");
         HttpSession session = request.getSession();
         if(memo.length() >= 2500){
             System.out.println("Oh no too much characters");
               //request.setAttribute("errors", "Too much characters");
            
               session.setAttribute("error", new String("* Invalid Input: Max characters reached."));
               response.sendRedirect("FileMemo.jsp");
           
          //  RequestDispatcher view = request.getRequestDispatcher("FileMemo/memo.jsp");
          //  view.forward(request, response);
         }
         
         else{
         SaveMemoQuery SM = new SaveMemoQuery();
         SM.SaveDisciplinary(intid, memo);
         String to = SM.getEmail(intid);
         System.out.println("HEREEEE SENDING EMAIL TO: "+ to);
         
         String fname =SM.getfname(intid);
         String lname = SM.getlname(intid);
         session.removeAttribute("error");
         EmailNotifier email = EmailNotifier.getInstance();
         System.out.println("HEREEEE SENDING EMAIL TO: "+ to);
         
        
         
         
         if( email.sendEmail(to,"Greetings, "+fname+" "+lname+"\nPlease be informed that you have received a memo from your superior. \n\n"
                 + "According to the memo : \n\n" + memo, 
                 "[Disciplinary Memo] You received a disciplinary memo")){
            request.setAttribute("response", new String("Notification Email sent to "+ to)); 
             
         }else request.setAttribute("response", new String("Failed to send Notification Email to "+ to)); 
         //response.sendRedirect("FileMemo/MemoFiled.jsp");
        
        
        RequestDispatcher view = request.getRequestDispatcher("FileMemoSuccess.jsp");
        view.forward(request, response);
        
         
         }
         
         
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
