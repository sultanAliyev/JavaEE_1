package kz.bitlab.servlets;

import kz.bitlab.db.DBManager;
import kz.bitlab.db.Films;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/deletefilm")
public class DeleteFilmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = -1L;

        try {

            id = Long.parseLong(request.getParameter("id"));


        }catch (Exception e) {
        }

        Films films = DBManager.getFilm(id);

        if(films!=null){
            DBManager.deleteFilms(id);
        }
        response.sendRedirect("/");
    }
}
