package dataProviders;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFileReader 
{
    public static Properties readConfig()
    {
        Properties properties = new Properties();
    
        try
        {
            properties.load(new FileInputStream(System.getProperty("user.dir") + "/src/config/config.properties"));
        }catch(Exception e)
        {
            System.out.println("Error occures while reading the config file");
            System.out.println(e.getMessage());
        }

        return properties;
    }
    
		
    
}
