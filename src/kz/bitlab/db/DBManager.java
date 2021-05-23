package kz.bitlab.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {

    private static ArrayList<Films> films = new ArrayList<>();

    private static Connection connection;

    static {
    try{

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/group_32_db?serverTimezone=UTC", "root", "");

    } catch (Exception e){
        e.printStackTrace();
    }



    }

    public static ArrayList<Films> getAllFilms(){

        ArrayList<Films> films = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT f.id, f.name, f.genre, f.duration, f.description, f.country_id, c.name as country_name, c.code, u.full_name, f.user_id " +
                    "FROM films f " +
                    "INNER JOIN countries c ON c.id = f.country_id " +
                    "INNER JOIN users u on f.user_id = u.id " +
                    "ORDER BY f.name ASC");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                films.add(
                        new Films(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getInt("duration"),
                                resultSet.getString("description"),
                                resultSet.getString("genre"),
                                new Countries(
                                        resultSet.getLong("country_id"),
                                        resultSet.getString("country_name"),
                                        resultSet.getString("code")
                                ),
                                new Users(
                                        resultSet.getLong("user_id"),
                                        null, null,
                                        resultSet.getString("full_name")
                                )
                        )
                );
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return films;

    }

    public static ArrayList<Films> searchFilms(String key){
       return null;
    }

    public static boolean addFilm(Films film){

        int rows = 0;

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO films (name, duration, description, genre, country_id, user_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?) ");

            statement.setString(1, film.getName());
            statement.setInt(2, film.getDuration());
            statement.setString(3, film.getDescription());
            statement.setString(4, film.getGenre());
            statement.setLong(5, film.getCountry().getId());
            statement.setLong(6, film.getUser().getId());

            rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return rows>0;

    }

    public static Films getFilm(Long id){

        Films film = null;

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT f.id, f.name, f.genre, f.duration, f.description, f.country_id, c.name as country_name, c.code, u.full_name, f.user_id " +
                    "FROM films f " +
                    "INNER JOIN countries c ON c.id = f.country_id " +
                    "INNER JOIN users u on f.user_id = u.id " +
                    "WHERE f.id = ?");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                film = new Films(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("duration"),
                        resultSet.getString("description"),
                        resultSet.getString("genre"),
                        new Countries(
                                resultSet.getLong("country_id"),
                                resultSet.getString("country_name"),
                                resultSet.getString("code")
                        ),
                        new Users(
                                resultSet.getLong("user_id"),
                                null, null,
                                resultSet.getString("full_name")
                        )
                );
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return film;

    }

    public static boolean saveFilms(Films films){
        int rows = 0;

        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE films " +
                    "SET name = ?, description = ?, duration = ?, country_id = ?, genre = ? " +
                    "WHERE id = ?");

            statement.setString(1,films.getName());
            statement.setString(2, films.getDescription());
            statement.setInt(3, films.getDuration());
            statement.setLong(4, films.getCountry().getId());
            statement.setString(5,films.getGenre());
            statement.setLong(6, films.getId());

            rows = statement.executeUpdate();


        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static boolean deleteFilms(Long id){
        int rows = 0;

        try {

            PreparedStatement statement = connection.prepareStatement("" +
                   "DELETE FROM films WHERE id = ?");


            statement.setLong(1, id);

            rows = statement.executeUpdate();


        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static ArrayList<Countries> getAllCountries(){

        ArrayList<Countries> countries = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM countries ORDER BY name ASC ");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                countries.add(
                        new Countries(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getString("code")
                        )
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    return countries;
    }

    public static Countries getCountries(Long id){
        Countries country = null;

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM countries WHERE id = ? ");
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                country = new Countries(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("code")
                );

            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return country;

    }

    public static Users getUsers(String email){

        Users users = null;

        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users WHERE email = ?");
            statement.setString(1,email);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                users = new Users(
                       resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name")

                );
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    public static boolean addUser(Users user){
        int rows = 0;

        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO users (email, password, full_name) " +
                    "VALUES (?, ?, ?)");

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());

            rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static boolean saveUser(Users user){
        int rows = 0;

        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE users SET full_name = ? WHERE id = ?");

            statement.setString(1, user.getFullName());
            statement.setLong(2, user.getId());

            rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static boolean updatePassword(Users user){
        int rows = 0;

        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE users SET password = ? WHERE id = ?");

            statement.setString(1, user.getPassword());
            statement.setLong(2, user.getId());

            rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static boolean addComment(Comments comment){

        int rows = 0;

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO comments (film_id, user_id, comment, post_date) " +
                    "VALUES (?, ?, ?, NOW())");

            statement.setLong(1, comment.getFilm().getId());
            statement.setLong(2, comment.getUser().getId());
            statement.setString(3, comment.getComment());

            rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static ArrayList<Comments> getAllComments(Long filmId){

        ArrayList<Comments> comments = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT c.id, c.comment, c.post_date, c.user_id, c.film_id, u.full_name " +
                    "FROM comments c " +
                    "INNER JOIN users u on c.user_id = u.id " +
                    "WHERE c.film_id = ? " +
                    "ORDER BY c.post_date DESC");

            statement.setLong(1, filmId);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                comments.add(new Comments(
                        resultSet.getLong("id"),
                        new Films(
                                resultSet.getLong("film_id")
                        ),
                        new Users(
                                resultSet.getLong("user_id"),
                                null, null,
                                resultSet.getString("full_name")
                        ),
                        resultSet.getString("comment"),
                        resultSet.getTimestamp("post_date")
                ));

            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return comments;

    }
}
