/*
 * update parent admin
 * 19-02-2023
 */
package controller.admin;

import dao.impl.ParentDAOImpl;
import entity.Parent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ParentDAOInterface;


@WebServlet(name = "UpdateParentAdmin", urlPatterns = {"/UpdateParentAdmin"})
public class UpdateParentAdminController extends HttpServlet {

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
            ParentDAOInterface parentDAOImplement = new ParentDAOImpl();
            // take parent id of Parent which you want to update
            int id = Integer.parseInt(request.getParameter("id"));
            // From parent id which you take all information of parent
            Parent parent = parentDAOImplement.ViewInfoByID(id);
            request.setAttribute("parent", parent);
            request.getRequestDispatcher("Admin/UpdateParentAdmin.jsp").forward(request, response);
        } catch (Exception e) {
            Logger.getLogger(UpdateParentAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // Update Parent *ADMIN*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            // take parent id from form Update Parent
            int id = Integer.parseInt(request.getParameter("pid"));
            // take parent img from form Update Parent
            String img = request.getParameter("img");
            // take parent first name from form Update Parent
            String firstName = request.getParameter("firstName").trim().replaceAll("\\s+"," ");
            // take parent last name from form Update Parent
            String lastName = request.getParameter("lastName").trim().replaceAll("\\s+"," ");
            // take parent phone from form Update Parent
            String phone = request.getParameter("phone").trim().replaceAll("\\s+"," ");
            // take parent birthday from form Update Parent
            String birth = request.getParameter("birth");
            // take parent address from form Update Parent
            String address = request.getParameter("address").trim().replaceAll("\\s+"," ");
            // take parent job from form Update Parent
            String job = request.getParameter("job").trim().replaceAll("\\s+"," ");

            ParentDAOInterface parentDAOImplement = new ParentDAOImpl();
            Parent parent = new Parent(id, img, firstName, lastName, phone, birth, address, job);
            // Update information of parent to database
            parentDAOImplement.UpdateProfileParent(parent);
            //change to the Parent Admin
            response.sendRedirect("ListAllParentAdmin");
        } catch (Exception e) {
            Logger.getLogger(UpdateParentAdminController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
