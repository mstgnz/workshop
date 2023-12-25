public class Pilot {

    private String firstname;
    private String lastname;
    private double experience;

    public Pilot(String firstname, String lastname, double experience) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.experience = experience;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }
}
