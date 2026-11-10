# Feedback Encapsulation

A small Java exercise that shows encapsulation. A `Feedback` class keeps its fields private and only accepts valid changes through its setters.

## Files

| File | Purpose |
|------|---------|
| `Feedback.java` | Class with four private fields, a constructor, four getters and two validating setters |
| `Main.java` | Creates two feedback objects and tests valid and invalid changes |

## The Feedback class

Fields (all private): `id`, `customerName`, `message`, `rating`.

Validation rules:

- `setMessage(String)` rejects an empty message and prints `Message cannot be empty`. The old message stays.
- `setRating(int)` accepts only 1 to 5. Anything else prints `Invalid rating: <value>` and the old rating stays.
- The constructor sets `rating` to 1 first, then calls both setters. A bad rating therefore falls back to 1.
- `id` and `customerName` have getters only, so they cannot change after creation.

## Run

From this folder:

```bash
javac Feedback.java Main.java
java Main
```

## Expected output

```
Invalid rating: 9
Message cannot be empty

Feedback 1
ID: 1
Name: Aisha
Message: Great service
Rating: 5

Feedback 2
ID: 2
Name: Sara
Message: The service was helpful
Rating: 3
```

The two warning lines come from the invalid changes on `feedback1`. Its data is unchanged. `feedback2` takes both valid changes.
