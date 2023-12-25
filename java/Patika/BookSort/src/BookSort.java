import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class BookSort {

    public static void main(String[] args) {

        Set<Book> books = new HashSet<>();
        books.add(new Book("Fareler ve İnsanlar",123, "John Steinbeck","2021-11-01"));
        books.add(new Book("Simyacı",234, "Paulo Coelho","2021-11-01"));
        books.add(new Book("Fahrenheit 451",123, "Ray Bradbury","2021-11-01"));
        books.add(new Book("Dinle Küçük Adam",123, "Wilhelm Reich","2021-11-01"));
        books.add(new Book("Bülbülü Öldürmek",123, "Harper Lee","2021-11-01"));

        Queue<Book> queueBooks = new PriorityQueue<>(books);

        while (!queueBooks.isEmpty()){
            System.out.println(queueBooks.poll().getName());
        }


    }
}