import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Intro {
    public static void main(String[] args) {

        // Nothing related to our assignment......

        String greeting = "Good";
        DateTimeFormatter dtf = DateTimeFormatter
                .ofPattern("HH");
        LocalDateTime now = LocalDateTime.now();
        int hr = Integer.parseInt(dtf.format(now));

        if(hr >= 16){
            System.out.print(greeting + " Evening");
        } else if (hr >= 12){
            System.out.print(greeting + " After Noon");
        } else {
            System.out.print(greeting + " Morning");
        }
        System.out.println(" Ma'am");


        String rollNo = "74 87 91";
        String marks = "?";

    }
}