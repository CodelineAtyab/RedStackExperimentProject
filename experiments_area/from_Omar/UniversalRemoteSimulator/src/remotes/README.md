# Compile
javac -d out $(find src -name "*.java")

# Run with TV remote
java -cp out Main TV

# Run with AC remote
java -cp out Main AC