package kz.bitlab.servlets;

import kz.bitlab.db.Countries;
import kz.bitlab.db.DBManager;
import kz.bitlab.db.Films;
import kz.bitlab.db.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Users currentUser = (Users)request.getSession().getAttribute("CURRENT_USER");
        if (currentUser!=null){

            request.getRequestDispatcher("/profile.jsp").forward(request, response);

        }else {

            response.sendRedirect("/login");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String redirect = "/login";

        Users currentUser = (Users)request.getSession().getAttribute("CURRENT_USER");
        if (currentUser!=null){

            redirect = "/profile?error";

            String fullName = request.getParameter("full_name");
            currentUser.setFullName(fullName);

            if (DBManager.saveUser(currentUser)){
                redirect = "/profile?profilesuccess";
            }

        }
        response.sendRedirect(redirect);
    }
}
