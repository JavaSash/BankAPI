package com.bankAPI;

import java.io.*;
import java.util.Properties;

/**
 * Класс для загрузки properties проекта
 */
public class Config {
    private static final File PROPERTIES = new File("src/main/resources/bankAPI.properties");
    private static final Config INSTANCE = new Config();
    private Properties props = new Properties();
    private static String url;
    private static String login;
    private static String password;

    private Config() {
        try(InputStream inputStream = new FileInputStream(PROPERTIES)) {
            props.load(inputStream);
            url = props.getProperty("db.url");
            login = props.getProperty("db.login");
            password = props.getProperty("db.password");
        } catch (IOException e) {
            throw new IllegalStateException("Invalid config file " + PROPERTIES.getAbsolutePath());
        }
    }

    public static Config getInstance() {
        return INSTANCE;
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
