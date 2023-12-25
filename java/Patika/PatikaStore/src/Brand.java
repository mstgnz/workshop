import java.util.*;

public class Brand{

    private final String id;
    private String name;

    public Brand(String name) {
        this.id = UUID.randomUUID().toString().replace("-","").substring(0,8);
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // Default Marka Listesi
    public static List<Brand> createBrand(){
        List<Brand> brands = new ArrayList<>();
        String[] defaultBrands = {"Samsung", "Lenovo", "Apple", "Huawei", "Casper", "Asus", "HP", "Xiaomi", "Monster"};
        for (int i = 0; i < defaultBrands.length; i++) {
            brands.add(new Brand(defaultBrands[i]));
        }
        brands.sort(Comparator.comparing(Brand::getName));
        return brands;
    }

    // print
    public static void print(List<Brand> brands){
        for (Brand brand: brands) {
            System.out.println(brand.getId()+" "+brand.getName());
        }
        /*Queue<Brand> transforms = new PriorityQueue<>(brands);
        while (!transforms.isEmpty()){
            System.out.println(transforms.poll().getName());
        }*/
    }
}
