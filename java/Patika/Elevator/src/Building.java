import java.util.List;

public class Building {
    private String name;
    private List<Floor> floors;
    private List<Lift> lifts;

    public Building(String name, List<Floor> floors, List<Lift> lifts) {
        this.name = name;
        this.floors = floors;
        this.lifts = lifts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public List<Lift> getLifts() {
        return lifts;
    }

    public void setLifts(List<Lift> lifts) {
        this.lifts = lifts;
    }
}
