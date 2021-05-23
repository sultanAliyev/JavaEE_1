package kz.bitlab.servlets;

import kz.bitlab.db.DBManager;
import kz.bitlab.db.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String redirect = "/register?passworderror";

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String re_password = request.getParameter("re_password");
        String fullName = request.getParameter("full_name");

        if (password.trim().equals(re_password.trim())){

            redirect = "/register?emailerror";

            Users checkuser = DBManager.getUsers(email);

            if (checkuser==null){

                Users newUser = new Users(null, email,password,fullName);
                if (DBManager.addUser(newUser)) {
                    redirect = "/register?success";
                }
            }
        }
        response.sendRedirect(redirect);

    }
}
