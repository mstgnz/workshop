import java.util.List;

public class Floor {
    private String name;
    private int floor;
    private boolean ring;
    private boolean light;
    private List<CallLift> callLifts;

    public Floor(String name, int floor, boolean ring, boolean light, List<CallLift> callLifts) {
        this.name = name;
        this.floor = floor;
        this.ring = ring;
        this.light = light;
        this.callLifts = callLifts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isRing() {
        return ring;
    }

    public void setRing(boolean ring) {
        this.ring = ring;
    }

    public boolean isLight() {
        return light;
    }

    public void setLight(boolean light) {
        this.light = light;
    }

    public List<CallLift> getCallLifts() {
        return callLifts;
    }

    public void setCallLifts(List<CallLift> callLifts) {
        this.callLifts = callLifts;
    }
}
