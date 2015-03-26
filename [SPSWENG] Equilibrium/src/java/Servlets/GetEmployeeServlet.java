/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.Database;
import Database.EmailNotifier;
import Helper.PasswordGenerator;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        String type = (String) request.getParameter("type");
        int entryNum = Integer.parseInt(request.getParameter("entry").trim());

        String password = PasswordGenerator.getInstance().getPassword();
        Database db = Database.getInstance();
        
        db.changePassword(entryNum, password);
        db.changeEmployeeType(entryNum, type);
        String fname =db.getFirstName(entryNum);
        String lname =db.getLastName(entryNum);

        String email = db.getEmailAddress(entryNum);
        if (EmailNotifier.getInstance().sendEmail(email, "Welcome to Equilibrium, "+fname+" "+lname+".\n"
                + "An account has been created by the Human Resources department, for you.\nYour password is " + password
                +"\nThank you!", "[Password]")) {
            request.setAttribute("response", new String("Password is sent to " + email));

        } else {
            request.setAttribute("response", new String("Failed to send password to " + email));
        }

        RequestDispatcher view = request.getRequestDispatcher("UserAccountCreated.jsp");
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
