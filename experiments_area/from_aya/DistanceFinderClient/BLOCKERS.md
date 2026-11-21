# BLOCKERS

## 1. Missing Libraries

**Problem:** GitHub Actions showed errors:

- `package kong.unirest does not exist`
- `package com.google.gson does not exist`

**What I tried:** I tried compiling the Java file.

**Possible cause:** The external libraries were not loaded.

**Solution:** Use Maven and add the required dependencies.

## 2. Difficulties

Understanding the API request and reading the JSON response was harder than expected.