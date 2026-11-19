# Pair JSON Exchange – Testing Notes

## 1. Partner Information

- **My name:** Alaa
- **Partner's name:** Reham

## 2. Testing

### Round 1 – My Server → Reham's Client

- **Server:** Alaa's computer
- **Client:** Reham's computer
- **Result:** Successful

**Actual output from Reham's client:**

```text
Name: alaa
1 - Coffee
2 - Books
3 - Football
```

The client successfully connected to my Spring Boot server, received the JSON response, deserialized it, and printed the name and favourite items in the expected format.

### Round 2 – Reham's Server → My Client

- **Server:** Reham's computer
- **Client:** Alaa's computer
- **Result:** Successful, the output matches the goal output

## 3. Additional Learning Notes

Initially, I created JSON objects manually inside my Spring Boot controller to construct the response.

However, I later realised that Spring Boot handles JSON serialization automatically when returning Java objects from a controller. It converts Java objects into JSON responses, so there is no need to manually construct JSON objects in the controller.

This helped me better understand the relationship between Java objects, JSON serialization, and deserialization when communicating between a Spring Boot server and a Java client.

## 4. Blockers

No blockers.

## 5. What Was Harder Than Expected?

Understanding how Spring Boot handles JSON serialization was harder than expected. Initially, I thought I needed to create the JSON response manually, but I learned that Spring Boot can automatically convert Java objects into JSON.