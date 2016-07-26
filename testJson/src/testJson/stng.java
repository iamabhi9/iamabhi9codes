package testJson;

import java.util.HashMap;

public class stng {

	public static void main(String[] args) {
 String s="fwefwefereswedfe3fwefewfwefwefwefwefwewwedcffwefcweqwsvefvrthrtbtrbrebescevejvfrevhev";
	
	HashMap<String, String> a = new HashMap<>();
	
	for (int i =0; i <s.length(); i++)
	{
		String temp= String.valueOf(s.charAt(i));
 		for (Map.Entry<String,String> entry : a.entrySet()) {
		    String key = entry.getKey();
		    Thing thing = entry.getValue();
		    ...
		}
	}
	
	
	}

}
