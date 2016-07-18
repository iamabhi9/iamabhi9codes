package testJson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
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

		String requestUrl = "http://www.makaan.com/madrox/app/v1/login?username=rohan.bhatore@proptiger.com&password=123456&domainId=1";

		String myCookie = "userId=igbrown";
		String payload = "";
		// String payload =
		// "{\"Username\":\"abhinav\",\"Password\":\"Abhi999@\",\"Type\":\"web\",\"KeepMeSignedInCheckBox\":true}";
		String cookie = doPost(requestUrl, payload);
		String cookieName = cookie.substring(0, cookie.indexOf("="));
		String cookieValue = cookie.substring(cookie.indexOf("=") + 1, cookie.length());

		// String vertexId= parseVertex( responce);
		String vertexId = "1847512";

		requestUrl = "https://www.makaan.com/madrox/app/v1/user/details";
		//responce = "{\"Message\":\"test\",\"VertexId\":\"".concat(vertexId);
	//	responce = responce.concat("  \",\"TaggedVertexId\":[]}");
	String 	responce=" ";
	//	System.out.println(doPost(requestUrl, payload));
	
		 
		 
	HttpClient client = HttpClientBuilder.create().build();
	HttpGet get = new HttpGet(requestUrl);
	get.setHeader("Cookie", cookie);

	get.setHeader("Accept-Language", "en-US,en;q=0.5");
	get.setHeader("Connection", "keep-alive");
	System.out.println(get.getAllHeaders().toString());
	HttpResponse response = client.execute(get);
	int responseCode = response.getStatusLine().getStatusCode();

	System.out.println("Response Code : " + responseCode);

	BufferedReader rd = new BufferedReader(new InputStreamReader(
			response.getEntity().getContent()));

	StringBuffer result = new StringBuffer();
	String line = "";

	while ((line = rd.readLine()) != null) {
		result.append(line);
	}
	System.out.println(">>>>>>>>>>>>>>>>Respone :>>>>>>>>>>>>>>>>>"+result.toString());
	System.out.println(result.toString());
	long tm=(long)1468828142*1000;
	Date date = new Date(tm);
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	System.out.println( formatter.format(date));
		  //parsing
 		 
		
	}

	public static String parseVertex(String responce) throws ParseException {
		JSONParser parser = new JSONParser();
		String vertexId = null;
		String output = responce.toString(); // responce into string

		JSONObject newobj = (JSONObject) parser.parse(output); // parse string
																// into one
																// object
		JSONArray arrPay = (JSONArray) newobj.get("Payload");
		for (Object objt : arrPay) {
			JSONObject oneob = (JSONObject) objt;

			System.out.println(oneob.get("VertexId"));
			vertexId = oneob.get("VertexId").toString();

		}

		return vertexId;

	}

	public static String doPost(String requestUrl, String payload) throws IOException {

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
		System.out.println("Responce Code: " + responseCode);
		String cookie = null;
		String headerName = null;
		for (int i = 1; (headerName = connection.getHeaderFieldKey(i)) != null; i++) {
			// System.out.println( headerName+ " ---
			// "+connection.getHeaderField(i));
			if (headerName.equals("Set-Cookie")) {
				cookie = connection.getHeaderField(i);
			}
		}
 		cookie = cookie.substring(0, cookie.indexOf(";"));
		String cookieName = cookie.substring(0, cookie.indexOf("="));
		String cookieValue = cookie.substring(cookie.indexOf("=") + 1, cookie.length());

		connection.disconnect();
		// System.out.println(cookieName+" -- "+ cookieValue);
//		connection.setRequestProperty(cookieName, cookieValue);

		System.out.println(jsonString.toString());
		return cookie;

	}
}
