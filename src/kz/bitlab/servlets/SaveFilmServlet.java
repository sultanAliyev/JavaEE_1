package kz.bitlab.servlets;

import kz.bitlab.db.Countries;
import kz.bitlab.db.DBManager;
import kz.bitlab.db.Films;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/savefilm")
public class SaveFilmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("film_name");
        String desc = request.getParameter("film_description");
        Long countryId = Long.parseLong(request.getParameter("film_country"));
        int duration = Integer.parseInt(request.getParameter("film_duration"));
        String genre = request.getParameter("film_genre");

        Long id = -1L;

        try {

            id = Long.parseLong(request.getParameter("id"));


        }catch (Exception e) {
        }

        Films films = DBManager.getFilm(id);

        if(films!=null){

            Countries checkCountries = DBManager.getCountries(countryId);

            if (checkCountries!=null){
                films.setName(name);
                films.setDescription(desc);
                films.setDuration(duration);
                films.setGenre(genre);
                films.setCountry(checkCountries);
                DBManager.saveFilms(films);
            }


            response.sendRedirect("/details?id="+id);
        }else{
            response.sendRedirect("/");
        }

    }
}

