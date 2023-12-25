import java.util.ArrayList;
import java.util.List;

public class FlyManagement {

    public static void main(String[] args) {
        Airplane airplane1 = new Airplane("Kargo",2,true);
        Airplane airplane2 = new Airplane("Yolcu",2,true);

        List<Airplane> airplanes = new ArrayList<Airplane>();
        airplanes.add(airplane1);
        airplanes.add(airplane2);

        Airport airport1 = new Airport("23D23DS45G23DF", "Atatürk Havalimanı");
        Airport airport2 = new Airport("2234SDFSDF33DF", "Sabiha Gökçen Havalimanı");
        Airport airport3 = new Airport("55555555555555", "Samsun Havalimanı");

        Pilot pilot1 = new Pilot("Mesut","GENEZ", 56.3);
        Pilot pilot2 = new Pilot("Ayça","GENEZ", 96.3);
        Pilot pilot3 = new Pilot("Muhammet","GENEZ", 77.7);

        List<Pilot> pilots = new ArrayList<Pilot>();
        pilots.add(pilot1);
        pilots.add(pilot2);
        pilots.add(pilot3);

        Flight flight1 = new Flight("SDF23423432SDF", airport1, airport3, "2021-10-11 12:00:00","2021-10-11:13:00:00",pilot1,pilot2);

        AirwayCompany airwayCompany = new AirwayCompany("GHJG456456DFG345","kısa", pilots, airplanes);
    }
}
