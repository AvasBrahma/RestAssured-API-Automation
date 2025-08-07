package json.api.validator;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.everit.json.schema.ValidationException;

public class JsonSchemaValidator {
	
	 public static void validateJsonAgainstSchema(String jsonResponse, String jsonSchemaString) {
	        try {
	            JSONObject rawSchema = new JSONObject(new JSONTokener(jsonSchemaString));
	            Schema schema = SchemaLoader.load(rawSchema);
	            JSONObject response = new JSONObject(jsonResponse);
	            schema.validate(response); // throws ValidationException if invalid
	            System.out.println("✅ JSON response is valid against the schema.");

	        } catch (ValidationException e) {
	            System.out.println("JSON response is NOT valid. Errors:");
	           // e.getAllMessages().forEach(msg -> System.out.println("" + msg)); -> Lambda expressions are allowed only at source level 1.8 or above
	            System.out.println("JSON response is NOT valid. Errors:\n" + String.join("\n", e.getAllMessages()));
	        } catch (Exception e) {
	            System.out.println("Unexpected error while validating JSON Schema: " + e.getMessage());
	        }
	    }
	 
	  // Load schema as a string from file path
	    public static String loadSchema(String filePath) {
	        try {
	            return new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to load schema file: " + filePath, e);
	        }
	    }

}
