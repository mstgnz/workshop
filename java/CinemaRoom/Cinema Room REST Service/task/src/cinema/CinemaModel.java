package cinema;
import java.util.ArrayList;
import java.util.List;

public class CinemaModel {

    private int totalRows;
    private int totalColumns;
    private List<AvailableModel> availableSeats;

    public CinemaModel() {
        this.availableSeats = new ArrayList<>();
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    public List<AvailableModel> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(AvailableModel availableSeats) {
        this.availableSeats.add(availableSeats);
    }

    public void setAvailableSeats(List<AvailableModel> availableSeats) {
        this.availableSeats = availableSeats;
    }
}
