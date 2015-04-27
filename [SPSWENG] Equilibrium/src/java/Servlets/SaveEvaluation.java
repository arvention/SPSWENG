
/*  Class Name:     SaveEvaluation
 *   Developer:      Jet Virtusio
 *   Description:    servlet used to save the evaluation record to the database
 */
package Servlets;

import Database.Database;
import Models.modelEmployee;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 16177215)
public class SaveEvaluation extends HttpServlet {

    /*
    *   The doGet function of the servlet.
    */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /*
    *   The doPost function of the servlet.
    *   Updates changes in the database using queries.
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
        String evalname = "";
        evalname = request.getParameter("evalname");

        if (score.length() >= 10) {
            request.setAttribute("message", "Character Limit Reached for score");
            RequestDispatcher view = request.getRequestDispatcher("addEvaluation.jsp");
            view.forward(request, response);
        }

        if (evalname.length() >= 50) {
            request.setAttribute("message", "Character Limit Reached");
            RequestDispatcher view = request.getRequestDispatcher("addEvaluation.jsp");
            view.forward(request, response);
        }
        
        if (filePart.getSize() != 0) {
            System.out.println("File Size is " + filePart.getSize());
            if (filePart.getSize() > 10847412) {
                request.setAttribute("message", "File Size Limit Reached");
                RequestDispatcher view = request.getRequestDispatcher("addEvaluation.jsp");
                view.forward(request, response);
            }
        }

        Database db = Database.getInstance();
        if (filePart.getSize() != 0) {

            inputStream = filePart.getInputStream();
            System.out.println("I am over gereee");
            String nameoffile = filePart.getSubmittedFileName();
            //db.saveDisciplinary(intid, memo,typeofmemo,inputStream,nameoffile );  
            //db.saveAward(intid, sql,awardname , memo, inputStream, nameoffile);
            db.saveEval(intid, evalname, score, inputStream, nameoffile);
        } else {
            db.saveEval(intid, evalname, score, null, null);
        }
        
        //till here
        request.setAttribute("message", "Success!");
        RequestDispatcher view = request.getRequestDispatcher("EvaluationSuccess.jsp");
        view.forward(request, response);
    }
}
