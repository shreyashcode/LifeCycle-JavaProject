
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Registration {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Welcome the MyFitness");
        System.out.println("Enter 1 to Login\nEnter 2 to Register");
        int n = sc.nextInt();
        if(n==1){
            login();
        }
        else if(n==2){
            register();
        }
    }

    private static void register() throws SQLException, ClassNotFoundException {

        System.out.println("Welcome to the Registeration Page");
        System.out.println("Enter name");
        String name = sc.next();
        System.out.println("Enter Phone Number as Username");
        String username = sc.next();
        System.out.println("Enter Your Weight");
        Double weight = sc.nextDouble();
        System.out.println("Enter Your Height");
        Double height = sc.nextDouble();
        System.out.println("Enter Your Gender :\n1 for Female\n2 for male");
        int n = sc.nextInt();
        boolean gender = true;
        if(n==2){
            gender = false;
        }
        System.out.println("Enter 1 for Weight Gain\nEnter 2 for Weight Loss");
        int m = sc.nextInt();
        boolean target = true;
        if(n==2){
            target = false;
        }
        System.out.println("Enter Your Password");
        String password = sc.next();
        User currentUser = new User(name,username,password);
        currentUser.setTarget(target);
        currentUser.setGender(gender);
        currentUser.setHeight(height);
        currentUser.setWeight(weight);

        CurrentUser.user = currentUser;

        double maintenanceCalories = currentUser.calculateMaintanenceCalories();

        //register the user into the database ( login table as well as management table )
        String uLoginQuery = "insert into login values(" + "'"+username + "'" + ","+ "'"+ password +"'"+ ")";
        Connection con = Database.initDb();
        Statement st = con.createStatement();
        // login query
        st.executeUpdate(uLoginQuery);

        //management query
        String uManagementQuery = "insert into management values("+ "'" +username + "'" + "," + "'" + name + "'" + "," + height + "," + weight + "," + gender + "," + maintenanceCalories + "," + target +")";
        st.executeUpdate(uManagementQuery);

        System.out.println("Registration Succesfull");
        login();
    }

    private static void login() throws SQLException, ClassNotFoundException {
        System.out.println("Enter Phone number as Username.....");
        String username = sc.next();
        System.out.println("Enter Password");
        String password = sc.next();

        Connection connection = Database.initDb();
        Statement statement = connection.createStatement();

        String query  = "select * from management where username = "+ "'"+ username +"'";
        ResultSet resultSet = statement.executeQuery(query);
//        if(!resultSet.next()){
//            System.out.println("User not found! Credentials invalid.........");
//            login();
//            return;
//        }
        CurrentUser.user = new User();
        resultSet.next();
        CurrentUser.user.setGender(resultSet.getBoolean(5));
        CurrentUser.user.setUsername(username);
        CurrentUser.user.setWeight(resultSet.getDouble(4));
        CurrentUser.user.setHeight(resultSet.getDouble(3));
        CurrentUser.user.setName(resultSet.getString(2));
        CurrentUser.user.setTarget(resultSet.getBoolean(7));
        //check if user exits in the database
        boolean isValidUser = isValidUser(username,password);

        if(isValidUser){
            System.out.println("Login Successful");
//            CurrentUser.user.
            Trial.trial();
        }
        else{
            System.out.println("Not a User ! Register First");
            register();
        }
    }

    private static boolean isValidUser(String username,String password) throws SQLException, ClassNotFoundException {
        //Fetch from database
        String loginQuery = "select * from login";
        Connection con = Database.initDb();
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery(loginQuery);
        while(res.next()){
            String un = res.getString(1);
            String pass = res.getString(2);
            if(un.equals(username) && pass.equals(password)){
                return true;
            }
        }
        return false;
    }
}

