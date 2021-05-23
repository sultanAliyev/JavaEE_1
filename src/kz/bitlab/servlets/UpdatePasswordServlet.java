package kz.bitlab.servlets;

import kz.bitlab.db.DBManager;
import kz.bitlab.db.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/updatepassword")
public class UpdatePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String redirect = "/login";

        Users currentUser = (Users)request.getSession().getAttribute("CURRENT_USER");
        if (currentUser!=null){

            redirect = "/profile?passworderror";

            String oldPass = request.getParameter("old_password");
            String newPass = request.getParameter("new_password");
            String renewPass = request.getParameter("re_new_password");

            if (currentUser.getPassword().equals(oldPass)){

                redirect = "/profile?passworderror";

                if (newPass.equals(renewPass)){
                    currentUser.setPassword(newPass);
                    if (DBManager.updatePassword(currentUser)) {

                        redirect = "/profile?passwordsuccess";

                    }
                }

            }

        }
        response.sendRedirect(redirect);
    }
}
