
public class User {
    private String name;
    private String username;
    private String password;

    private double height;
    private double weight;
    private boolean gender;
    private boolean target;


    public User(){
    }


    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public double calculateMaintanenceCalories() {
        double cals;
        if (gender) {
            //female
            cals = 24 * 0.9 * weight * 1.3 * 10;
        } else {
            //male
            cals = 24 * 0.1 * weight * 1.3 * 10;
        }
        if(target){
            cals += 500.0;
        } else {
            cals = Math.max(0, cals-500.0);
        }
        return cals;
    }


    //getters
    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isGender() {
        return gender;
    }

    public boolean isTarget() {
        return target;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setGender(boolean gender) {
        this.gender = gender;
    }
    public void setTarget(boolean target) {
        this.target = target;
    }


}