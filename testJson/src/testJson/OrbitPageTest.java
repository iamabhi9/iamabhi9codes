package testJson;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

public class OrbitPageTest {
	 private final String USER_AGENT = "Mozilla/5.0";

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws IOException, ParseException {
 
		 String requestUrl = "http://www.orbitpage.com/Auth/CreateAccount";
		 

		 String payload = "{\"FirstName\":\"user F name\",\"LastName\":\"user L Name\",\"Gender\":\"male\",\"EmailId\":\"username@aa.com\",\"Username\":\"username\",\"Password\":\"Abhinav\",\"Source\":\"web\",\"Referral\":\"NA\"}";
	 
	String responce=	 doPost(requestUrl, payload) ;
		String vertexId= parseVertex(  responce);
	//  {\"Message\":\"test\",\"VertexId\":\"1847512\",\"TaggedVertexId\":[]}
	
		 
	} 
	
	public static String parseVertex(String responce) throws ParseException
	{ JSONParser parser = new JSONParser();
String vertexId=null;
	String output= responce.toString();   //responce into string 
	 
	  JSONObject newobj= (JSONObject) parser.parse(output);    //parse string into one object 
 	  JSONArray arrPay= (JSONArray) newobj.get("Payload"); 
 	 for (Object objt: arrPay){
 		   JSONObject oneob= (JSONObject) objt;
   		   
 	    System.out.println(oneob.get("VertexId"));
 	   vertexId=oneob.get("VertexId").toString();
 	    
 	  }
		
		
		return vertexId;
		
	}
	
	public static String doPost(String requestUrl, String payload) throws IOException
	{

		 URL url = new URL(requestUrl);
		 HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		 connection.setDoInput(true);
		 connection.setDoOutput(true);
		 connection.setRequestMethod("POST");
		 connection.setRequestProperty("Accept", "application/json");
		 connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		 OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
		 
		 writer.write(payload);
		 writer.close();
		 BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		 StringBuffer jsonString = new StringBuffer();
		 String line;
		 while ((line = br.readLine()) != null) {
		         jsonString.append(line);
		  }
		 br.close();
		int responseCode = connection.getResponseCode();
		System.out.println("Responce Code: "+responseCode );
		 connection.disconnect();
		 
		 System.out.println( jsonString.toString());
		return jsonString.toString(); 
			 
		 }
	}

 
