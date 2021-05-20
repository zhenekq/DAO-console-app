package by.zhenekns.epam.dao.database;

import by.zhenekns.epam.entity.User;

public interface DatabaseDAO<Entity> {
    void connect();
    void add(User user);
}
