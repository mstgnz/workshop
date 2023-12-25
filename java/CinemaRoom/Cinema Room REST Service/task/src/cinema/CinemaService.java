package cinema;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CinemaService {

    // initialize
    public CinemaModel initializeSeats(){
        CinemaModel cinemaModel = new CinemaModel();

        cinemaModel.setTotalRows(9);
        cinemaModel.setTotalColumns(9);

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                cinemaModel.setAvailableSeats(new AvailableModel(i,j));
            }
        }
        return  cinemaModel;
    }

    public CinemaModel getSeats(CinemaModel cinemaModel){

        List<AvailableModel> newAvailableModel = new ArrayList<>();

        for (AvailableModel availableModel : cinemaModel.getAvailableSeats()){
            if (!availableModel.getReserved()){
                newAvailableModel.add(new AvailableModel(availableModel.getRow(), availableModel.getColumn()));
            }
        }
        cinemaModel.setAvailableSeats(newAvailableModel);
        return  cinemaModel;
    }

    // Out Of Bound Control
    public boolean isOutOfBounds(PurchaseRequestDto purchaseRequestDto){
        return purchaseRequestDto.getRow() > 9 || purchaseRequestDto.getColumn() > 9 || purchaseRequestDto.getRow() < 1 || purchaseRequestDto.getColumn() < 1;
    }

    // purchase
    public ResponseEntity<Response> purchase(PurchaseRequestDto purchaseRequestDto, CinemaModel cinemaModel){

        if(this.isOutOfBounds(purchaseRequestDto)){
            return ResponseEntity.badRequest().body(new ResponseError("The number of a row or a column is out of bounds!"));
        }

        for (AvailableModel availableModel : cinemaModel.getAvailableSeats()){
            if(availableModel.getColumn() == purchaseRequestDto.getColumn() && availableModel.getRow() == purchaseRequestDto.getRow() && !availableModel.getReserved()){
                availableModel.setReserved(true);
                return ResponseEntity.ok(new ResponsePurchase(availableModel));
            }
        }
        return ResponseEntity.badRequest().body(new ResponseError("The ticket has been already purchased!"));
    }

    // returns
    public ResponseEntity<Response> returns(ReturnRequestDto returnRequestDto, CinemaModel cinemaModel){
        for (AvailableModel availableModel : cinemaModel.getAvailableSeats()){
            if(availableModel.getToken().equals(returnRequestDto.getToken()) && availableModel.getReserved()){
                availableModel.setReserved(false);
                return ResponseEntity.ok(new ResponseReturn(availableModel));
            }
        }
        return ResponseEntity.badRequest().body(new ResponseError("Wrong token!"));
    }

    // stats
    public ResponseEntity<Response> stats(StatsRequestDto statsRequestDto, CinemaModel cinemaModel){
        try {
            if(statsRequestDto.getPassword().equals("super_secret")){
                int currentIncome = 0;
                int numberOfAvailableSeats = 0;
                int numberOfPurchasedTickets = 0;

                for(AvailableModel availableModel : cinemaModel.getAvailableSeats()){
                    if(availableModel.getReserved()){
                        numberOfPurchasedTickets++;
                        currentIncome += availableModel.getPrice();
                    }else{
                        numberOfAvailableSeats++;
                    }
                }
                return ResponseEntity.ok(new ResponseStats(currentIncome, numberOfAvailableSeats, numberOfPurchasedTickets));
            }
        }catch (Exception exception){ }
        return ResponseEntity.status(401).body(new ResponseError("The password is wrong!"));
    }
}
