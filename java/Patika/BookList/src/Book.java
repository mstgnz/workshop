public class Book {
    private String bookName;
    private int pageSize;
    private String writerName;
    private String publishDate;

    public Book(String bookName, int pageSize, String writerName, String publishDate) {
        this.bookName = bookName;
        this.pageSize = pageSize;
        this.writerName = writerName;
        this.publishDate = publishDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
