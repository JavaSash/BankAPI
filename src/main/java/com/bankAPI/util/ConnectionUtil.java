package com.bankAPI.util;

import com.bankAPI.Config;
import com.bankAPI.exception.BankApiException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static final Config config = Config.getInstance();

    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(config.getUrl(), config.getLogin(), config.getPassword());
        } catch (SQLException e) {
            throw new BankApiException("Connection failed");
        }
        return connection;
    }
}
