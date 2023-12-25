import java.util.*;

public class PatikaStore {

    // https://app.patika.dev/moduller/java-102/odev-patika-store

    static Scanner scanner = new Scanner(System.in);
    static List<MobileProduct> mobileProducts = new ArrayList<>();
    static List<NotebookProduct> notebookProducts = new ArrayList<>();

    public static void main(String[] args) {

        List<Group> groups = new ArrayList<>();
        groups.add(new Group("Mobiles"));
        groups.add(new Group("NoteBooks"));

        // Default Brand
        List<Brand> brands = Brand.createBrand();
        //Brand.print(brands);

        // Mobil default ürün listesi
        mobileProducts = MobileProduct.createMobileProduct(brands, groups.get(0));

        // Notebook default ürün listesi
        notebookProducts = NotebookProduct.createNotebookProduct(brands,groups.get(1));

        Brand selectedBrand;
        Group selectedGroup;
        String selectAction;
        System.out.println("Patika Store'a Hoşgeldiniz...");
        while(true){
            System.out.println("İşlemler : \t0-Çıkış\t1-Ürün Ekle\t2-Ürün Listele\t3-Ürün Sil");
            System.out.print("İşlem Seçiniz : ");
            selectAction = scanner.next();

            System.out.println();
            if(selectAction.equals("0")){
                break;
            }
            switch (selectAction){
                case "1":
                    selectedGroup = selectGroup(groups);
                    System.out.println();
                    selectedBrand = selectBrand(brands);
                    insertProduct(selectedGroup, selectedBrand);
                    break;
                case "2":
                    selectedGroup = selectGroup(groups);
                    listProduct(selectedGroup);
                    break;
                case "3":
                    removeProduct();
                    break;
                default:
                    System.out.println("Geçersiz İşlem");
                    break;
            }

        }
    }

    public static Group selectGroup(List<Group> groups){
        int selectGroup;
        System.out.println("Ürün için bir grup seçmelisiniz.");
        for (int i = 0; i < groups.size(); i++) {
            System.out.println((i+1) + "- "+ groups.get(i).getName());
        }
        System.out.print("Grup numarası giriniz : ");
        selectGroup = scanner.nextInt();
        selectGroup = selectGroup <= 0 ? 1 : selectGroup;
        selectGroup = selectGroup <= groups.size() ? selectGroup : 1;
        return groups.get(selectGroup - 1);
    }

    public static Brand selectBrand(List<Brand> brands){
        int selectBrand;
        System.out.println("Ürün için bir marka seçmelisiniz.");
        for (int i = 0; i < brands.size(); i++) {
            System.out.println((i+1) + "- "+ brands.get(i).getName());
        }
        System.out.print("Marka numarası giriniz : ");
        selectBrand = scanner.nextInt();
        selectBrand = selectBrand <= 0 ? 1 : selectBrand;
        selectBrand = selectBrand <= brands.size() ? selectBrand : 1;
        return brands.get(selectBrand - 1);
    }

    public static void insertProduct(Group group, Brand brand){
        Product newProduct;
        System.out.print("Ürün Adı : ");
        String name = scanner.nextLine();
        scanner.next();
        System.out.print("Ürün Fiyatı : ");
        double unitPrice = scanner.nextDouble();
        System.out.print("Ürün İndirim Oranı : ");
        double discountRate = scanner.nextDouble();
        System.out.print("Ürün Stok Adedi : ");
        int stockAmount = scanner.nextInt();
        System.out.print("Ürün Hafıza Kapasitesi : ");
        int memory = scanner.nextInt();
        System.out.print("Ürün Ekran Boyutu : ");
        double screen = scanner.nextDouble();
        System.out.print("Ürün Ram Kapasitesi : ");
        int ram = scanner.nextInt();
        System.out.print("Ürün Rengi : ");
        String color = scanner.nextLine();
        scanner.next();

        if(group.getName().equals("Mobiles")){
            System.out.print("Ürün Pil Bilgisi : ");
            double battery = scanner.nextDouble();
            mobileProducts.add(new MobileProduct(name,unitPrice,discountRate,stockAmount,brand,group,memory,screen,battery,ram,color));
        }else{
            notebookProducts.add(new NotebookProduct(name,unitPrice,discountRate,stockAmount,brand,group,memory,screen,ram,color));
        }
        System.out.println(name+" İsimli Ürün Eklendi.");
    }

    public static void listProduct(Group group){
        if(group.getName().equals("Mobiles")){
            System.out.format("%10s%40s%16s%16s%16s%16s%16s%16s%16s%16s","Ürün ID","Ürün Adı","Ürün Fiyatı","İndirim Oranı","Stok Adedi","Hafıza Boyutu","Ekran Boyutu","Ram Boyutu","Rengi","Batarya");
            System.out.println();
            for (MobileProduct product: mobileProducts) {
                System.out.format("%10s%40s%16s%16s%16s%16s%16s%16s%16s%16s",product.getId(),product.getName(),product.getUnitPrice(),product.getDiscountRate(),product.getStockAmount(), product.getMemory(),product.getScreen(),product.getRam(),product.getColor(),product.getBattery());
                System.out.println();
            }
        }else{
            System.out.format("%10s%40s%16s%16s%16s%16s%16s%16s%16s","Ürün ID","Ürün Adı","Ürün Fiyatı","İndirim Oranı","Stok Adedi","Hafıza Boyutu","Ekran Boyutu","Ram Boyutu","Rengi");
            System.out.println();
            for (NotebookProduct product: notebookProducts) {
                System.out.format("%10s%40s%16s%16s%16s%16s%16s%16s%16s",product.getId(),product.getName(),product.getUnitPrice(),product.getDiscountRate(),product.getStockAmount(), product.getMemory(),product.getScreen(),product.getRam(),product.getColor());
                System.out.println();
            }
        }

    }

    public static void removeProduct(){
        System.out.print("Ürün Id : ");
        String urunId = scanner.next();
        for (int i = 0; i < mobileProducts.size(); i++) {
            if(mobileProducts.get(i).getId().equals(urunId)){
                mobileProducts.remove(urunId);
                break;
            }
        }
        for (int i = 0; i < notebookProducts.size(); i++) {
            if(notebookProducts.get(i).getId().equals(urunId)){
                notebookProducts.remove(urunId);
                break;
            }
        }
        System.out.println("Ürün silindi");
    }

}
