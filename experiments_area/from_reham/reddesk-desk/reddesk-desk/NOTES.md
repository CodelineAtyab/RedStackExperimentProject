Round 1 – My Client → Alaa’s Server
Server: Alaa’s computer
Client: Reham’s computer
Result: Successful
Actual output from Alaa’s client:
Name: Sara
1 - Cafe
2 - Pilates
3 - Matcha
The client successfully connected to Alaa Spring Boot server, received the JSON response, deserialized it, and printed the name and favourite items in the expected format.

Round 2 – Alaa’s Client → My Client

Server: Reham’s computer
Client: Alaa’s computer
Result: 
Name - Sara
1 - Coffee
2 - Books
3 - Football

Alaa’s client successfully connected to my Spring Boot server over the network, received the JSON response, deserialized it,and printed the name and favourite items in the expected format.

Conclusion
Both rounds of testing were successful. We verified that both Spring Boot servers could communicate with the other person's client over the network, and that JSON serialization and deserialization worked correctly in both directions.
# NOTES

## 1. Spring Bean
A Spring Bean is an object that Spring creates and manages for us.

**My Bean Name:** `feedbackController`

## 2. HTTP Methods
- **GET:** Shows all feedback.
- **POST:** Adds new feedback.
- **PUT:** Updates existing feedback.
- **DELETE:** Deletes feedback.
- **QUERY:** Sends a request with a body to search for data. (Not implemented.)

## 3. What I Built
I created a Feedback API using Spring Boot. It can add, show, update, and delete feedback.

I used an ArrayList to store the feedback.

## 4. Unirest Client
I used Unirest to connect to the server and test all four operations: POST, GET, PUT, and DELETE.

## 5. Partner
**GitHub Username:** [Write your partner's username]

## 6. Blockers
I had a connection timeout when trying to connect to the server. I fixed it and successfully ran the client.

## 7. What Was Difficult?
Understanding how the client sends requests to the server and how JSON data is sent and received.
