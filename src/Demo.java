import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i <= 6; i++){
            String name = sc.next();
            int time = sc.nextInt();
            double cal = sc.nextDouble();
            System.out.println("('" + name + "', " + time + ", "+cal+")");
        }
    }
}