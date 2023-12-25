package Controllers;

import Helpers.DB;
import Helpers.Query;
import Models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    private final Query query;

    public LoginController(Query query) {
        this.query = query;
    }

    public User login(String email, String password){
        User user = null;
        try {
            PreparedStatement preparedStatement = DB.getInstance().prepareStatement(this.query.select("users","*").where("email","=","?").where("password","=","?").get());
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
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


}
