public class Lift extends ILift{
    private boolean up;
    private boolean down;
    private int[] floors;
    private int whichFloor;

    public Lift(
            String name, int capacity, boolean door, boolean floorLight, Panel panel,
            boolean ring, boolean fault, boolean up, boolean down, int[] floors, int whichFloor
    ) {
        super(name, capacity, door, floorLight, panel, ring, fault);
        this.up = up;
        this.down = down;
        this.floors = floors;
        this.whichFloor = whichFloor;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public int[] getFloors() {
        return floors;
    }

    public void setFloors(int[] floors) {
        this.floors = floors;
    }

    public int getWhichFloor() {
        return whichFloor;
    }

    public void setWhichFloor(int whichFloor) {
        this.whichFloor = whichFloor;
    }

    @Override
    public void direction() {

    }
}
