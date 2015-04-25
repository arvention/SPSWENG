/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.Database;
import Models.modelEmployee;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arces
 */
public class EditEmployeeData extends HttpServlet {

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
            out.println("<title>Servlet EditEmployeeData</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditEmployeeData at " + request.getContextPath() + "</h1>");
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

    public void editPersonalInformation(modelEmployee logged, modelEmployee emp, HttpServletRequest request) {
        Database db = Database.getInstance();
        String firstname = request.getParameter("firstname");
        if (!emp.getFirstName().equals(firstname)) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "firstName", emp.getFirstName(), firstname, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "firstName", emp.getFirstName(), firstname, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());
                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "firstName", firstname);
                    break;
            }
        }

        String middlename = request.getParameter("middlename");
        if (!emp.getMiddleName().equals(middlename)) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "middleName", emp.getMiddleName(), middlename, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "middleName", emp.getMiddleName(), middlename, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());
                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "middleName", middlename);
                    break;
            }
        }
        
        String lastname = request.getParameter("lastname");
        if (!emp.getLastName().equals(lastname)) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "lastName", emp.getLastName(), lastname, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "middleName", emp.getMiddleName(), middlename, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());
                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "lastName", lastname);
                    break;
            }
        }
        
        String position = request.getParameter("position");
        if (!emp.getPositionName().equals(position)) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "positionName", emp.getPositionName(), position, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "positionName", emp.getPositionName(), position, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());
                    
                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "middleName", middlename);
                    break;
            }
        }
        
        int salary = Integer.parseInt(request.getParameter("salary"));
        if (emp.getSalary() != salary) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "salary", Integer.toString(emp.getSalary()), Integer.toString(salary), logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "salary", Integer.toString(emp.getSalary()), Integer.toString(salary), logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());
                    
                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "salary", Integer.toString(salary));
                    break;
            }
        }
        
        String birthplace = request.getParameter("birthplace");
        if (emp.getSalary() != salary) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "birthplace", emp.getBirthplace(), birthplace, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "birthplace", emp.getBirthplace(), birthplace, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());
                    
                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "birthplace", birthplace);
                    break;
            }
        }
        
        String address = request.getParameter("address");
        if (emp.getSalary() != salary) {
            switch (logged.getEmployeeType()) {
                case "Hr Employee":
                    db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "address", emp.getAddress(), address, logged.getEntryNum(), emp.getEntryNum(), logged.getManagerEntryNum());
                    break;
                case "Hr Head":
                    int auditTrailID = db.addEmployeeAuditTrail("employee", emp.getEntryNum(), "address", emp.getAddress(), address, logged.getEntryNum(), emp.getEntryNum(), logged.getEntryNum());
                    
                    db.changeAuditStatus(auditTrailID, "Approved");
                    db.changeFieldValue("employee", emp.getEntryNum(), "address", address);
                    break;
            }
        }
    }
}
