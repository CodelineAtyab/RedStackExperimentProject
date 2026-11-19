Customer API: 

Copied Customer.java and GET and POST from the Atyab 
then add  PUT and DELETE
used ArrayList to store customers.
return 404>>> if no customer


Feedback API: 
added Feedback.java with id, message and customerId.
then added POST, GET, PUT and DELETE.
Used ArrayList to store feedback.
returned 404 >>> if no feedback



Customer and Feedback: 

Linked feedback to customers using customerId. 
must check if the customer exists before adding feedback.
return 404>>> if no customer
then added an endpoint to get feedback for one customer.
deleted a customer feedback when delete the customer.

...................................................................

Tested the endpoints using Postman and checked POST, GET, PUT and DELETE>> it work 