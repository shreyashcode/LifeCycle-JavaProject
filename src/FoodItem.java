import java.text.DecimalFormat;

public class FoodItem implements Comparable<FoodItem> {
    protected String name;
    protected int Qty;
    protected double CalorieValue;

    public FoodItem(String name, int qty, double calorieValue) {
        this.name = name;
        Qty = qty;
        CalorieValue = calorieValue;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return Qty;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("###.###");
        String emp;
        if(this.getQty() == 1){
            emp = " ";
        } else {
            emp = " grams of ";
        }
        return "Eat " + this.getQty() + emp + this.getName() + " to get " + df.format(this.getCalorieValue()) + " calories!";
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public double getCalorieValue() {
        return CalorieValue;
    }

    public void setCalorieValue(double calorieValue) {
        CalorieValue = calorieValue;
    }

    @Override
    public int compareTo(FoodItem o) {
        return (int) (this.getCalorieValue()-o.getCalorieValue());
    }
}
