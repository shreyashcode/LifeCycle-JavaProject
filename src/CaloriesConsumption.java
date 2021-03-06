import com.sun.tools.javac.Main;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CaloriesConsumption {
    public static double getCaloriesConsumed(){
        double CaloriesConsumed=0;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_items", "root", "1234");
            stmt = conn.createStatement();
            String query = "select * from foodItems";
            rs = stmt.executeQuery(query);
            ArrayList<FoodItem> LofFoodItems = new ArrayList<>();

            while (rs.next()) {
                String item = rs.getString(1);
                int quantity= rs.getInt(2);
                int calories= rs.getInt(3);
                FoodItem foodItem = new FoodItem(item,quantity,calories);
                LofFoodItems.add(foodItem);
            }
            Scanner scanner= new Scanner(System.in);

            System.out.println();
            boolean userChoosing=true;
            while (userChoosing) {
                System.out.println("Choose the food items: ");
                int index=1;
                for (FoodItem food : LofFoodItems) {
                    System.out.println("Enter "+index+" to choose "+food.name);
                    index++;
                }
                System.out.println("Enter 0 to exit");
                int userChoice= scanner.nextInt();
                if (userChoice==0){
                    userChoosing=false;
                    break;
                }
                if(userChoice>0 && userChoice<=LofFoodItems.size()) {
                    FoodItem foodItemToGetCal = LofFoodItems.get(userChoice-1);
                    if(foodItemToGetCal.getQty() == 1){
                        System.out.println("Enter units consumed");
                    } else {
                        System.out.println("Enter Quantity as per 100 gms");
                    }
                    int quantity=scanner.nextInt();
                    CaloriesConsumed+= foodItemToGetCal.getCalorieValue()*quantity;
                }else{
                    System.out.println("Enter proper item please....");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Exception occurred while releasing resources");
            }
        }
        return CaloriesConsumed;
    }
}