package com.example.chatgptservice.Services;

import com.example.chatgptservice.entities.ChatRequest;
import com.example.chatgptservice.entities.ChatResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ChatGPTServices {

    @Value("${openai.api_key}")
    private String openaiApiKey;
    private static final URI OPENAI_API_URL = URI.create("https://api.openai.com/v1/completions");

    public ChatResponse getAnswer(String question,int maxtoken , double temperature,String model) throws IOException, InterruptedException {
        // Create the request object
        ChatRequest request = new ChatRequest(question,maxtoken,temperature,model);

        // Convert the request to JSON
        String requestBody = new Gson().toJson(request);

        // Create the HTTP client and request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(OPENAI_API_URL)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + "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")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        // Send the request and get the response
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        // Parse the response
        ChatResponse chatResponse = new Gson().fromJson(response.body(), ChatResponse.class);


        // Return the answer
        return chatResponse;
    }

}