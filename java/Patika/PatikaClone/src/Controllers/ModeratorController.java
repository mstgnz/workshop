package Controllers;

import Helpers.DB;
import Helpers.Query;
import Models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ModeratorController {

    private final User user;
    private final Query query;

    public ModeratorController(User user, Query query) {
        this.user = user;
        this.query = query;
    }

    public ArrayList<User> getUserList(){
        ArrayList<User> users = new ArrayList<>();
        try {
            Statement statement = Objects.requireNonNull(DB.getInstance()).createStatement();
            ResultSet result = statement.executeQuery(this.query.select("users","*").get());
            User user;
            while (result.next()){
                user = new User();
                user.setId(result.getInt("id"));
                user.setFirstname(result.getString("firstname"));
                user.setLastname(result.getString("lastname"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                user.setType(result.getString("type"));
                users.add(user);
            }
            statement.close();
            result.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return users;
    }

    public boolean addUser(String fullname, String email, String password, String type){
        boolean result = true;
        type = type.isEmpty() ? "student" : type;
        try {
            String[] users = {"firstname","lastname","email","password","type"};
            PreparedStatement preparedStatement  = Objects.requireNonNull(DB.getInstance()).prepareStatement(this.query.insert("users",users).get());
            preparedStatement.setString(1, fullname.split(" ")[0]);
            preparedStatement.setString(2, fullname.split(" ")[1]);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, type);
            int prepareResult = preparedStatement.executeUpdate();
            result = prepareResult != -1;
            preparedStatement.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

    public User getUser(String email){
        User user = null;
        try {
            PreparedStatement preparedStatement = DB.getInstance().prepareStatement(this.query.select("users","*").where("email","=","?").get());
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstname(resultSet.getString("firstname"));
                user.setLastname(resultSet.getString("lastname"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setType(resultSet.getString("type"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return user;
    }

    public User getUser(int id){
        User user = null;
        try {
            PreparedStatement preparedStatement = DB.getInstance().prepareStatement(this.query.select("users","*").where("id","=","?").get());
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstname(resultSet.getString("firstname"));
                user.setLastname(resultSet.getString("lastname"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setType(resultSet.getString("type"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return user;
    }

    public boolean deleteUser(int id){
        try {
            PreparedStatement preparedStatement = DB.getInstance().prepareStatement(this.query.delete("users").where("id","=","?").get());
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    public boolean updateUser(int id, String fullName, String email, String type){
        String[] types = {"moderator","educator","student"};
        try {
            Map<String,String> updateData = new HashMap<>();
            updateData.put("firstname", fullName.split(" ")[0]);
            updateData.put("lastname", fullName.split(" ")[1]);
            updateData.put("email",email);
            if(Arrays.asList(types).contains(type)){
                updateData.put("type",type);
            }
            //System.out.println(this.query.update("users", updateData).where("id","=","?").get());
            PreparedStatement preparedStatement = DB.getInstance().prepareStatement(this.query.update("users", updateData).where("id","=","?").get());
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return true;
    }

    public ArrayList<User> searchUserList(String email, String fullName, String type){

        String[] fullNameArgs = fullName.split(" ");
        String firstname = fullNameArgs[0];
        String lastname = fullNameArgs.length > 1 ? fullNameArgs[1] : "";

        ArrayList<User> users = new ArrayList<>();
        try {
            Statement statement = Objects.requireNonNull(DB.getInstance()).createStatement();
            String query = this.query.select("users","*")
                    .where("email","LIKE","'%"+email+"%'")
                    .where("firstname","LIKE","'%"+firstname+"%'")
                    .where("lastname","LIKE","'%"+lastname+"%'")
                    .where("type","LIKE","'%"+type+"%'")
                    .get();
            System.out.println(query);
            ResultSet result = statement.executeQuery(query);
            User user;
            while (result.next()){
                user = new User();
                user.setId(result.getInt("id"));
                user.setFirstname(result.getString("firstname"));
                user.setLastname(result.getString("lastname"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                user.setType(result.getString("type"));
                users.add(user);
            }
            statement.close();
            result.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return users;
    }

}
