/*
 * update term admin
 * 17-02-2023
 */
package controller.admin;

import dao.impl.TermDAOImpl;
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


@WebServlet(name = "UpdateTermAdmin", urlPatterns = {"/UpdateTermAdmin"})
public class UpdateTermAdminController extends HttpServlet {

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
            TermDAOInterface termDAOImpl = new TermDAOImpl();
            // take term id of Term which you want to update
            int id = Integer.parseInt(request.getParameter("id"));

            // From term id which you take all information of term
            Term term = termDAOImpl.ShowTermByID(id);

            request.setAttribute("term", term);
            //change to the Update Term 
            request.getRequestDispatcher("Admin/UpdateTermAdmin.jsp").forward(request, response);
        } catch (Exception e) {
            Logger.getLogger(UpdateTermAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // Update Term by ID *ADMIN*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            // take Term id from form Update Term 
            int id = Integer.parseInt(request.getParameter("tid"));
            // take Term name from form Update Term 
            String name = request.getParameter("name");
            // take startDay from form Update Term  
            String startD = request.getParameter("startD");
            // take endDay from form Update Term 
            String endD = request.getParameter("endD");

            TermDAOInterface termDAOImpl = new TermDAOImpl();
            Term term = new Term(id, name, startD, endD);
            // update information of Term to database
            termDAOImpl.UpdateTerm(term);
            //change to the List All Term 
            response.sendRedirect("ListAllTermAD");
        } catch (Exception e) {
            Logger.getLogger(UpdateTermAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
