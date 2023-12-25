import java.util.ArrayList;
import java.util.List;

public class NotebookProduct extends Product {

    private int memory;
    private double screen;
    private int ram;
    private String color;

    public NotebookProduct(String name, double unitPrice, double discountRate, int stockAmount, Brand brand, Group group, int memory, double screen, int ram, String color) {
        super(name, unitPrice, discountRate, stockAmount, brand, group);
        this.memory = memory;
        this.screen = screen;
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
    public static List<NotebookProduct> createNotebookProduct(List<Brand> brandList, Group group) {
        List<NotebookProduct> notebookProducts = new ArrayList<>();

        notebookProducts.add(new NotebookProduct("HUAWEI Matebook 14", 7000.0, 0.15, 2000, brandList.get(2), group, 512, 14.0, 16, "Gray"));
        notebookProducts.add(new NotebookProduct("LENOVO V14 IGL", 3699.0, 0.18, 1345, brandList.get(4), group, 1024, 14.0, 8, "Black"));
        notebookProducts.add(new NotebookProduct("ASUS Tuf Gaming", 8199.0, 0.09, 352, brandList.get(5), group, 2048, 15.0, 16, "Red"));

        return notebookProducts;
    }
}
