# Postman Tests — Issues #549 & #550

Base URL: `http://localhost:8080`  
Header for JSON bodies: `Content-Type: application/json`

---

## 1. EmployeeController (`/employees`)

### POST — Create Employee
- **URL:** `http://localhost:8080/employees`
- **Body:**
  ```json
  {
    "id": "1",
    "name": "Sara",
    "role": "Developer"
  }
  ```
- **Expected Status:** `201 Created`

### GET — Get All Employees
- **URL:** `http://localhost:8080/employees`
- **Expected Status:** `200 OK`

### PUT — Update Employee
- **URL:** `http://localhost:8080/employees/1`
- **Body:**
  ```json
  {
    "id": "1",
    "name": "Sara Ali",
    "role": "Senior Developer"
  }
  ```
- **Expected Status:** `200 OK`

### DELETE — Delete Employee
- **URL:** `http://localhost:8080/employees/1`
- **Expected Status:** `200 OK`

---

## 2. CustomerController (`/customers`)

### POST — Create Customer
- **URL:** `http://localhost:8080/customers`
- **Body:**
  ```json
  {
    "id": "c1",
    "name": "Sara"
  }
  ```
- **Expected Status:** `201 Created`

### GET — Get All Customers
- **URL:** `http://localhost:8080/customers`
- **Expected Status:** `200 OK`

### PUT — Update Customer
- **URL:** `http://localhost:8080/customers/c1`
- **Body:**
  ```json
  {
    "id": "c1",
    "name": "Sara Ali"
  }
  ```
- **Expected Status:** `200 OK`

### DELETE — Delete Customer
- **URL:** `http://localhost:8080/customers/c1`
- **Expected Status:** `200 OK`

---

## 3. FeedbackController (`/feedback`)

### POST — Create Feedback (linked to `c1`)
- **URL:** `http://localhost:8080/feedback`
- **Body:**
  ```json
  {
    "id": "f1",
    "message": "Great service",
    "customerId": "c1"
  }
  ```
- **Expected Status:** `201 Created`

### GET — Get All Feedback
- **URL:** `http://localhost:8080/feedback`
- **Expected Status:** `200 OK`

### PUT — Update Feedback
- **URL:** `http://localhost:8080/feedback/f1`
- **Body:**
  ```json
  {
    "id": "f1",
    "message": "Great service, thanks",
    "customerId": "c1"
  }
  ```
- **Expected Status:** `200 OK`

### DELETE — Delete Feedback
- **URL:** `http://localhost:8080/feedback/f1`
- **Expected Status:** `200 OK`