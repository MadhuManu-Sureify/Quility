package general;

import java.util.HashMap;
import java.util.Properties;

import org.json.simple.JSONObject;

import dataProviders.ConfigFileReader;
import dataProviders.ExcelFileReader;
import dataProviders.JsonFileReader;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

/**
 * @author madhubabu
 * @date 28-Aug-2020
 * @desc It will return the cutover api URL
 */
public class GetURL 
{
	static String ACCESS_TOKEN = null;
	public static HashMap<String, String> cutURLDataHash;
	static Properties properties = ConfigFileReader.readConfig();
	
	public static String getURL()
	{
		try 
		{
			cutURLDataHash = new HashMap<String, String>();
			cutURLDataHash =  (JSONObject) JsonFileReader.readJSON("src/main/java/testData/dataAPI.json").get(0);
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e.getMessage());
	    }
		
		if(properties.getProperty("cutOverEnvType").equalsIgnoreCase("STG"))
		{
			RestAssured.baseURI="https://quilitystg.sureify.com";
		}else if(properties.getProperty("cutOverEnvType").equalsIgnoreCase("UAT"))
		{
			RestAssured.baseURI="https://quility.sureify.com";
		}
			
		String response1 =  RestAssured.given().urlEncodingEnabled(false).
		                     header("Authorization", "Basic YWRtaW46NyVkUkdyZVQ=").
		                     header("organization_id","7sdsdh87884d9929908880").
		                     header("organization_access_token","HDJ717DWOOW8AF923B79S40A6B0FC9E").
		body(getCutAutBody()).
	    when().post("/v1/auth").
	    then().extract().asString();
		JsonPath js1 = getRawToJson(response1);
		ACCESS_TOKEN = js1.getString("access_token");
		
		String response2 = RestAssured.given().urlEncodingEnabled(false).
				 header("content-type","application/json").
				 header("organization_id","7sdsdh87884d9929908880").
	             header("organization_access_token","HDJ717DWOOW8AF923B79S40A6B0FC9E").
	             header("Authorization", "Bearer "+ACCESS_TOKEN).
				 body(getCutApiBody()).
		expect().
		defaultParser(Parser.JSON).
		when().post("/v1/quote/cutoverapi").then().extract().asString();
		JsonPath js2 = getRawToJson(response2);
		String url = js2.get("response.pathname");
	    System.out.println(url);
	    
	    return url;
	}
	
	public static String getURLs(int index)
	{
		try 
		{
			// cutURLDataHash =  (JSONObject) JsonFileReader.readJSON().get(index);
	    	cutURLDataHash = new HashMap<String, String>();
	    	cutURLDataHash = ExcelFileReader.readExcel(properties.getProperty("TestData"), "TestDataTC103", index);
		    
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e.getMessage());
	    }
		
		if(properties.getProperty("cutOverEnvType").equalsIgnoreCase("STG"))
		{
			RestAssured.baseURI="https://quilitystg.sureify.com";
		}else if(properties.getProperty("cutOverEnvType").equalsIgnoreCase("UAT"))
		{
			RestAssured.baseURI="https://quility.sureify.com";
		}
		
		String response1 =  RestAssured.given().urlEncodingEnabled(false).
		                     header("Authorization", "Basic YWRtaW46NyVkUkdyZVQ=").
		                     header("organization_id","7sdsdh87884d9929908880").
		                     header("organization_access_token","HDJ717DWOOW8AF923B79S40A6B0FC9E").
		body(getCutAutBody()).
	    when().post("/v1/auth").
	    then().extract().asString();
		JsonPath js1 = getRawToJson(response1);
		ACCESS_TOKEN = js1.getString("access_token");
		
		String response2 = RestAssured.given().urlEncodingEnabled(false).
				 header("content-type","application/json").
				 header("organization_id","7sdsdh87884d9929908880").
	             header("organization_access_token","HDJ717DWOOW8AF923B79S40A6B0FC9E").
	             header("Authorization", "Bearer "+ACCESS_TOKEN).
				 body(getCutApiBody()).
		expect().
		defaultParser(Parser.JSON).
		when().post("/v1/quote/cutoverapi").then().extract().asString();
		JsonPath js2 = getRawToJson(response2);
		String url = js2.get("response.pathname");
	    System.out.println(url);
	    
	    return url;
	    
	}
	
	private static String getCutAutBody() 
	{
		return "{\r\n" + "	\"userName\": \"admin@sureify.com\",\r\n" + 
				"	\"password\": \"$ure!fY@345#\"\r\n" + 
				"}";
	}
	
	private static String getCutApiBody() 
	{
		System.out.println("URL for the Name & State : " +  cutURLDataHash.get("FirstName") + "  -  " + cutURLDataHash.get("State"));

		return "{\r\n" + 
		"  \"user\": {\r\n" + 
		"    \"first_name\": \""+ cutURLDataHash.get("FirstName") +"\",\r\n" + 
		"    \"last_name\": \""+ cutURLDataHash.get("LastName") + "\",\r\n" + 
		"    \"dob\": \""+ cutURLDataHash.get("DOB") + "\",\r\n" + 
		"    \"email\": \""+ cutURLDataHash.get("Email") + "\",\r\n" + 
		"    \"phone_number\": \"" + cutURLDataHash.get("Phone") + "\",\r\n" + 
		"    \"isd_code\": \"" + cutURLDataHash.get("ISDCode") +"\",\r\n" + 
		"    \"gender\": \"" + cutURLDataHash.get("Gender") +"\",\r\n" + 
		"    \"height\": {\r\n" + 
		"      \"feet\": " + cutURLDataHash.get("HeightFt") + ",\r\n" + 
		"      \"inches\": " + cutURLDataHash.get("HeightInch") + "\r\n" + 
		"    },\r\n" + 
		"    \"nicotine_use\": \""+ cutURLDataHash.get("NicotineUse") + "\",\r\n" + 
		"    \"is_nicotine_user\": "+ cutURLDataHash.get("IsNicotineUser") + ",\r\n" + 
		"    \"replace_existing_insurance\": " + cutURLDataHash.get("ExisitingInsurance") +",\r\n" + 
		"    \"state\": \""+ cutURLDataHash.get("State") + "\",\r\n" + 
		"    \"weight\": \""+ cutURLDataHash.get("Weight") + "\",\r\n" + 
		"    \"zipcode\": \"" + cutURLDataHash.get("Zipcode") + "\",\r\n" + 
		"    \"city\": \""+ cutURLDataHash.get("City") +"\"\r\n" + 
		"  },\r\n" + 
		"  \"quote\": {\r\n" + 
		"    \"product_name\": \""+ cutURLDataHash.get("ProductName") +"\",\r\n" + 
		"    \"company\": "+ cutURLDataHash.get("Company") +",\r\n" + 
		"    \"coverage_amount\": "+ cutURLDataHash.get("CoverageAmount") + ",\r\n" + 
		"    \"premium_frequency\": \""+ cutURLDataHash.get("PremiumFreq") +"\",\r\n" + 
		"    \"plan\": \""+ cutURLDataHash.get("PlanTenure") +"\",\r\n" + 
		"    \"premium_amount\": "+ cutURLDataHash.get("PremiumAmount") +",\r\n" + 
		"    \"underwriting_risk_class\": \""+ cutURLDataHash.get("UnderwritingRiskClass") +"\",\r\n" + 
		"    \"agent_unique_code\": \""+ cutURLDataHash.get("MainAgentID") + "\",\r\n" + 
		"    \"company_agent_id\": [\r\n" + 
		"		{\r\n" +
		"    		\"company\": 110,\r\n" + 
		"    		\"agent_id\": \"" + cutURLDataHash.get("SubAgent1ID") + "\"\r\n" + 
		"  		},\r\n" + 
		"		{\r\n" +
		"    		\"company\": 770,\r\n" + 
		"    		\"agent_id\": \"" + cutURLDataHash.get("SubAgent2ID") + "\"\r\n" + 
		"  		}\r\n" + 
		" 	]\r\n" +
		"  },\r\n" + 
		"  \"tracking\": {\r\n" + 
		"    \"lead_source\": \"\",\r\n" + 
		"    \"campaign_code\": \"\"\r\n" + 
		"  },\r\n" + 
		"  \"client_payload\": {\r\n" + 
		"    \"address\": \""+ cutURLDataHash.get("Address") + "\",\r\n" + 
		"    \"zoho_product_type\": \""+ cutURLDataHash.get("ZohoProductName") +"\",\r\n" + 
		"    \"standard_premium\": "+ cutURLDataHash.get("StandardPremium") +",\r\n" + 
		"    \"preferred_premium\": "+ cutURLDataHash.get("PreferredPremium") +",\r\n" + 
		"    \"zoho_lead_id\": \""+ cutURLDataHash.get("ZohoLeadId") +"\"\r\n" + 
		"  },\r\n" + 
		"  \"agent\": {\r\n" + 
		"    \"agent_first_name\": \""+ cutURLDataHash.get("AgentFirstName") + "\",\r\n" + 
		"    \"agent_last_name\": \""+ cutURLDataHash.get("AgentLastName") +"\",\r\n" + 
		"    \"agent_phone\": \""+ cutURLDataHash.get("AgentPh") +"\",\r\n" + 
		"    \"agent_email\": \""+ cutURLDataHash.get("AgentEmail") +"\",\r\n" + 
		"    \"agent_signature\": \"string\",\r\n" + 
		"    \"agent_web_url\": \"https://wwww.quility.com\"\r\n" + 
		"  }\r\n" +
		"}";
		// return "{\r\n" + 
		// "  \"user\": {\r\n" + 
		// "    \"first_name\": \""+ cutURLDataHash.get("FirstName") +"\",\r\n" + 
		// "    \"last_name\": \""+ cutURLDataHash.get("LastName") + "\",\r\n" + 
		// "    \"dob\": \""+ cutURLDataHash.get("DOB") + "\",\r\n" + 
		// "    \"email\": \""+ cutURLDataHash.get("Email") + "\",\r\n" + 
		// "    \"phone_number\": \"" + cutURLDataHash.get("Phone") + "\",\r\n" + 
		// "    \"isd_code\": \"" + cutURLDataHash.get("ISDCode") +"\",\r\n" + 
		// "    \"gender\": \"" + cutURLDataHash.get("Gender") +"\",\r\n" + 
		// "    \"height\": {\r\n" + 
		// "      \"feet\": " + cutURLDataHash.get("HeightFt") + ",\r\n" + 
		// "      \"inches\": " + cutURLDataHash.get("HeightInch") + "\r\n" + 
		// "    },\r\n" + 
		// "    \"nicotine_use\": \""+ cutURLDataHash.get("NicotineUse") + "\",\r\n" + 
		// "    \"is_nicotine_user\": \""+ cutURLDataHash.get("IsNicotineUser") + "\",\r\n" + 
		// "    \"replace_existing_insurance\": " + cutURLDataHash.get("ExisitingInsurance") +",\r\n" + 
		// "    \"state\": \""+ cutURLDataHash.get("State") + "\",\r\n" + 
		// "    \"weight\": \""+ cutURLDataHash.get("Weight") + "\",\r\n" + 
		// "    \"zipcode\": \"" + cutURLDataHash.get("Zipcode") + "\",\r\n" + 
		// "    \"city\": \""+ cutURLDataHash.get("City") +"\"\r\n" + 
		// "  },\r\n" + 
		// "  \"quote\": {\r\n" + 
		// "    \"product_name\": \""+ cutURLDataHash.get("ProductName") +"\",\r\n" + 
		// "    \"company\": "+ cutURLDataHash.get("Company") +",\r\n" + 
		// "    \"coverage_amount\": "+ cutURLDataHash.get("CoverageAmount") + ",\r\n" + 
		// "    \"premium_frequency\": \""+ cutURLDataHash.get("PremiumFreq") +"\",\r\n" + 
		// "    \"plan\": \""+ cutURLDataHash.get("PlanTenure") +"\",\r\n" + 
		// "    \"premium_amount\": "+ cutURLDataHash.get("PremiumAmount") +",\r\n" + 
		// "    \"underwriting_risk_class\": \""+ cutURLDataHash.get("UnderwritingRiskClass") +"\",\r\n" + 
		// "    \"agent_unique_code\": \""+ cutURLDataHash.get("MainAgentID") + "\"\r\n" + 
		// "    \"company_agent_id\": [\r\n" + 
		// "		{\r\n" +
		// "    		\"company\": 110,\r\n" + 
		// "    		\"agent_id\": \"" + cutURLDataHash.get("SubAgent1ID") + "\",\r\n" + 
		// "  		},\r\n" + 
		// "		{\r\n" +
		// "    		\"company\": 770,\r\n" + 
		// "    		\"agent_id\": \"" + cutURLDataHash.get("SubAgent2ID") + "\"\r\n" + 
		// "  		},\r\n" + 
		// " 	]" +
		// "  },\r\n" + 
		// "  \"tracking\": {\r\n" + 
		// "    \"lead_source\": " + null + ",\r\n" + 
		// "    \"campaign_code\": " + null + ",\r\n" + 
		// "  },\r\n" + 
		// "  \"client_payload\": {\r\n" + 
		// "    \"address\": \""+ cutURLDataHash.get("Address") + "\",\r\n" + 
		// "    \"zoho_product_type\": \""+ cutURLDataHash.get("ZohoProductName") +"\"\r\n" + 
		// "    \"standard_premium\": \""+ cutURLDataHash.get("StandardPremium") +"\"\r\n" + 
		// "    \"preferred_premium\": \""+ cutURLDataHash.get("PreferredPremium") +"\"\r\n" + 
		// "    \"zoho_lead_id\": \""+ cutURLDataHash.get("ZohoLeadId") +"\"\r\n" + 
		// "  },\r\n" + 
		// "  \"agent\": {\r\n" + 
		// "    \"agent_first_name\": \""+ cutURLDataHash.get("AgentFirstName") + "\",\r\n" + 
		// "    \"agent_last_name\": \""+ cutURLDataHash.get("AgentLastName") +"\"\r\n" + 
		// "    \"agent_phone\": \""+ cutURLDataHash.get("AgentPh") +"\"\r\n" + 
		// "    \"agent_email\": \""+ cutURLDataHash.get("AgentEmail") +"\"\r\n" + 
		// "    \"agent_signature\": \"string\",\r\n" + 
		// "    \"agent_web_url\": \"https://wwww.quility.com\"\r\n" + 
		// "  }\r\n" +
		// "}";
		
	}	
	
    private static JsonPath getRawToJson(String response) 
    {
    	return new JsonPath(response);
	}
    
}

