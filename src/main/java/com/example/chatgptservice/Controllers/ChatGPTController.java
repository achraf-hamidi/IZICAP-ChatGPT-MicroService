package com.example.chatgptservice.Controllers;

import com.example.chatgptservice.Repositories.CsvRepository;
import com.example.chatgptservice.Services.ChatGPTServices;
import com.example.chatgptservice.entities.ChatRequest;
import com.example.chatgptservice.entities.ChatResponse;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ChatGPTController {

    private ChatGPTServices chatGptService=new ChatGPTServices();

    private CsvRepository csvRepository = new CsvRepository();



    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody ChatRequest chatRequest) throws IOException, InterruptedException {
        String question = chatRequest.getPrompt();
        int maxtoken = chatRequest.getMaxTokens();
        double temperature = chatRequest.getTemperature();
        String model = chatRequest.getModel();
        ChatResponse answer = chatGptService.getAnswer(question,maxtoken,temperature,model);
        csvRepository.appendToCsv(question, answer.getfirst());
        return new ResponseEntity<>(answer.toString(), HttpStatus.OK);
    }




}

