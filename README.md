# Izicap Homewok java 

IZICAP-ChatGPT-MicroService



## Context

This microservice allows you to query the ChatGPT API and store the questions and answers in a CSV file.

### Prerequisites

- Java 17 
- Intellij Idea // i still working on docker i have  problems  in it but the the microservice  works fine

### Usage

- after Cloning this repository to your local machine.
- run the maven to get the dependcies 
- run the project 
- To interact with the microservice, send a POST request to the http://localhost:8080/chat endpoint with a JSON body containing the question to be answered:

```json
{
"model": "text-davinci-003",
"prompt": "talk me about IZICAP ??",
"max_tokens": 4000,
"temperature": 1.0
}
```

![postman](https://user-images.githubusercontent.com/56925602/222433692-dc55f447-030b-48e5-bb74-78ab5d1b9443.png)


-The microservice will return  response containing the usage and the first choice of answers

```
{
usage={"prompt_tokens": 5,
"completion_tokens": 67,
"total_tokens": 72
choice=Izicap is an innovative invoicing and payments platform designed to streamline and automate key billing processes for small-to-medium businesses. The platform allows businesses to create and manage invoices and payments in real-time
}
```
### Project folder overview  

![pro](https://user-images.githubusercontent.com/56925602/222438387-08fa9b95-3798-414c-b16f-3d8677bb733c.png)




