package cinema;

import java.util.HashMap;
import java.util.Map;

public class ResponseReturn implements Response{

    private Map<String, Integer> returnedTicket;

    public ResponseReturn(AvailableModel availableModel) {
        this.returnedTicket = new HashMap<>();
        this.returnedTicket.put("row", availableModel.getRow());
        this.returnedTicket.put("column", availableModel.getColumn());
        this.returnedTicket.put("price", availableModel.getPrice());
    }

    public Map<String, Integer> getReturnedTicket() {
        return returnedTicket;
    }

    public void setReturnedTicket(Map<String, Integer> returnedTicket) {
        this.returnedTicket = returnedTicket;
    }
}
