package kz.bitlab.db;

public class Films {

    private Long id;
    private String name;
    private int duration;
    private String description;
    private String genre;
    private Countries country;
    private Users user;

    public Films(Long id, String name, int duration, String description, String genre, Countries country, Users user) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.description = description;
        this.genre = genre;
        this.country = country;
        this.user = user;
    }

    public Films(){
    }

    public Films(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
