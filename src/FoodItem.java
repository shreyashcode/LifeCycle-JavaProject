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
        return "Name: " + this.getName() + "\t Qty: " + this.getQty() + "\t Calories: " + this.getCalorieValue();
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
