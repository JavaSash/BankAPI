package com.bankAPI.util;

import com.bankAPI.Config;
import com.bankAPI.exception.BankApiException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
//TODO: разобраться почему Конфиг не читает данные из пропертей

//    private static Config config = Config.getInstance();
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                return connection;
            } else {
//                String url = config.getUrl();
//                String login = config.getLogin();
//                String pass = config.getPassword();

                String url = "jdbc:h2:/Users/a19556394/IdeaProjects/webApp/db/Bank_Accounts";
                String login = "bank_user";
                String pass = "sberbank";
                Class.forName("org.h2.Driver");
                connection = DriverManager.getConnection(url, login, pass);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BankApiException("Connection failed");
        }
        return connection;
    }
}