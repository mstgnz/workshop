package cinema;

import java.util.UUID;

public class ReturnRequestDto {

    private UUID token;

    public ReturnRequestDto() {
    }

    public ReturnRequestDto(UUID token) {
        this.token = token;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
}
