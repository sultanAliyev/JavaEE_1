package kz.bitlab.servlets;

import kz.bitlab.db.Countries;
import kz.bitlab.db.DBManager;
import kz.bitlab.db.Films;
import kz.bitlab.db.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/editfilm")
public class EditFilmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Users currentUser = (Users)request.getSession().getAttribute("CURRENT_USER");

        if(currentUser!=null) {

            Long id = -1L;

            try{

                id = Long.parseLong(request.getParameter("id"));

            }catch (Exception e){
            }

            Films film = DBManager.getFilm(id);
            request.setAttribute("film", film);

            if(film!=null && film.getUser().getId()==currentUser.getId()){

                ArrayList<Countries> countries = DBManager.getAllCountries();
                request.setAttribute("countries", countries);

                request.getRequestDispatcher("/editfilm.jsp").forward(request, response);

            }else{
                response.sendRedirect("/");
            }

        }else{
            response.sendRedirect("/");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF8");

        Users currentUser = (Users)request.getSession().getAttribute("CURRENT_USER");

        if(currentUser!=null) {

            Long id = -1L;

            try {

                id = Long.parseLong(request.getParameter("id"));

            }catch (Exception e){
                e.printStackTrace();
            }

            Films film = DBManager.getFilm(id);

            if (film!=null && currentUser.getId()==film.getUser().getId()){

                String name = request.getParameter("film_name");
                String desc = request.getParameter("film_description");
                Long countryId = Long.parseLong(request.getParameter("film_country"));
                int duration = Integer.parseInt(request.getParameter("film_duration"));
                String genre = request.getParameter("film_genre");

                Countries checkCountry = DBManager.getCountries(countryId);

                if (checkCountry != null) {


                    film.setName(name);
                    film.setGenre(genre);
                    film.setDuration(duration);
                    film.setDescription(desc);
                    film.setCountry(checkCountry);
                    film.setUser(currentUser);

                    DBManager.saveFilms(film);

                    response.sendRedirect("/details?id="+id);
                }else {
                    response.sendRedirect("/editfilm?id="+id);
                }

            }else {
                response.sendRedirect("/");
            }

        }else {
            response.sendRedirect("/");
        }

    }
}
