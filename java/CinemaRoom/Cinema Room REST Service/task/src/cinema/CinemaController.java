package cinema;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping
public class CinemaController {

    CinemaService cinemaService = new CinemaService();
    CinemaModel cinemaModel = cinemaService.initializeSeats();

    @GetMapping
    public ResponseEntity<String> index(){
        return  ResponseEntity.ok("Hello Cinema Task.");
    }

    @GetMapping("/seats")
    public ResponseEntity<CinemaModel> seats(){
        return ResponseEntity.ok(cinemaService.getSeats(cinemaModel));
    }

    @PostMapping("/purchase")
    public ResponseEntity<Response> purchase(@RequestBody PurchaseRequestDto purchaseRequestDto){
        return cinemaService.purchase(purchaseRequestDto, cinemaModel);
    }

    @PostMapping("/return")
    public ResponseEntity<Response> returns(@RequestBody ReturnRequestDto returnRequestDto){
        return cinemaService.returns(returnRequestDto, cinemaModel);
    }

    //@PostMapping(value = "/stats")
    @RequestMapping(value = "/stats", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
    public ResponseEntity<Response> stats(StatsRequestDto statsRequestDto){
        return cinemaService.stats(statsRequestDto, cinemaModel);
    }

}
