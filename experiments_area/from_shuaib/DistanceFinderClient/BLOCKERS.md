# Blockers

- **Issue:** Full live API calls require billing account validation (credit card setup) within Google Cloud to activate the Directions API key.
- **What was tried:** Created project, added dependencies, and structured the HTTP request client logic.
- **Resolution:** Implemented the complete client code architecture and JSON parsing logic using a secure environment variable lookup with a fallback placeholder (`YOUR_API_KEY_HERE`) to satisfy security and repository structure compliance. The project compiles successfully via `mvn clean test-compile`.