# BLOCKERS

## 1. IntelliJ said the package does not exist

**What I tried:** I opened the project in IntelliJ and built it.

**Error:**
```
java: package kong.unirest does not exist
java: cannot find symbol  class HttpResponse
```

**What I think the cause is:** IntelliJ was building DistanceFinderClient as part of my main from_MohammedAlsiyabi module, so it did not read the pom.xml and did not download Unirest. The pom.xml is correct, because `mvn clean test-compile` gives BUILD SUCCESS.

**Fix:** I ran `mvn clean test-compile` in the terminal first to check the code, and it passed. So I knew the problem was only IntelliJ. Then I opened the DistanceFinderClient folder as its own project in a new window, so IntelliJ reads the pom.xml, downloads Unirest and imports it as a Maven project. After that I rebuilt the project and the red errors went away.

## 2. mvn was not installed

**What I tried:** I ran `mvn clean test-compile` in the terminal.

**Error:**
```
zsh: command not found: mvn
```

**Cause:** Maven was not installed on my Mac.

## 3. brew install maven failed

**What I tried:** `brew install maven`

**Error:** Homebrew warned that my Mac is Intel x86_64 and not supported anymore. It then tried to build cmake and stopped with:
```
Cannot find a C++ compiler that supports both C++11 and the specified C++ flags.
```

**Cause:** Homebrew has no ready-made packages for Intel Macs, so it tried to build everything from source and my compiler tools did not work for it.

**Fix:** I downloaded the Maven zip from the Maven website, unzipped it into ~/tools, and added it to my PATH in ~/.zshrc. I also set JAVA_HOME to Java 17 because I have Java 8 on my Mac too.

## 4. mvn still not found after adding it to PATH

**Error:** `zsh: command not found: mvn`

**Cause:** My terminal tab was opened before I changed ~/.zshrc. After `source ~/.zshrc`, `mvn -v` showed Maven 3.9.16 with Java 17.

## 5. Google returned REQUEST_DENIED

**What I tried:** I ran `mvn compile exec:java` with `GOOGLE_MAPS_API_KEY=your_key_here`.

**Response I got:**
```
Google Maps returned status REQUEST_DENIED: The provided API key is invalid.
```

**Cause:** I was using the placeholder and not a real key. The program did reach the Google server and handled the error without crashing.


## Harder than expected

Setting up Maven and IntelliJ took longer than writing the code.