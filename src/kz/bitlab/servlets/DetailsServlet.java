package kz.bitlab.servlets;

import kz.bitlab.db.Comments;
import kz.bitlab.db.Countries;
import kz.bitlab.db.DBManager;
import kz.bitlab.db.Films;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = -1L;

        try{

            id = Long.parseLong(request.getParameter("id"));

        }catch (Exception e){
        }

        Films film = DBManager.getFilm(id);

        if(film!=null){

            ArrayList<Comments> comments = DBManager.getAllComments(film.getId());
            request.setAttribute("comment", comments);

            request.setAttribute("film", film);
            request.getRequestDispatcher("/details.jsp").forward(request, response);

        }else{
            response.sendRedirect("/");
        }

    }
}