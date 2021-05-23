package kz.bitlab.servlets;

import kz.bitlab.db.Comments;
import kz.bitlab.db.DBManager;
import kz.bitlab.db.Films;
import kz.bitlab.db.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addcomment")
public class AddCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF8");
        Users currentUser = (Users)request.getSession().getAttribute("CURRENT_USER");
        if(currentUser!=null) {

            Long id = -1L;

            try{
                id = Long.parseLong(request.getParameter("id"));
            }catch (Exception e){
                e.printStackTrace();
            }

            Films film = DBManager.getFilm(id);

            if(film!=null){

                String text = request.getParameter("comment");

                Comments comment = new Comments();
                comment.setFilm(film);
                comment.setUser(currentUser);
                comment.setComment(text);

                DBManager.addComment(comment);
                response.sendRedirect("/details?id="+id+"#commentBlock");

            }else{
                response.sendRedirect("/");
            }

        }else{
            response.sendRedirect("/");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}