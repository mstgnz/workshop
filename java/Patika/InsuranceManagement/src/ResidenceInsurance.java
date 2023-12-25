public class ResidenceInsurance extends Insurance{


    public ResidenceInsurance(String name, String startDate, String endDate) {
        super(name, startDate, endDate);
    }

    @Override
    public void calculate() {
        this.price = 9999.99;
    }
}
