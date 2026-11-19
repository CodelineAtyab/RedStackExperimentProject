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


Issue #595:

201 vs 202:
1) 201 is Created while 202 is Accepted.
2) 201 Created something new. While 202 Accepted the request, work still to do.
3) 201 give back The new item or where to find it. While 202 gives back The status of the request and where to check it.
4) Typical use of 201 is A new account, order or upload. While 202 is Long tasks handled in the background.
5) source: https://www.one.com/en-gb/academy/http-200/

ResponseEntity: it's a class of full HTTP response,that give thr controller complete control of the status code. so it allow the controller to respond with 202 or 200 or 404.


• filter tests each stream element against a boolean condition and keeps only the ones that match.

• map applies a function to each stream element to transform it into a new value or type

No Blockers.