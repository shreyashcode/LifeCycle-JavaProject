import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Trial{
    public static void trial(){

        // Shikhar's part
        double Calories = CaloriesConsumption.getCaloriesConsumed();
        System.out.println(Calories);

        // Suraj's part
        double reqCals = CurrentUser.user.calculateMaintanenceCalories();

        System.out.println("ReqCals: " + reqCals);

        try {
            Connection connection = Database.initDb();
            Statement statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String query = "select * from management where ";

        if(Math.abs(reqCals-Calories) <= 100){
            System.out.println("Hurry! Enjoy your day..............");
        } else if(Calories < reqCals){
            System.out.println("You lack in calories. Try eating these food items to reach your GOAL.......");

            show(MainClass.getFoodItems(reqCals-Calories), false);
        } else {
            System.out.println("You have exceeded the calories count. Try out these exercise to reach your GOAL.......");

            show(MainClass.getExercises(Calories-reqCals), true);
        }
    }

    public static <T> void show(ArrayList<T> arrayList, boolean flag) {
        boolean first = false;
        for(T k: arrayList) {
            if(flag && first){
                System.out.println("\t\t---------OR---------");
            }
            first = true;
            System.out.println(k);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
