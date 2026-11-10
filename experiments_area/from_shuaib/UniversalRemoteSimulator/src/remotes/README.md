# Compile
javac -d out src\Main.java src\remotes\*.java

# Run with TV remote
java -cp out org.example.Main TV

# Run with AC remote
java -cp out org.example.Main AC