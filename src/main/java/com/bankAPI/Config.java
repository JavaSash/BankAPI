package com.bankAPI;

import java.io.*;
import java.util.Properties;

/**
 * Класс для загрузки properties проекта
 */
public class Config {
    private static final File PROPERTIES = new File("bankAPI.properties");
    private static Config instance;
    private Properties props = new Properties();
    private static String url;
    private static String login;
    private static String password;
//TODO: разобраться почему не запускается конекшн с конфигом
    private Config() {
        try (InputStream inputStream = new FileInputStream(PROPERTIES)) {
            props.load(inputStream);
            url = props.getProperty("db.url");
            login = props.getProperty("db.login");
            password = props.getProperty("db.password");
        } catch (IOException e) {
            throw new IllegalStateException("Invalid config file " + PROPERTIES.getAbsolutePath());
        }
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public static String getUrl() {
        return url;
    }

    public static String getLogin() {
        return login;
    }

    public static String getPassword() {
        return password;
    }
}
