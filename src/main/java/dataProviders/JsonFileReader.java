package dataProviders;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author madhubabu
 * @date 12-Mar-2020
 */

public class JsonFileReader 
{
	private JsonFileReader() 
	{
		throw new IllegalStateException("Data reader class");
	}

	public static JSONArray readJSON()
	{
		JSONParser jsonParser = new JSONParser();
		JSONArray jsonArray = null;

		try
        {
			FileReader reader = new FileReader("src/main/java/testData/dataSet.json");
            
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			jsonArray = (JSONArray) jsonObject.get("questions");
        }
        catch(Exception e)
        {
            e.printStackTrace();
		}
		
		return jsonArray;

	}

	public static JSONArray readJSON(String path)
	{
		JSONParser jsonParser = new JSONParser();
		JSONArray jsonArray = null;

		try
        {
			FileReader reader = new FileReader(path);
            
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			jsonArray = (JSONArray) jsonObject.get("APITestData");
        }
        catch(Exception e)
        {
            e.printStackTrace();
		}
		
		return jsonArray;

	}

}
