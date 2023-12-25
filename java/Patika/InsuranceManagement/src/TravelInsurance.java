public class TravelInsurance extends Insurance{


    public TravelInsurance(String name, String startDate, String endDate) {
        super(name, startDate, endDate);
    }

    @Override
    public void calculate() {
        this.price = 2222.22;
    }
}
