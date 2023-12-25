package Models;

public class Course {

    private int id;
    private int userId;
    private int patikaId;
    private String name;
    private String language;
    private Patika patika;
    private User user;

    public Course() { }

    public Course(int id, int userId, int patikaId, String name, String language) {
        this.id = id;
        this.userId = userId;
        this.patikaId = patikaId;
        this.name = name;
        this.language = language;
    }

    public Course(int id, int userId, int patikaId, String name, String language, Patika patika, User user) {
        this.id = id;
        this.userId = userId;
        this.patikaId = patikaId;
        this.name = name;
        this.language = language;
        this.patika = patika;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPatikaId() {
        return patikaId;
    }

    public void setPatikaId(int patikaId) {
        this.patikaId = patikaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Patika getPatika() {
        return patika;
    }

    public void setPatika(Patika patika) {
        this.patika = patika;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
