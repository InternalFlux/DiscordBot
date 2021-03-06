package bluebot.utils;

import java.io.*;
import java.util.Properties;

/**
 * @file LoadingProperties.java
 * @author Blue
 * @version 0.1
 * @brief Loads a config file to launch the bot.
 */

public class LoadingProperties {
    private String botToken;
    private String botActivity;
    private String steamAPIKey;
    private String cleverbotAPIKey;

    public String getCleverbotAPIKey() {return cleverbotAPIKey;}
    public String getBotToken() {
        return botToken;
    }
    public String getSteamAPIKey() {return steamAPIKey;}
    public String getBotActivity() {
        return botActivity;
    }

    public LoadingProperties() {
        try {
            File configFile = new File("config.blue");
            FileInputStream fileInput = new FileInputStream(configFile);
            Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();

            botToken = properties.getProperty("botToken");
            botActivity = properties.getProperty("botActivity");
            cleverbotAPIKey = properties.getProperty("cleverbotAPIKey");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
