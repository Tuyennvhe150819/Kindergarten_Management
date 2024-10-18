/*
 * update parent (parent)
 * 25-02-2023
 */
package controller.parent;

import dao.impl.ParentDAOImpl;
import entity.Parent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ParentDAOInterface;

/**
 * update profile of parent
 *
 * @author MSII
 */
@WebServlet(name = "UpdateProfileParent", urlPatterns = {"/udparent"})
public class UpdateProfileParentController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method. 
     * đường dẫn đến file jsp của
     * profile parent
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Parent parent = (Parent) request.getSession().getAttribute("parent");
            if (parent != null) {
                request.getRequestDispatcher("Parent/updateProfileParent.jsp").forward(request, response);
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(UpdateProfileParentController.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    /**
     * Update profile parent
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            Parent parent = (Parent) request.getSession().getAttribute("parent");
            if (parent != null) {
                int id = Integer.parseInt(request.getParameter("id"));
                String img = request.getParameter("img");
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                String phone = request.getParameter("phone");
                String birthdate = request.getParameter("datebirth");
                String address = request.getParameter("address");
                String job = request.getParameter("job");
                ParentDAOInterface parentDAOInterface = new ParentDAOImpl();
                Parent parent1 = new Parent(id, img, firstname, lastname, phone, birthdate, address, job);
                parentDAOInterface.UpdateProfileParent(parent1);
                response.sendRedirect("homePageController");
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(UpdateProfileParentController.class.getName()).log(Level.SEVERE, null, e);
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

}
