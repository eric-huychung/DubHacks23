package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		String apiUrl = "https://canvas.instructure.com/api/v1/users/self/courses/100000001666592/assignments?access_token=";
		try{
			//System.out.println(sendGetRequest(test,token));upcoming_events
			System.out.println(sendGetRequest(apiUrl,token));
		}catch(Exception x){

		}
		
    }

	public static String sendGetRequest(String apiUrl, String accessToken) throws Exception {
		URL url = new URL(apiUrl+accessToken+"&page=1&per_page=2");
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
}