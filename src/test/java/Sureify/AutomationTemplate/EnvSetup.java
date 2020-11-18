package Sureify.AutomationTemplate;

import java.util.Properties;

import dataProviders.ConfigFileReader;
import general.GetURL;
import general.UATURLFromQuility;

/**
 * @author madhubabu
 * @date 04-Sep-2020
 */

public class EnvSetup 
{
	public static String siteURL_UAT;

	public static void envSetup()
	{
		Properties properties = ConfigFileReader.readConfig();
		
		int envType = Integer.parseInt(properties.getProperty("envType"));
		
		switch(envType) 
        {
        case 0: 
			siteURL_UAT = properties.getProperty("siteStagingURL");
			break;
		
		case 1:
			siteURL_UAT = UATURLFromQuility.getUATURL();
			break;

		case 2:
			siteURL_UAT = GetURL.getURL();
			break;
			
		case 3:
			siteURL_UAT = properties.getProperty("sitePRODURL");
			break;
			
		default:
			System.out.println("Invalid environment");
		}
	}

}
