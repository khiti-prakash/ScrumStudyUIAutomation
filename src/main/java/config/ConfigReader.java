package config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try{
            String path = System.getProperty("user.dir")
                    + File.separator + "src"
                    + File.separator + "test"
                    + File.separator + "resources"
                    + File.separator + "config"
                    + File.separator + "config.properties";
           FileInputStream input = new FileInputStream(path);
          properties = new Properties();
            properties.load(input);
        }
        catch (Exception e){
            e.printStackTrace();
            throw  new ExceptionInInitializerError("Failed to load config.properties");
        }
    }
    // it will return value
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
