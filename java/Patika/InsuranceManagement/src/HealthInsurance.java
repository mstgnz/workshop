public class HealthInsurance extends Insurance{


    public HealthInsurance(String name, String startDate, String endDate) {
        super(name, startDate, endDate);
    }

    @Override
    public void calculate() {
        this.price = 3333.33;
    }
}
