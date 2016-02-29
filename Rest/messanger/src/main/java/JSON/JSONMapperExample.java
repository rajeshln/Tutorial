package JSON;

import java.io.FileOutputStream;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONMapperExample {

	public static void main(String[] args) {
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String carJson = 
			"{ \"type\" : \"mercedes\" , \"make\" : \"2015\" }"; //  enter \ before "
		
		try {
			
			Car mycar = objectMapper.readValue(carJson, Car.class);
			
			System.out.println(" car make "+mycar.getMake());
			System.out.println(" car type "+mycar.getType());
			
			// jackson tree model example
			
			// passing JsonNode.class as second attribute
			//  this tree can be used to reterive the different values
			//node {"type":"mercedes","make":"2015"} 
			
			JsonNode node = objectMapper.readTree(carJson);
			System.out.println( " node "+node.toString());
		   
			JsonNode nodeTree = objectMapper.readValue(carJson, JsonNode.class); 
			System.out.println( " node "+nodeTree.toString());
			
			// now get the values
				JsonNode brandNode = node.get("type");
			    String brand = brandNode.asText();
			    System.out.println("type = " + brand);
			
			    
			 //3) create Json from the object
			    
			    objectMapper.writeValue(
			    		new FileOutputStream("C:/Users/Rajeshn/Documents/Rest/messanger/src/main/java/JSON/output-2.json"), mycar);
			
		}
		
		catch(IOException e){
			
			e.printStackTrace();
			
		}
		
		
		}


}

