/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Database.Database;
import Models.modelEmployee;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Arces
 */
public class SaveReport extends HttpServlet {

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
            out.println("<title>Servlet SaveReport</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SaveReport at " + request.getContextPath() + "</h1>");
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
        
        Database db = Database.getInstance();
        int month = parseInt(request.getParameter("m").trim());
        int year = parseInt(request.getParameter("y").trim());
        HttpSession session = request.getSession();
        modelEmployee m = (modelEmployee) session.getAttribute("employee");
        
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + month + "" + year + "LeaveReport.csv\"");
        try {
            OutputStream outStream = response.getOutputStream();
            String reportHeader = "Employee Name, Vacation, Emergency, Paternity, Total Leaves Taken, Vacation, Emergency, Paternity, Total Leaves Left\n";
            outStream.write(reportHeader.getBytes());
            outStream.flush();
            
            //content
            String reportContent = db.getDownloadReport(month, year, m.getEmployeeID());
            outStream.write(reportContent.getBytes());
            outStream.flush();
            
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        processRequest(request, response);
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
