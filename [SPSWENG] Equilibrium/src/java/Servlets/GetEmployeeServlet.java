/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Database.Database;
import Database.EmailNotifier;
import Helper.PasswordGenerator;
import Queries.CreateAccountQuery;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Thursday
 */
public class GetEmployeeServlet extends HttpServlet {

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
            out.println("<title>Servlet saveAccount</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet saveAccount at " + request.getContextPath() + "</h1>");
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
        
        
        String type =(String) request.getParameter("type");
        int entrynum = Integer.parseInt(request.getParameter("entry").trim());
        HttpSession session= request.getSession();
        session.setAttribute("entrynum", entrynum);
        session.setAttribute("type",type);
        
       String pas = PasswordGenerator.getInstance().getPassword();
       
        
        CreateAccountQuery CA = new CreateAccountQuery();
        CA.savePassword(entrynum, pas, type);
        CA.saveType(entrynum, type);
        
       String email = Database.getInstance().getEmailAddress(entrynum);
       if( EmailNotifier.getInstance().sendEmail(email ,"Good day! \n Your password is "+ pas , "Password")){
           request.setAttribute("response",new String("Password sent to "+ email));
           
       }else request.setAttribute("response", new String("Failed to send password to "+ email));
        
        RequestDispatcher view = request.getRequestDispatcher("CreateAccount/useraccountcreated.jsp");
        view.forward(request, response);
        
        
        
 
       // response.sendRedirect("CreateAccount/useraccountcreated.jsp");
        
        
        
       // response.sendRedirect("CreateAccount/inputpass.html");
        
        
        
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
