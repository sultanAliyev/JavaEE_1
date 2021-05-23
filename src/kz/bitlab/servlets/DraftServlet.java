package kz.bitlab.servlets;

import kz.bitlab.db.Countries;
import kz.bitlab.db.DBManager;
import kz.bitlab.db.Films;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/draft")
public class DraftServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cName = "";
        String cSurname = "";
        String cAge = "";
        String cCountry = "";
        String cCard = "";

        Cookie cookies[] = request.getCookies();
        if(cookies!=null){
            for(Cookie c : cookies){
                if(c.getName().equals("user_name")){
                    cName = c.getValue();
                }
                if(c.getName().equals("user_age")){
                    cAge = c.getValue();
                }
                if(c.getName().equals("user_surname")){
                    cSurname = c.getValue();
                }
                if(c.getName().equals("user_country")){
                    cCountry = c.getValue();
                }
                if(c.getName().equals("user_card")){
                    cCard = c.getValue();
                }
            }
        }


        request.setAttribute("user_name",cName);
        request.setAttribute("user_surname",cSurname);
        request.setAttribute("user_age",cAge);
        request.setAttribute("user_country",cCountry);
        request.setAttribute("user_card",cCard);


        request.getRequestDispatcher("/draft.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("user_name");
        String surname = request.getParameter("user_surname");
        String age = request.getParameter("user_age");
        String country = request.getParameter("user_country");
        String card = request.getParameter("user_card");


        Cookie nameCookie = new Cookie("user_name", name);
        nameCookie.setMaxAge(3600*24*30);
        response.addCookie(nameCookie);

        Cookie surnameCookie = new Cookie("user_surname", surname);
        surnameCookie.setMaxAge(3600*24*30);
        response.addCookie(surnameCookie);

        Cookie ageCookie = new Cookie("user_age", age);
        ageCookie.setMaxAge(3600*24*30);
        response.addCookie(ageCookie);

        Cookie countryCookie = new Cookie("user_country", country);
        countryCookie.setMaxAge(3600*24*30);
        response.addCookie(countryCookie);

        Cookie cardCookie = new Cookie("user_card", card);
        cardCookie.setMaxAge(3600*24*30);
        response.addCookie(cardCookie);


        response.sendRedirect("/draft");

    }
}
