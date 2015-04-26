
/*  Class Name:      SaveMemo
 *   Developer:      Jet Virtusio
 *   Description:    Saves Award in database
 */

package Servlets;

import Database.Database;
import Models.modelEmployee;
import java.io.IOException;
import java.io.InputStream;
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


@MultipartConfig(maxFileSize = 16177215)
public class SaveAward extends HttpServlet {

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
        String memo = request.getParameter("memoNote");
        InputStream inputStream = null;
        String dates = request.getParameter("awardreceive");
        String awardname = request.getParameter("awardname");

        System.out.println("date is " + dates);

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = null;

        try {
            date = formatter.parse(dates);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        java.sql.Date sql = new java.sql.Date(date.getTime());

        if (awardname.length() >= 42) {
            System.out.println("Too much characters");
            request.setAttribute("message", "Character Limit Reached for Award Name");
            RequestDispatcher view = request.getRequestDispatcher("addAward.jsp");
            view.forward(request, response);
        }

        if (memo.length() >= 2500) {
            System.out.println("Too much characters");

            request.setAttribute("message", "Character Limit Reached");
            RequestDispatcher view = request.getRequestDispatcher("addAward.jsp");
            view.forward(request, response);
        }
        if (filePart.getSize() != 0) {
            System.out.println("File Size is " + filePart.getSize());
            if (filePart.getSize() > 10847412) {
                request.setAttribute("message", "File Size Limit Reached");
                RequestDispatcher view = request.getRequestDispatcher("addAward.jsp");
                view.forward(request, response);
            }

        }

        Database db = Database.getInstance();
        if (filePart.getSize() != 0) {

            inputStream = filePart.getInputStream();
            String nameoffile = filePart.getSubmittedFileName();
            //  db.saveDisciplinary(intid, memo,typeofmemo,inputStream,nameoffile );  
            db.saveAward(intid, sql, awardname, memo, inputStream, nameoffile);

        } else {
            db.saveAward(intid, sql, awardname, memo, null, null);

        }
         //till here

        request.setAttribute("message", "Success!");
        RequestDispatcher view = request.getRequestDispatcher("FileAwardSuccess.jsp");
        view.forward(request, response);
    }
}
