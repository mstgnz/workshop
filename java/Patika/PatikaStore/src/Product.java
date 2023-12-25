import java.util.UUID;

public class Product {
    private final String id;
    private String name;
    private double unitPrice;
    private double discountRate;
    private int stockAmount;
    private Brand brand;
    private Group group;

    protected Product(String name, double unitPrice, double discountRate, int stockAmount, Brand brand, Group group) {
        this.id = UUID.randomUUID().toString().replace("-","").substring(0,8);
        this.name = name;
        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
        this.stockAmount = stockAmount;
        this.brand = brand;
        this.group = group;
    }

    protected String getId() {
        return this.id;
    }

    protected double getUnitPrice() {
        return unitPrice;
    }

    protected void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    protected double getDiscountRate() {
        return discountRate;
    }

    protected void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    protected int getStockAmount() {
        return stockAmount;
    }

    protected void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected Brand getBrand() { return brand; }

    protected void setBrand(Brand brand) {
        this.brand = brand;
    }

    protected Group getGroup() {
        return group;
    }

    protected void setGroup(Group group) {
        this.group = group;
    }
}
