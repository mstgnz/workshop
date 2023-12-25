public class Airplane {
    private String type;
    private int pilotCount;
    private boolean status;

    public Airplane(String type, int pilotCount, boolean status) {
        this.type = type;
        this.pilotCount = pilotCount;
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPilotCount() {
        return pilotCount;
    }

    public void setPilotCount(int pilotCount) {
        this.pilotCount = pilotCount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
