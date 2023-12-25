public class Flight {

    private String identify;
    private Airport departureAirport;
    private Airport landingAirport;
    private String departureTime;
    private String landingTime;
    private Pilot pilot;
    private Pilot coPilot;

    public Flight(String identify, Airport departureAirport, Airport landingAirport, String departureTime, String landingTime, Pilot pilot, Pilot coPilot) {
        this.identify = identify;
        this.departureAirport = departureAirport;
        this.landingAirport = landingAirport;
        this.departureTime = departureTime;
        this.landingTime = landingTime;
        this.pilot = pilot;
        this.coPilot = coPilot;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getLandingAirport() {
        return landingAirport;
    }

    public void setLandingAirport(Airport landingAirport) {
        this.landingAirport = landingAirport;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getLandingTime() {
        return landingTime;
    }

    public void setLandingTime(String landingTime) {
        this.landingTime = landingTime;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Pilot getCoPilot() {
        return coPilot;
    }

    public void setCoPilot(Pilot coPilot) {
        this.coPilot = coPilot;
    }
}
