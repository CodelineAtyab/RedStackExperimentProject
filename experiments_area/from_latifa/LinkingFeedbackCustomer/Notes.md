# Customer ID
Before adding feedback, I check if the customer exists.
If the customer does not exist, I return 400 Bad Request.
I do the same check when updating feedback.

# Missing ID
If a customer or feedback is not found, I return 404 Not Found with a message.

# Deleting a Customer
When I delete a customer, I also delete all feedback linked to that customer using removeIf().

# Copied and Implemented Code
I followed the trainer's examples for getting all customers, getting one customer by ID, and adding a customer.
I implemented the update and delete methods for customers, and the feedback operations myself.

# Employees API (Part 1)
The Employees API from Part 1 (#549) is in:
      experiments_area/from_latifa/EmployeesApi

# Blockers
The hardest part was linking feedback to the correct customer and checking that the customer exists before adding or updating feedback.
