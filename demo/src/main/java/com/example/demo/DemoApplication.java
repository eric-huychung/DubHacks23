package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		String token = "10~767bhSan4OeHT4jBG9IyUL7EyeD9p7QWKoIgGhHPKgjz8PGKKD3z1lLkFQx7f6Zu";
		String apiUrl = "https://canvas.instructure.com/api/v1/users/self/courses?access_token=";
		String json = "";
		try{
			//System.out.println(sendGetRequest(test,token));upcoming_events
			json = sendGetRequest(apiUrl,token);
			ObjectMapper objectMapper = new ObjectMapper();
        	JsonNode jsonNode = objectMapper.readTree(json);

			if (jsonNode.isArray()) {
				for (JsonNode objNode : jsonNode) {
					String id = objNode.get("id").asText();
					//System.out.println(id);
					String assignmentApiUrl = "https://canvas.instructure.com/api/v1/users/self/courses/"+id+"/assignments?access_token=";
					String json1 =sendGetRequest(assignmentApiUrl, token);
					//System.out.println(json1);
					ObjectMapper objectMapper1 = new ObjectMapper();
        			JsonNode jsonNode1 = objectMapper1.readTree(json1);
					if (jsonNode1.isArray()) {
						for (JsonNode objNode1 : jsonNode1) {
							String classname = objNode1.get("name").asText();
							String due = objNode1.get("due_at").asText();
							System.out.println(classname+" "+due);
						}
					}
				}
			}
		}catch(Exception x){

		}

		
		
    }

	public static String sendGetRequest(String apiUrl, String accessToken) throws Exception {
		URL url = new URL(apiUrl+accessToken+"&page=1&per_page=100");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
		//System.out.println(connection.getHeaderFields().toString());
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {
            return "HTTP Request failed with response code: " + responseCode;
        }
	}
	@GetMapping("/getJavaVariable")
    public static String getJavaVariable() {
        String javaVariable = "Hello from Java!";
        return javaVariable;
    }
}