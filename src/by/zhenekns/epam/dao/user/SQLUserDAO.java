package by.zhenekns.epam.dao.user;

public class SQLUserDAO implements UserDAO {
    @Override
    public void registration(String username, String password) {
        System.out.println("Username: " + username + "\nPassword: " + password);
    }
}
