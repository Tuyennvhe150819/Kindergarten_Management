/*
 * view parent (parent)
 * 15-02-2023
 */
package controller.parent;

import entity.Parent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MSII
 */
@WebServlet(name = "ViewProfileParent", urlPatterns = {"/viewProfileParent"})
public class ViewProfileParentController extends HttpServlet {
    /**
     * view profile parent
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Parent parent = (Parent) request.getSession().getAttribute("parent");
            if (parent != null) {
                request.getRequestDispatcher("Parent/profileParent.jsp").forward(request, response);
            } else {
                response.sendRedirect("Login");
            }
        } catch (Exception e) {
            Logger.getLogger(ViewProfileParentController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
