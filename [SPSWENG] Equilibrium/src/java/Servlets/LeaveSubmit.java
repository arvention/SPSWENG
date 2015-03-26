/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.Database;
import Database.EmailNotifier;
import Models.modelEmployee;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Arces
 */
public class LeaveSubmit extends HttpServlet {
    private final int maxLeave = 15;   

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
            out.println("<title>Servlet LeaveSubmit</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LeaveSubmit at " + request.getContextPath() + "</h1>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        Database db = Database.getInstance();
        EmailNotifier en = EmailNotifier.getInstance();

        Date startDate = null;
        Date endDate = null;
        try {
            startDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startDate"));
            endDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("endDate"));

        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        HttpSession reqSession = request.getSession();
        RequestDispatcher reqDispatcher = null;
        ArrayList<Boolean> errorFlags = new ArrayList<>();
        //int empIDNum = Integer.parseInt(request.getParameter("idNum"));
        float dayCount = Float.parseFloat(request.getParameter("dayCount"));
        modelEmployee modelEmployee = (modelEmployee)reqSession.getAttribute("employee");
        
        System.out.println("start: " + startDate + " end: " + endDate + " | "+ getDateDiff(startDate, endDate) + " vs " + (int) Float.parseFloat(request.getParameter("dayCount")));
        System.out.println("TEST VS: " + (maxLeave - (db.getApprovedLeaveCount(modelEmployee.getEmployeeID()) + dayCount)));
        if (endDate != null && startDate != null) {
            if (endDate.before(startDate)) {
                errorFlags.add(true);
                errorFlags.add(false);
                errorFlags.add(false);                
                
                reqSession.setAttribute("errorFlags", errorFlags);
                reqDispatcher = request.getRequestDispatcher("LeaveForm.jsp");
            } else if (getDateDiff(startDate, endDate) != (int) Math.ceil(dayCount)) {
                errorFlags.add(false);
                errorFlags.add(true);
                errorFlags.add(false);
                
                reqSession.setAttribute("errorFlags", errorFlags);
                reqDispatcher = request.getRequestDispatcher("LeaveForm.jsp");
            } else if(maxLeave - (db.getApprovedLeaveCount(modelEmployee.getEmployeeID()) + dayCount) < 0){
                errorFlags.add(false);
                errorFlags.add(false);
                errorFlags.add(true);
                
                reqSession.setAttribute("errorFlags", errorFlags);
                reqDispatcher = request.getRequestDispatcher("LeaveForm.jsp");
            }else {
                reqSession.removeAttribute("errorFlags");
                String leaveType = request.getParameter("leaveType");
                float duration = Float.parseFloat(request.getParameter("dayCount"));
                
                //db.addLeaveForm(leaveType, db.getEntryNum(empIDNum), new java.sql.Date(startDate.getTime()), duration);
                System.out.println("ENTRYNUM: " + modelEmployee.getEntryNum());
                db.addLeaveForm(leaveType, modelEmployee.getEntryNum(), new java.sql.Date(startDate.getTime()), duration);
                reqDispatcher = request.getRequestDispatcher("LeaveSuccess.jsp");
                
                //send an email to the manager
                //en.sendLeaveRequest(db.getEntryNum(empIDNum), leaveType, startDate, endDate, duration);
                en.sendLeaveRequest(modelEmployee.getEntryNum(), leaveType, startDate, endDate, duration);
            }
            reqDispatcher.forward(request, response);
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
    }// </editor-fold>

    
    // -- function/s ----------------------------------------
    public int getDateDiff(Date startDate, Date endDate) {
        int dateDiff = (int)(endDate.getTime() - startDate.getTime())/(1000 * 60 * 60 * 24);
        
        return dateDiff + 1;
    }
}
