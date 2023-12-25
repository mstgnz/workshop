package Controllers;

import Helpers.DB;
import Helpers.Query;
import Models.Content;
import Models.Course;
import Models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

public class EducatorController {

    private final User user;
    private final Query query;

    public EducatorController(User user, Query query) {
        this.user = user;
        this.query = query;
    }

    public ArrayList<Course> getCourseList() {
        ArrayList<Course> courses = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DB.getInstance().prepareStatement(this.query.select("courses","*").where("user_id","=","?").get());
            preparedStatement.setInt(1, this.user.getId());
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                courses.add(new Course(result.getInt("id"), result.getInt("user_id"), result.getInt("patika_id"), result.getString("name"), result.getString("language")));
            }
            preparedStatement.close();
            result.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return courses;
    }

    // İçerik Ekle
    public int addToContent(int courseId, String title, String content, String link) {
        try {
            String[] contents = {"user_id","course_id","title","content","link"};
            PreparedStatement preparedStatement = Objects.requireNonNull(DB.getInstance()).prepareStatement(this.query.insert("contents",contents).get(), Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, this.user.getId());
            preparedStatement.setInt(2, courseId);
            preparedStatement.setString(3, title);
            preparedStatement.setString(4, content);
            preparedStatement.setString(5, link);
            int prepareResult = preparedStatement.executeUpdate();
            boolean result = prepareResult != -1;
            if(result){
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if(rs.next()) {
                    return rs.getInt(1);
                }
            }
            preparedStatement.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return -1;
    }

    // Soru Ekle
    public boolean addToQuiz(int contentId, String question, String a, String b, String c, String d, String answer) {
        boolean result = true;
        System.out.println(contentId);
        System.out.println(answer);
        try {
            String[] contents = {"content_id","question","a","b","c","d","answer"};
            PreparedStatement preparedStatement = DB.getInstance().prepareStatement(this.query.insert("quiz",contents).get());
            preparedStatement.setInt(1, contentId);
            preparedStatement.setString(2, question);
            preparedStatement.setString(3, a);
            preparedStatement.setString(4, b);
            preparedStatement.setString(5, c);
            preparedStatement.setString(6, d);
            preparedStatement.setString(7, answer);
            int prepareResult = preparedStatement.executeUpdate();
            result = prepareResult != -1;
            preparedStatement.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

    // İçerik Listesi
    public ArrayList<Content> getContentList() {
        ArrayList<Content> contents = new ArrayList<>();
        try {
            Statement statement = Objects.requireNonNull(DB.getInstance()).createStatement();
            PreparedStatement preparedStatement = DB.getInstance().prepareStatement(this.query.select("contents","*").where("user_id","=","?").get());
            preparedStatement.setInt(1, this.user.getId());
            ResultSet result = preparedStatement.executeQuery();
            Content content;
            while (result.next()){
                content = new Content();
                content.setId(result.getInt("id"));
                content.setTitle(result.getString("title"));
                content.setContent(result.getString("content"));
                content.setLink(result.getString("link"));
                contents.add(content);
            }
            statement.close();
            result.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return contents;
    }
}
