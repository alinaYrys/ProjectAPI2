package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    private static ConfigReader configReader;
    private  String path="src/test/resources/configurations/configurations.properties";

    private ConfigReader(){
        BufferedReader reader;
        try {
            reader=new BufferedReader(new FileReader(path));
            properties=new Properties();
            try {
                properties.load(reader);
                reader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException("Configuration properties file not at "+path);
        }

    }
    public static ConfigReader getInstance(){
        if(configReader==null){
            configReader=new ConfigReader();
        }
        return configReader;
    }
    /*
    This method will call url from configuration file
     */
    public String getUrl(){
        String url= properties.getProperty("baseURL");
        if (url!=null) return url;
        else throw new RuntimeException("API Url not specified in Configuration file");
    }
    /*
    This method will call token base path from configuration file
     */
    public String getTokenBasePath(){
        String path=properties.getProperty("tokenBasePath");
        if (path!=null) return path;
        else throw new RuntimeException("Base Path not specified in Configuration file");
    }
    public String getClientName(){
        String name=properties.getProperty("clientName");
        if(name!=null) return name;
        else throw new RuntimeException("Client name not specified if Configuration file");
    }
    public String getClientEmail(){
        String email=properties.getProperty("clientEmail");
        if(email!=null) return email;
        else throw new RuntimeException("Client email not specified if Configuration file");
    }
    public String getAccessToken(){
        String token=properties.getProperty("accessToken");
        if(token!=null)return token;
        else throw new  RuntimeException("Token has expired try again");
    }

}
