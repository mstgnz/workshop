package Models;

public class Content {
    private int id;
    private int courseId;
    private String title;
    private String content;
    private String link;

    public Content() { }

    public Content(int id, int courseId, String title, String content, String link) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
        this.content = content;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
