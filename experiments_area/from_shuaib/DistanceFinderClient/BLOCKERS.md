# Blockers

- **Issue 1: Google Maps API Billing Requirement**
  - **Details:** Generating an active API key for the Google Maps Directions API requires linking a billing account and credit card in Google Cloud Console, even for free-tier testing.
  - **What was tried:** Created a Google Cloud project, tested request structures with placeholder keys, and verified `REQUEST_DENIED` error handling.
  - **Resolution:** Pivoted the routing provider to **OSRM (Open Source Routing Machine)** (`router.project-osrm.org`), which requires no API key or billing account, allowing full end-to-end live HTTP testing.

- **Issue 2: Coordinate Ordering & Package Declaration**
  - **Details:** Encountered a `Missing package statement` compiler error due to directory alignment, and noted that OSRM expects `longitude,latitude` rather than standard `latitude,longitude` ordering.
  - **Resolution:** Added the matching `package` declaration at the top of the Java source file and formatted Muscat (`58.3829,23.5880`) and Sohar (`56.7088,24.3468`) coordinates in `longitude,latitude` order.