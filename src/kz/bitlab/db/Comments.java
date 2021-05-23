package kz.bitlab.db;

import java.sql.Timestamp;

public class Comments {

    private Long id;
    private Films film;
    private Users user;
    private String comment;
    private Timestamp post_date;

    public Comments() {
    }

    public Comments(Long id) {
        this.id = id;
    }

    public Comments(Long id, Films film, Users user, String comment, Timestamp post_date) {
        this.id = id;
        this.film = film;
        this.user = user;
        this.comment = comment;
        this.post_date = post_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Films getFilm() {
        return film;
    }

    public void setFilm(Films film) {
        this.film = film;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getPost_date() {
        return post_date;
    }

    public void setPost_date(Timestamp post_date) {
        this.post_date = post_date;
    }
}
