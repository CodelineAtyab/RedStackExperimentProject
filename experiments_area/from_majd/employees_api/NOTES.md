# REST API Notes

## HTTP Methods

- **GET:** Retrieves existing customer data without changing anything.
- **POST:** Creates a new customer and adds it to the collection.
- **PUT:** Updates an existing customer's information using their ID.
- **DELETE:** Removes a customer based on their ID or clears the collection.
- **QUERY:** Uses parameters to filter or provide additional information when requesting data.

## Missing ID Behavior

If a requested customer ID does not exist, return **404 Not Found** with the message `"Customer not found"` for GET, PUT, and DELETE.

## Blockers

- Encountered `400 Bad Request` when testing DELETE without the required confirmation parameter. The exact response was `"Confirmation required"`.
- Harder than expected: Understanding the difference between `@RequestParam` (query parameters) and `@PathVariable` (values in the URL path).