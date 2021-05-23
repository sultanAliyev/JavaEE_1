package kz.bitlab.servlets;

import kz.bitlab.db.DBManager;
import kz.bitlab.db.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Users checkUser = DBManager.getUsers(email);
        if (checkUser!=null && checkUser.getPassword().equals(password)){

            request.getSession().setAttribute("CURRENT_USER", checkUser);
            response.sendRedirect("/");

        }else {
            response.sendRedirect("/login?error");
        }
    }
}
