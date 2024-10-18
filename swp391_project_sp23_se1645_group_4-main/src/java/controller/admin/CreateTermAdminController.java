/*
 * Add term
 * 16-02-2023
 */
package controller.admin;

import dao.impl.TermDAOImpl;
import entity.Account;
import entity.Term;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.TermDAOInterface;

/**
 *
 */
@WebServlet(name = "CreateTermAD", urlPatterns = {"/CreateTermAD"})
public class CreateTermAdminController extends HttpServlet {

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
        try {
            Account acc = (Account) request.getSession().getAttribute("account");
            if (acc != null) {
                if (acc.getRole() == 0) {
                    //change to the Create Term 
                    request.getRequestDispatcher("Admin/CreateTermAdmin.jsp").forward(request, response);
                } else {
                    response.sendRedirect("Login");
                }
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(CreateTermAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */// Create new Term *ADMIM*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            // take Term name from form CreateTerm.jsp 
            String Termname = request.getParameter("name");
            // take startDay from form CreateTerm.jsp 
            String startD = request.getParameter("startD");
            // take endDay from form CreateTerm.jsp 
            String endD = request.getParameter("endD");

            TermDAOInterface termDAOImpl = new TermDAOImpl();
            Term term = new Term(Termname, startD, endD);
            // Add new term to databse
            termDAOImpl.AddTerm(term);
            //change to the List All Term 
            response.sendRedirect("ListAllTermAD");
        } catch (Exception e) {
            Logger.getLogger(CreateTermAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
