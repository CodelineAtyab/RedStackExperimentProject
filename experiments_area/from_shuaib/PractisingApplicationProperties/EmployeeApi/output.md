# Postman Test Suite — Feedback & Customer ID

## Setup
- **Local Base URL:** `http://localhost:8081`
- **LAN / Second-Device Base URL (`server.address=0.0.0.0`):** `http://<your-private-ip>:8081`
- **Default Header for `POST` requests:** `Content-Type: application/json`

Run requests **1 through 6 in order** so in-memory state builds up properly. Record the actual response status and JSON/text output for your PR.

---

## 1. Create Customer (`c1`)
- **Method:** `POST`
- **URL:** `http://localhost:8081/customers`
- **Body (`raw` -> `JSON`):**
  ```json
  {
    "id": "c1",
    "name": "Sara"
  }
  ```

---

## 2. Create Feedback with Valid `customerId` (`c1`)
- **Method:** `POST`
- **URL:** `http://localhost:8081/feedback`
- **Body (`raw` -> `JSON`):**
  ```json
  {
    "id": "f1",
    "message": "Great service",
    "customerId": "c1"
  }
  ```

---

## 3. Get Single Feedback (`f1`)
- **Method:** `GET`
- **URL:** `http://localhost:8081/feedback/f1`

---

## 4. Get All Feedback
- **Method:** `GET`
- **URL:** `http://localhost:8081/feedback`

---

## 5. Reject Feedback with Unknown `customerId` (`nope`)
- **Method:** `POST`
- **URL:** `http://localhost:8081/feedback`
- **Body (`raw` -> `JSON`):**
  ```json
  {
    "id": "f2",
    "message": "Hi",
    "customerId": "nope"
  }
  ```

---

## 6. Reject Feedback with Missing/Blank `customerId`
- **Method:** `POST`
- **URL:** `http://localhost:8081/feedback`
- **Body (`raw` -> `JSON`):**
  ```json
  {
    "id": "f3",
    "message": "No customer"
  }
  ```