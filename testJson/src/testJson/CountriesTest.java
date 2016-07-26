package testJson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bsh.Console;

public class CountriesTest {
	 private final String USER_AGENT = "Mozilla/5.0";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException, ParseException {
		  String url = "https://restcountries.eu/rest/v1/all";

		  URL obj = new URL(url);
		  HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		  
		  con.setRequestMethod("GET");

		  //add request header
		  con.setRequestProperty("User-Agent", USER_AGENT);

		  int responseCode = con.getResponseCode();
		  System.out.println("\nSending 'GET' request to URL : " + url);
		  System.out.println("Response Code : " + responseCode);

		  BufferedReader in = new BufferedReader(
		   new InputStreamReader(con.getInputStream()));
		  String inputLine;
		  StringBuffer response = new StringBuffer();

		  while ((inputLine = in .readLine()) != null) {
		   response.append(inputLine);
		  } in .close();

		  //print result- total output of API responce 
		 
	//	  System.out.println(response.toString());
		 
		  
		  //parsing
		  JSONParser parser = new JSONParser();
		String output= response.toString();   //responce into string 
		 
	 
        Object obj1 = parser.parse("{ \"json\": " +output +"}");
        JSONObject jsonObject = (JSONObject) obj1;
        JSONArray slideContent = (JSONArray) jsonObject.get("json");
        Iterator i1 = slideContent.iterator();

        while (i1.hasNext()) {
          
          System.out.println();
          System.out.println();

 		  JSONObject newobj= (JSONObject) parser.parse(i1.next().toString());    //parse string into one object 
		
		  System.out.println("Country: "+newobj.get("name"));
		
		  System.out.println("Capital: "+newobj.get("capital"));

		  
		  JSONArray arrPay= (JSONArray) newobj.get("latlng");  // parsed one array
		  
		  if (arrPay.size()>0)
		  {
			  System.out.println("Lat: "+arrPay.get(0)+" Long: "+arrPay.get(1));

		  }
		  
 JSONObject trans= (JSONObject) parser.parse(newobj.get("translations").toString()); 
 System.out.println("In German: "+trans.get("de"));
 System.out.println("In Japnease: "+trans.get("ja"));
 JSONArray border= (JSONArray) newobj.get("borders");  // parsed one array
 if (border.size()>0)
 System.out.println("Borders with ");
 for (int i=0; i<border.size()-2; i++) 
 {
	 System.out.print(border.get(i)+" , ");
 }
 if (border.size()>1)
	 System.out.print(border.get(border.size()-2)+" and "+border.get(border.size()-1));
 else if (border.size()==1)
	 System.out.println(border.get(0));
		  //it was array of objects
		 
	}} 
	  
}
