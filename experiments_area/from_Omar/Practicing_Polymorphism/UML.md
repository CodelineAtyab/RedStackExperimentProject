+---------------------------------------------------------------+
|                        <<abstract>>                           |
|                           Feedback                            |
+---------------------------------------------------------------+
| - id: int                                                     |
| - customerName: String                                        |
| - message: String                                             |
| - rating: int                                                 |
+---------------------------------------------------------------+
| + Feedback(id, customerName, message, rating)                 |
| + getId(): int                                                |
| + getCustomerName(): String                                   |
| + getMessage(): String                                        |
| + setMessage(message: String): void                           |
| + getRating(): int                                            |
| + setRating(rating: int): void                                |
| + {abstract} getSummary(): String                             |
| + toString(): String                                          |
+---------------------------------------------------------------+
^                          ^                          ^
|                          |                          |
+--------------------+   +---------------------+   +---------------------+
|  WebFormFeedback   |   |   EmailFeedback     |   |   PhoneFeedback     |
+--------------------+   +---------------------+   +---------------------+
|                    |   | - emailAddress: Str |   | - phoneNumber: Str  |
|                    |   |                     |   | - callMinutes: int  |
+--------------------+   +---------------------+   +---------------------+
| + getSummary():Str |   | + getSummary():Str  |   | + getSummary():Str  |
+--------------------+   +---------------------+   +---------------------+

                      +--------------------+
                      |   FeedbackPortal   |
                      +--------------------+
                      | - allFeedback: List|
                      +--------------------+
                      | + addFeedback(...) |
                      | + printReport()    |
                      | + getAverageRating()|
                      +--------------------+