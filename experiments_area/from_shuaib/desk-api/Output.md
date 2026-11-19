# Output — Issue #595 (Part 2)

## Postman Testing (Section A)

### 1. POST `/employees` — Create employee
- **Request Body:** `{"id":"1","name":"Sara","role":"Developer"}`
- **Status:** `201 Created`
- **Response Body:**
```json
{
  "id": "1",
  "name": "Sara",
  "role": "Developer"
}