public abstract class Insurance {

    protected String name;
    protected double price;
    protected String startDate;
    protected String endDate;

    protected Insurance(String name, String startDate, String endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    protected abstract void calculate();

}
