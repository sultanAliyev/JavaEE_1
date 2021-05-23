package kz.bitlab.servlets;

import kz.bitlab.db.Countries;
import kz.bitlab.db.DBManager;
import kz.bitlab.db.Films;
import kz.bitlab.db.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/addfilm")
public class AddFilmServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF8");

        Users currentUser = (Users)request.getSession().getAttribute("CURRENT_USER");

        if(currentUser!=null) {

            String name = request.getParameter("film_name");
            String desc = request.getParameter("film_description");
            Long countryId = Long.parseLong(request.getParameter("film_country"));
            int duration = Integer.parseInt(request.getParameter("film_duration"));
            String genre = request.getParameter("film_genre");

            Countries checkCountry = DBManager.getCountries(countryId);

            if (checkCountry != null) {

                Films f = new Films();
                f.setName(name);
                f.setGenre(genre);
                f.setDuration(duration);
                f.setDescription(desc);
                f.setCountry(checkCountry);
                f.setUser(currentUser);

                DBManager.addFilm(f);

            }

        }

        response.sendRedirect("/");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Users currentUser = (Users)request.getSession().getAttribute("CURRENT_USER");

        if(currentUser!=null) {

            ArrayList<Countries> countries = DBManager.getAllCountries();
            request.setAttribute("countries", countries);

            request.getRequestDispatcher("/addfilm.jsp").forward(request, response);

        }else{
            response.sendRedirect("/login");
        }
    }
}