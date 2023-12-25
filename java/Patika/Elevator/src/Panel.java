public class Panel {
    private String name;
    private int[] floors;
    private boolean openDoor;
    private boolean closeDoor;
    private boolean emergency;

    public Panel(String name, int[] floors, boolean openDoor, boolean closeDoor, boolean emergency) {
        this.name = name;
        this.floors = floors;
        this.openDoor = openDoor;
        this.closeDoor = closeDoor;
        this.emergency = emergency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getFloors() {
        return floors;
    }

    public void setFloors(int[] floors) {
        this.floors = floors;
    }

    public boolean isOpenDoor() {
        return openDoor;
    }

    public void setOpenDoor(boolean openDoor) {
        this.openDoor = openDoor;
    }

    public boolean isCloseDoor() {
        return closeDoor;
    }

    public void setCloseDoor(boolean closeDoor) {
        this.closeDoor = closeDoor;
    }

    public boolean isEmergency() {
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }
}
