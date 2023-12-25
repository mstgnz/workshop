package cinema;

public class StatsRequestDto {

    private String password;

    public StatsRequestDto() {
    }

    public StatsRequestDto(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
