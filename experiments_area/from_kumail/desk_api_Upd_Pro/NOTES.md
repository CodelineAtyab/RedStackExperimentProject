application.properties:
I changed the server port to 8081.
I used 0.0.0.0 because it allows other devices
on the same network to access my server.

Final configuration

server.port=8081
server.address=0.0.0.0

Customer ID:
I added customerId to the Feedback model.
Each feedback now belongs to a customer.
The FeedbackService checks if the customer exists
before saving feedback.

Unknown customer:
I chose 400 Bad Request because the customer ID
does not belong to an existing customer.

Postman Testing
-- ScreenShot Folder


No blockers. 
The hardest part was understanding : how FeedbackService connects to CustomerService.
