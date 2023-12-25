public class Book implements  Comparable<Book>{

    private String name;
    private int page;
    private String writer;
    private String date;

    public Book(String name, int page, String writer, String date) {
        this.name = name;
        this.page = page;
        this.writer = writer;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int compareTo(Book book) {
        if(this.name.charAt(0) > book.name.charAt(0)){
            return 1;
        }else if(this.name.charAt(0) < book.name.charAt(0)){
            return -1;
        }
        return 0;
    }
}
