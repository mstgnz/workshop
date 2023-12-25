public abstract class ILift {
    private String name;
    private int capacity;
    private boolean door;
    private boolean floorLight;
    private Panel panel;
    private boolean ring;
    private boolean fault;

    public ILift(String name, int capacity, boolean door, boolean floorLight, Panel panel, boolean ring, boolean fault) {
        this.name = name;
        this.capacity = capacity;
        this.door = door;
        this.floorLight = floorLight;
        this.panel = panel;
        this.ring = ring;
        this.fault = fault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isDoor() {
        return door;
    }

    public void setDoor(boolean door) {
        this.door = door;
    }

    public boolean isFloorLight() {
        return floorLight;
    }

    public void setFloorLight(boolean floorLight) {
        this.floorLight = floorLight;
    }

    public Panel getPanel() {
        return panel;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }

    public boolean isRing() {
        return ring;
    }

    public void setRing(boolean ring) {
        this.ring = ring;
    }

    public boolean isFault() {
        return fault;
    }

    public void setFault(boolean fault) {
        this.fault = fault;
    }

    public abstract void direction();

}
