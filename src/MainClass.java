import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MainClass {
    public static Connection connection = null;
    public static Statement statement = null;
    public static ResultSet resultSet = null;
    public static void main(String[] args) {
        showFood(getFoodItems(100.0));
        System.out.println();
        showFood(getFoodItems(200.0));
        System.out.println();
    }

    public static void showFood(ArrayList<FoodItem> foodItems) {
        for(FoodItem foodItem: foodItems) {
            System.out.println(foodItem);
        }
    }

    public static ArrayList<FoodItem> getFoodItems(Double CalValue){
        ArrayList<FoodItem> foodItems = new ArrayList<>();
        try {
            setupDB();
            String query = "select * from fooditems";
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String name = resultSet.getString(1);
                int qty = resultSet.getInt(2);
                double cal = resultSet.getDouble(3);
                foodItems.add(new FoodItem(name, qty, cal));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        double hasCalorie = 0;
        Collections.sort(foodItems);
        ArrayList<FoodItem> finalFooditems = new ArrayList<>();
        for(FoodItem foodItem: foodItems) {
            if(hasCalorie >= CalValue) {
                break;
            }
            hasCalorie += foodItem.getCalorieValue();
            finalFooditems.add(foodItem);
        }
        if(finalFooditems.isEmpty()) {
            finalFooditems.add(foodItems.get(0));
        }
        return finalFooditems;
    }

    public static void setupDB() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_items", "root", "1234");
        statement = connection.createStatement();
    }
}