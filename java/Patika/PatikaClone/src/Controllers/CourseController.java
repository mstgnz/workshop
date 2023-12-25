package Controllers;

import Helpers.DB;
import Helpers.Query;
import Models.Course;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CourseController {

    private final Query query;
    private final PatikaController patikaController;
    private final ModeratorController moderatorController;


    public CourseController(Query query, PatikaController patikaController, ModeratorController moderatorController) {
        this.query = query;
        this.patikaController = patikaController;
        this.moderatorController = moderatorController;
    }

    public ArrayList<Course> gerCourseList(){
        ArrayList<Course> courses = new ArrayList<>();
        try {
            Statement statement = Objects.requireNonNull(DB.getInstance()).createStatement();
            ResultSet result = statement.executeQuery(this.query.select("courses","*").get());
            while (result.next()){
                Course course = new Course();
                course.setId(result.getInt("id"));
                course.setUserId(result.getInt("user_id"));
                course.setPatikaId(result.getInt("patika_id"));
                course.setName(result.getString("name"));
                course.setLanguage(result.getString("language"));
                course.setPatika(this.patikaController.getPatika(result.getInt("patika_id")));
                course.setUser(this.moderatorController.getUser(result.getInt("user_id")));
                courses.add(course);
            }
            statement.close();
            result.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return courses;
    }

    public boolean addCourse(String name, String lang, int patikaId, int userId){
        boolean result = true;
        try {
            String[] course = {"user_id","patika_id","name","language"};
            PreparedStatement preparedStatement  = Objects.requireNonNull(DB.getInstance()).prepareStatement(this.query.insert("courses",course).get());
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, patikaId);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, lang);
            int prepareResult = preparedStatement.executeUpdate();
            result = prepareResult != -1;
            preparedStatement.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return result;
    }


    public Course getCourse(String name){
        Course course = null;
        try {
            PreparedStatement preparedStatement = Objects.requireNonNull(DB.getInstance()).prepareStatement(this.query.select("courses","*").where("name","=","?").get());
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                course.setId(resultSet.getInt("id"));
                course.setPatikaId(resultSet.getInt("patika_id"));
                course.setUserId(resultSet.getInt("user_id"));
                course.setName(resultSet.getString("name"));
                course.setLanguage(resultSet.getString("language"));
                course.setUser(this.moderatorController.getUser(resultSet.getInt("user_id")));
                course.setPatika(this.patikaController.getPatika(resultSet.getInt("patika_id")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return course;
    }



    public boolean updateCourse(int id, String name, String lang){
        try {
            Map<String,String> updateData = new HashMap<>();
            updateData.put("name", name.replace("'","`"));
            updateData.put("language", lang.replace("'","`"));
            System.out.println(id);
            System.out.println(this.query.update("courses", updateData).where("id","=","?").get());
            PreparedStatement preparedStatement = Objects.requireNonNull(DB.getInstance()).prepareStatement(this.query.update("courses", updateData).where("id","=","?").get());
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return true;
    }

    public boolean deleteCourse(int id){
        try {
            PreparedStatement preparedStatement = Objects.requireNonNull(DB.getInstance()).prepareStatement(this.query.delete("courses").where("id","=","?").get());
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return true;
    }
}
