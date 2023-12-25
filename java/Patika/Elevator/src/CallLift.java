public class CallLift {
    private String name;
    private boolean up;
    private boolean down;

    public CallLift(String name, boolean up, boolean down) {
        this.name = name;
        this.up = up;
        this.down = down;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
