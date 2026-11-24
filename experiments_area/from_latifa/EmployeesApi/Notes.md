##HTTP Methods
- GET: Read or Retrieve 
- POST: Create or Add
- PUT: Update or Replace
- DELETE: Remove


##Missing Employee ID
If the employee ID does not exist, 
I decided to return 404 Not Found with the message "Employee not found!". 
I applied this to GET, PUT and DELETE.


##Delete all confirmation
I added a confirmation using "?confirm=true" before deleting all employees. If the confirmation is missing or the value is not true, the API returns 400 Bad Request and does not delete anything.


##Testing:
I tested the six actions using Postman:
- Added employees using POST.
- Retrieved/ Read all employees using GET.
- Retrieved one employee using its ID.
- Updated an employee using PUT.
- Deleted one employee using DELETE.
- Deleted all employees after adding the confirmation.

