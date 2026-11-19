1) put: update the object
2) delete: delete the object
3) post: create the object
4) get: show the object
   

if an id is missing teh server return 404 and id does not exist

no blockers

Issue #550:

Design Choices
1) Missing IDs ine (get, put, delete): show 404 Not Found.
2) Unknown customerId on POST /feedback: 400 Bad Request when customerId is missing or does not exist in listOfCustomers.
3) Deleting a customer with existing feedback: when DELETE /customers/{id} runs, it loops backward through FeedbackController.listOfFeedback and removes all feedback tied to that customer before deleting the customer.
4) Customer feedback endpoint path: implemented GET /customers/{id}/feedback inside CustomerController.

What I Copied vs. What I Wrote Myself:

Copied from trainer: he base Customer model structure and initial CustomerController setup

Written by me: Everything else.


no Blockers

Postman test:


Issue #594:

Service: It's a layer in the app that hold the logic of the app.

we sue it to keep the code organized, Makes code reusable and Easier to test and fix.

@Autowired is a tag that connect the service to the controller without needing to create the connection ourselves
