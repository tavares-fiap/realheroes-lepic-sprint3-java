package Controller;

public class DataBaseConfig_DB {

    private static String url = "jdbc:mysql://localhost/REALHEROES";
    private static String username = "root";
    private static String password = "";

    public static String getUrl() {
        return url;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

}
