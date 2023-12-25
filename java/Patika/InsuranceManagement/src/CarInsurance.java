public class CarInsurance extends Insurance{


    public CarInsurance(String name, String startDate, String endDate) {
        super(name, startDate, endDate);
    }

    @Override
    public void calculate() {
        this.price = 5555.55;
    }
}
