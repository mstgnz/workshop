package Controllers;

import Helpers.DB;
import Helpers.Query;
import Models.Content;
import Models.Course;
import Models.Quiz;
import Models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

public class StudentController {

    private final User user;
    private final Query query;

    public StudentController(User user, Query query) {
        this.user = user;
        this.query = query;
    }

    public ArrayList<Course> getCourseList(int patikaId) {
        ArrayList<Course> courses = new ArrayList<>();
        try {
            Statement statement = Objects.requireNonNull(DB.getInstance()).createStatement();
            PreparedStatement preparedStatement = DB.getInstance().prepareStatement(this.query.select("courses","*").where("patika_id","=","?").get());
            preparedStatement.setInt(1, patikaId);
            ResultSet result = preparedStatement.executeQuery();
            Course course;
            while (result.next()){
                course = new Course();
                course.setId(result.getInt("id"));
                course.setUserId(result.getInt("user_id"));
                course.setPatikaId(result.getInt("patika_id"));
                course.setName(result.getString("name"));
                course.setLanguage(result.getString("language"));
                courses.add(course);
            }
            statement.close();
            result.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return courses;
    }

    public Content getContent(int selected_course_id) {
        Content content = null;
        try {
            Statement statement = Objects.requireNonNull(DB.getInstance()).createStatement();
            PreparedStatement preparedStatement = DB.getInstance().prepareStatement(this.query.select("contents","*").where("course_id","=","?").get());
            preparedStatement.setInt(1, selected_course_id);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                content = new Content();
                content.setId(result.getInt("id"));
                content.setTitle(result.getString("title"));
                content.setContent(result.getString("content"));
                content.setLink(result.getString("link"));
            }
            statement.close();
            result.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return content;
    }

    public Quiz getQuiz(int contentId){
        Quiz quiz = null;
        try {
            Statement statement = Objects.requireNonNull(DB.getInstance()).createStatement();
            PreparedStatement preparedStatement = DB.getInstance().prepareStatement(this.query.select("quiz","*").where("content_id","=","?").get());
            preparedStatement.setInt(1, contentId);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                quiz = new Quiz();
                quiz.setId(result.getInt("id"));
                quiz.setQuestion(result.getString("question"));
                quiz.setA(result.getString("a"));
                quiz.setB(result.getString("b"));
                quiz.setC(result.getString("c"));
                quiz.setD(result.getString("d"));
                quiz.setAnswer(result.getString("answer"));
            }
            statement.close();
            result.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return quiz;
    }
}
