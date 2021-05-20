package by.zhenekns.epam.dao;

import by.zhenekns.epam.dao.database.DatabaseDAO;
import by.zhenekns.epam.dao.database.MySQL;
import by.zhenekns.epam.dao.user.SQLUserDAO;
import by.zhenekns.epam.dao.user.UserDAO;

public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();
    private final UserDAO sqlUserImpl = new SQLUserDAO();
    private final DatabaseDAO mysql = new MySQL();

    private DAOFactory(){}
    public static DAOFactory getInstance(){
        return instance;
    }

    public DatabaseDAO getMysql(){
        return mysql;
    }

    public UserDAO getUserDAO(){
        return sqlUserImpl;
    }
}
