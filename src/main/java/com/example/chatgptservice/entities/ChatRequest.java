package com.example.chatgptservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Value;

public class ChatRequest {
    @JsonProperty("prompt")
    private String prompt;

    @JsonProperty("temperature")

    private double temperature;

    @JsonProperty("max_tokens")
    private int  max_tokens;

    @JsonProperty("model")
    private String  model;

    public String getModel() {
        return model;
    }

    public ChatRequest(String prompt, int maxTokens , double temperature,String model ) {
        this.prompt = prompt;
        this.max_tokens =  maxTokens ;
        this.temperature = temperature ;
        this.model =model;
    }



    public String getPrompt() {
        return prompt;
    }

    public double getTemperature() {
        return temperature;
    }

    public int getMaxTokens() {
        return max_tokens;
    }
}