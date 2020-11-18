package general;

import java.util.HashMap;

import org.json.simple.JSONObject;

import dataProviders.JsonFileReader;

public class M 
{
    public static void main(String[] args) 
    {
        HashMap<String, String> cutURLDataHash;
        
        cutURLDataHash = new HashMap<String, String>();
		cutURLDataHash =  (JSONObject) JsonFileReader.readJSON("src/main/java/testData/dataAPI.json").get(0);
        System.out.println("{\r\n" + 
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
		"    \"zoho_product_type\": \""+ cutURLDataHash.get("ZohoProductName") +"\"\r\n" + 
		"    \"standard_premium\": "+ cutURLDataHash.get("StandardPremium") +",\r\n" + 
		"    \"preferred_premium\": "+ cutURLDataHash.get("PreferredPremium") +",\r\n" + 
		"    \"zoho_lead_id\": \""+ cutURLDataHash.get("ZohoLeadId") +"\"\r\n" + 
		"  },\r\n" + 
		"  \"agent\": {\r\n" + 
		"    \"agent_first_name\": \""+ cutURLDataHash.get("AgentFirstName") + "\",\r\n" + 
		"    \"agent_last_name\": \""+ cutURLDataHash.get("AgentLastName") +"\"\r\n" + 
		"    \"agent_phone\": \""+ cutURLDataHash.get("AgentPh") +"\"\r\n" + 
		"    \"agent_email\": \""+ cutURLDataHash.get("AgentEmail") +"\",\r\n" + 
		"    \"agent_signature\": \"string\",\r\n" + 
		"    \"agent_web_url\": \"https://wwww.quility.com\"\r\n" + 
		"  }\r\n" +
		"}");
        
    }
    
}
