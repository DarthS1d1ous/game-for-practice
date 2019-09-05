package com.practice.summer.model.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    private ResourceBundle resource = ResourceBundle.getBundle("database");
    private String url = resource.getString("db.url");
    private String user = resource.getString("db.user");
    private String password = resource.getString("db.password");

    private DatabaseConnection() throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }
}