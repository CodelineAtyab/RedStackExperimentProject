
#201 vs 202
- 201 Created used for `POST` because the item is created immediately.
- 202 Accepted means processed later (MDN Web Docs).

#ResponseEntity
- Returns both the response body and a specific HTTP status code (`200`, `201`, `404`).

#Streams (filter & map)
- filter: Keeps matching items (ex `"Developer"` role).
- map:Transforms each item into another value (ex employee names).

#Blockers & Lessons Learned
- No blockers.
- Handling `404` responses and missing/deleted id cleanly without errors.