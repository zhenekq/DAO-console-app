package by.zhenekns.epam.dao.database;

import by.zhenekns.epam.entity.User;
import java.sql.*;

public class MySQL implements DatabaseDAO<User> {

    //--DATABASE DATA TO CONNECT--
    private static final String URL = "jdbc:mysql://localhost:3306/console_app?autoReconnect=true&useSSL=FALSE&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USERNAME = "admin_zhenekns";
    private static final String PASSWORD = "em50475047";

    @Override
    public void connect() {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            System.out.println("Driver is good");
        }catch (SQLException e){
            System.out.println("Database is not connected!");
        }
    }

    @Override
    public void add(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement()){
            statement.addBatch("INSERT INTO users(username, password)" +
                    " VALUES ('" + username + "', '" + password + "')");
            statement.executeBatch();
            System.out.println("User with USERNAME ->" + username + " and PASSWORD -> " + password + "has been added");
        }catch (SQLException ex){
            System.out.println("User not added!");
        }
    }

}
