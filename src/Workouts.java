import java.text.DecimalFormat;

public class Workouts {
    protected String name;
    protected int time;
    protected double Calories;

    public Workouts(String name, int time, double calories) {
        this.name = name;
        this.time = time;
        Calories = calories;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("###.###");
        int hr = time/60;
        int min = time%60;
        if(hr != 0){
            return "Do " + name + " for "+ hr + " Hrs, " + min +" minutes and burn " + df.format(this.Calories) + " calories!";
        }
        return "Do " + name + " for "+ time +" minutes and burn " + df.format(this.Calories) + " calories!";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getCalories() {
        return Calories;
    }

    public void setCalories(double calories) {
        Calories = calories;
    }
}
