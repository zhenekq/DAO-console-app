import by.zhenekns.epam.dao.DAOFactory;
import by.zhenekns.epam.dao.database.DatabaseDAO;
import by.zhenekns.epam.dao.user.UserDAO;
import by.zhenekns.epam.entity.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        DatabaseDAO mysql = daoFactory.getMysql();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        mysql.connect();
        mysql.add(new User(username, password));
    }
}