package testJson;
  
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser; 

public class HttpURLConnectionExample {

 private final String USER_AGENT = "Mozilla/5.0";

 public static void main(String[] args) throws Exception {

  HttpURLConnectionExample http = new HttpURLConnectionExample();

  System.out.println("Testing 1 - Send Http GET request");
 // http.sendGet();

/// System.out.println("\nTesting 2 - Send Http POST request-Login");
http.login();

 System.out.println("\nTesting 3 - Send Http POST request-Register");
 //register();
 }

 // HTTP GET request
 private void sendGet() throws Exception {

  String url = "https://en.wikipedia.org/wiki/Accenture";

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
 
  System.out.println(response.toString());
 
  
  //parsing
  JSONParser parser = new JSONParser();
String output= response.toString();   //responce into string 
 
  JSONObject newobj= (JSONObject) parser.parse(output);    //parse string into one object 
  System.out.println(newobj.get("AbortProcess"));
  JSONArray arrPay= (JSONArray) newobj.get("Payload");  // parsed one array
  //it was array of objects
  for (Object objt: arrPay){
	   JSONObject oneob= (JSONObject) objt;
	   System.out.println("------------------------------------");
	   System.out.println(objt.toString());
	   
    System.out.println(oneob.get("name"));
    System.out.println(oneob.get("vertexId"));

    
  }
  

   
  
 }
 
 private void login() throws Exception {
	 
	 String requestUrl = "http://www.orbitpage.com/Auth/Login";
	 

	 String payload = "{\"Username\":\"abhinav\",\"Password\":\"Abhi999@\",\"Type\":\"web\",\"KeepMeSignedInCheckBox\":true}";
 
	 postWorker(requestUrl, payload);
	 
 }
 
 private static void register() throws Exception {
	 
	 String requestUrl = "http://www.orbitpage.com/Auth/CreateAccount";
	 

	 String payload = "{\"FirstName\":\"user F name\",\"LastName\":\"user L Name\",\"Gender\":\"male\",\"EmailId\":\"username@aa.com\",\"Username\":\"username\",\"Password\":\"Abhinav\",\"Source\":\"web\",\"Referral\":\"NA\"}";
 
	 postWorker(requestUrl, payload);
	 
 }
 
 private static void postWorker(String requestUrl, String payload) throws Exception {
	

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
	 
 }
 
 
}