package com.ethoca.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;


    static {

        String path = "configuration.properties";
        try {
            FileInputStream stream = new FileInputStream(path);
            properties = new Properties();

                properties.load(stream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
