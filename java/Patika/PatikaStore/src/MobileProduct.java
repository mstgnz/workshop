import java.util.ArrayList;
import java.util.List;

public class MobileProduct extends Product {

    private int memory;
    private double screen;
    private double battery;
    private int ram;
    private String color;

    public MobileProduct(String name, double unitPrice, double discountRate, int stockAmount, Brand brand, Group group, int memory, double screen, double battery, int ram, String color) {
        super(name, unitPrice, discountRate, stockAmount, brand, group);
        this.memory = memory;
        this.screen = screen;
        this.battery = battery;
        this.ram = ram;
        this.color = color;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public double getScreen() {
        return screen;
    }

    public void setScreen(double screen) {
        this.screen = screen;
    }

    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Default Marka Listesi
    public static List<MobileProduct> createMobileProduct(List<Brand> brandList, Group group){
        List<MobileProduct> mobileProducts = new ArrayList<>();

        mobileProducts.add(new MobileProduct("IPhone 11 64 GB",7379.0, 0.12,343, brandList.get(0), group, 64, 6.1,3046.0,6,"Blue"));
        mobileProducts.add(new MobileProduct("IPhone 12",12454.23, 0.09,33, brandList.get(1), group, 256, 12.3,3223.3,32,"Black"));
        mobileProducts.add(new MobileProduct("SAMSUNG GALAXY A51",3199.0, 0.11,33, brandList.get(2), group, 128, 12.3,3223.3,32,"White"));

        return mobileProducts;
    }
}
