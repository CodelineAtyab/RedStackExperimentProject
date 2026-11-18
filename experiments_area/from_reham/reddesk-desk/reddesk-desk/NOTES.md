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