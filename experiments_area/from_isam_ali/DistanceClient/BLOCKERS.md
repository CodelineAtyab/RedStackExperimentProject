# Blockers

## 1. Google Cloud required payment info
- **What I tried:** Created a Google Cloud project (TotallyClone) and tried to
  enable the Routes API to get an API key.
- **What I got:** Google asked me to add payment/billing information before I
  could continue.
- **What I think the cause is:** Google Maps Platform APIs require a billing
  account, even when usage stays inside the free allowance.
- **What I did:** Asked my instructor, who agreed that I could use TomTom's
  API instead. The program is now a TomTom client (geocoding + routing).

## 2. `mvn` not recognized in PowerShell
- **What I tried:** Ran `mvn clean test-compile` in PowerShell.
- **What I got:** `mvn` is not recognized as a command.
- **Cause:** Maven was not installed / not on my PATH.
- **Fix:** Installed Maven, added its `bin` folder to PATH and set JAVA_HOME.

## 3. Build failure from a typo
- **What I got:** `Unknown lifecycle phase "test-complie"`.
- **Cause:** I misspelled `test-compile`.
- **Fix:** Used the correct spelling. `BUILD SUCCESS` with Java 17.

## 4. HTTP 401 from TomTom
- **What I tried:** Ran the geocoding request after setting the key with
  `$env:TOMTOM_API_KEY=...` in PowerShell.
- **What I got:** `Status: 401` with
  `{"detailedError":{"code":"Unauthorized","message":"You are missing valid authentication credentials"}}`
- **What I think the cause is:** The variable I set in PowerShell is only visible
  in that window, so the program started from IntelliJ never received the key.
- **What I tried next:** Put a `.env` file next to `Main.java`. The program then
  printed "set the TOMTOM_API_KEY environment variable", because Java does not read
  `.env` files by itself.
- **Fix:** Moved `.env` to the project root and added a small