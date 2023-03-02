package com.example.chatgptservice.entities;

import java.util.List;

public class ChatResponse {

    private Usage usage ;
    private List<Choice> choices ;

    public ChatResponse() {
    }

    public ChatResponse(Usage usage, List<Choice> choices) {
        this.usage = usage;
        this.choices = choices;
    }

    public String  getfirst (){
        if (choices == null || choices.isEmpty())
            return "Nothing";
        return choices.get(0).getText();
    }

    @Override
    public String toString() {
        return "{" +
                "usage=" + usage.toString() +
                ", choice=" + this.getfirst() +
                '}';
    }
}


