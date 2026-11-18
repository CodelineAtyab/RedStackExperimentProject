# Employees REST API

## Run
```bash
mvn spring-boot:run
```

Open `http://localhost:8080/employees` to see the empty array `[]`.

## Postman requests
| Method | URL | JSON body | Expected status |
|---|---|---|---|
| POST | `http://localhost:8080/employees` | `{"id":"1","name":"Sara"}` | 201 |
| POST | `http://localhost:8080/employees` | `{"id":"2","name":"Ali"}` | 201 |
| GET | `http://localhost:8080/employees` | none | 200 |
| GET | `http://localhost:8080/employees/2` | none | 200 |
| PUT | `http://localhost:8080/employees/2` | `{"id":"2","name":"Ali Khan"}` | 200 |
| DELETE | `http://localhost:8080/employees/1` | none | 200 |
| DELETE | `http://localhost:8080/employees` | none | 400 |
| DELETE | `http://localhost:8080/employees?confirm=true` | none | 200 |
| GET | `http://localhost:8080/employees` | none | 200 (`[]`) |
| GET | `http://localhost:8080/employees/999` | none | 404 |



