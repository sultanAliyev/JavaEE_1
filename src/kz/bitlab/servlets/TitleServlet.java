package kz.bitlab.servlets;

import kz.bitlab.db.Countries;
import kz.bitlab.db.DBManager;
import kz.bitlab.db.Films;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(value = "/title")
public class TitleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cName = "No Name";


        Cookie cookies[] = request.getCookies();
        if(cookies!=null){
            for(Cookie c : cookies){
                if(c.getName().equals("title")){
                    cName = c.getValue();
                }
                else{
                    cName = "Default Site Name";
                }
            }
        }


        request.setAttribute("resultText", cName);

        request.getRequestDispatcher("/title.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("title_name");

        Cookie nameCookie = new Cookie("title", name);
        nameCookie.setMaxAge(3600*24);
        response.addCookie(nameCookie);

        response.sendRedirect("/title");
    }
}

