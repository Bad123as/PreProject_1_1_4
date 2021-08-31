package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.util.Util;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();
        List<User> users = new ArrayList<>();
        users.add(new User("Sergey", "Sergeev", (byte) 20));
        users.add(new User("Andrey", "Andreev", (byte) 30));
        users.add(new User("Anton", "Antonov", (byte) 40));
        users.add(new User("Maksim", "Maksimov", (byte) 50));

        userService.createUsersTable();
        for (User u : users) {
            userService.saveUser(u.getName(),u.getLastName(), u.getAge());
            System.out.println("User с именем - ".concat(u.getName()).concat(" добавлен в базу данных"));
        }
        List<User> allUsers = userService.getAllUsers();
        for (User u : allUsers) {
            System.out.println(u.toString());
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
