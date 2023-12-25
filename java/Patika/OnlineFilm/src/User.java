public class User {

    private String firstname;
    private String lastname;
    private boolean subscriber;
    private double credit;
    private double money;

    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.subscriber = false;
        this.money = 0;
        this.credit = 25;
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

    public boolean isSubscriber() {
        return subscriber;
    }

    public void setSubscriber(boolean subscriber) {
        this.subscriber = subscriber;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
