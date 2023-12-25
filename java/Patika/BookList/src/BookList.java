import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BookList {

    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();
        Random random = new Random();
        int pageSize = random.nextInt(150);
        for (int i = 0; i < 10; i++) {
            books.add(new Book("Kitap-"+(i+1), pageSize,"Yazar-"+(i+1),"2020-01-02"));
            pageSize = random.nextInt(150);
        }

        System.out.println("Kitap ve Yazarlar");
        System.out.println();

        Map<String, String> bookMaps = new HashMap<>();
        books.forEach(book -> bookMaps.put(book.getBookName(), book.getWriterName()));

        for (Map.Entry<String, String> str: bookMaps.entrySet()) {
            System.out.println(str.getKey()+" : "+str.getValue());
        }

        System.out.println();
        System.out.println("100 sayfadan fazla sayfası olan kitaplar.");
        System.out.println();

        ArrayList<Book> newList = new ArrayList<>();
        books.stream().filter(book-> book.getPageSize() > 100).forEach(newList::add);

        newList.forEach(book -> System.out.println(book.getBookName()+" "+book.getPageSize()));

    }
}
