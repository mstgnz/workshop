import java.util.List;

public class AirwayCompany implements Airway{

    private String identity;
    private String airplaneType;
    private List<Pilot> pilots;
    private List<Airplane> airplanes;

    public AirwayCompany(String identity, String airplaneType, List<Pilot> pilots, List<Airplane> airplanes) {
        this.identity = identity;
        this.airplaneType = airplaneType;
        this.pilots = pilots;
        this.airplanes = airplanes;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }

    public List<Pilot> getPilots() {
        return pilots;
    }

    public void setPilots(List<Pilot> pilots) {
        this.pilots = pilots;
    }

    public List<Airplane> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(List<Airplane> airplanes) {
        this.airplanes = airplanes;
    }
}
