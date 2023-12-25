package Controllers;

import Helpers.DB;
import Helpers.Query;
import Models.Patika;
import Models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class PatikaController {

    private final Query query;

    public PatikaController(Query query) {
        this.query = query;
    }

    public ArrayList<Patika> getPatikaList(){
        ArrayList<Patika> patikaArrayList = new ArrayList<>();
        try {
            Statement statement = Objects.requireNonNull(DB.getInstance()).createStatement();
            ResultSet result = statement.executeQuery(this.query.select("patika","*").get());
            while (result.next()){
                patikaArrayList.add(new Patika(result.getInt("id"), result.getString("name")));
            }
            statement.close();
            result.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return patikaArrayList;
    }

    public boolean addPatika(String name){
        boolean result = true;
        try {
            String[] patika = {"name"};
            PreparedStatement preparedStatement  = Objects.requireNonNull(DB.getInstance()).prepareStatement(this.query.insert("patika",patika).get());
            preparedStatement.setString(1, name);
            int prepareResult = preparedStatement.executeUpdate();
            result = prepareResult != -1;
            preparedStatement.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

    public Patika getPatika(String name){
        Patika patika = null;
        try {
            PreparedStatement preparedStatement = DB.getInstance().prepareStatement(this.query.select("patika","*").where("name","=","?").get());
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                patika = new Patika(resultSet.getInt("id"), resultSet.getString("name"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return patika;
    }

    public Patika getPatika(int id){
        Patika patika = null;
        try {
            PreparedStatement preparedStatement = DB.getInstance().prepareStatement(this.query.select("patika","*").where("id","=","?").get());
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                patika = new Patika(resultSet.getInt("id"), resultSet.getString("name"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return patika;
    }

    public boolean updatePatika(int id, String name){
        try {
            Map<String,String> updateData = new HashMap<>();
            updateData.put("name", name);
            PreparedStatement preparedStatement = DB.getInstance().prepareStatement(this.query.update("patika", updateData).where("id","=","?").get());
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return true;
    }

    public boolean deletePatika(String name){
        try {
            PreparedStatement preparedStatement = DB.getInstance().prepareStatement(this.query.delete("patika").where("name","=","?").get());
            preparedStatement.setString(1, name);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return true;
    }
}
