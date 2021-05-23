package kz.bitlab.servlets;

import kz.bitlab.db.DBManager;
import kz.bitlab.db.Films;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/homepage")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<h1 style = 'color:blue;'>HELLO FIRST JAVA EE APP</h1>");
        out.print("<form action = '/search' method = 'get'>");
        out.print("<input type = 'search' name = 'my_query' placeholder = 'Insert data'>");
        out.print("<button>SEARCH</button>");
        out.print("</form>");

        out.print("<br/><br/><br/>");
        out.print("<form action = '/addfilm' method = 'post'>");
        out.print("<label>NAME : </label> <input type = 'text' name = 'film_name'> <br/><br/>");
        out.print("<label>DESCRIPTION : </label> <input type = 'text' name = 'film_description'> <br/><br/>");
        out.print("<label>COUNTRY : </label> <input type = 'text' name = 'film_country'> <br/><br/>");
        out.print("<label>DURATION : </label> <input type = 'number' name = 'film_duration'> <br/><br/>");
        out.print("<label>GENRE : </label> <input type = 'text' name = 'film_genre'> <br/><br/>");
        out.print("<button>ADD FILM</button>");
        out.print("</form><br><br><br>");

        ArrayList<Films> films = DBManager.getAllFilms();

        out.print("<table cellpadding = '20px'>");
        out.print("<thead>");
        out.print("<tr><th>NAME </th><th>DESCRIPTION </th><th>COUNTRY </th><th>DURATION </th><th>GENRE </th></tr>");
        out.print("</thead>");
        out.print("<tbody>");
        for (Films f : films){
            out.print("<tr><td>"+f.getName()+"</td><td>"+f.getDescription()+"</td><td>"+f.getCountry()+"</td><td>"+f.getDuration()+"</td><td>"+f.getGenre()+"</td></tr>");
        }
        out.print("</tbody>");
        out.print("</table>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
