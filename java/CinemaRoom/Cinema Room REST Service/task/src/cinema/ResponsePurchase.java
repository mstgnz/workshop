package cinema;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ResponsePurchase implements  Response{

    private UUID token;
    private Map<String,Integer> ticket;

    public ResponsePurchase(AvailableModel availableModel) {
        this.token = availableModel.getToken();
        this.ticket = new HashMap<>();
        this.ticket.put("row", availableModel.getRow());
        this.ticket.put("column", availableModel.getColumn());
        this.ticket.put("price", availableModel.getPrice());
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public Map<String, Integer> getTicket() {
        return ticket;
    }

    public void setTicket(Map<String, Integer> ticket) {
        this.ticket = ticket;
    }
}
