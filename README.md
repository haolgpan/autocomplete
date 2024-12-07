# Autocomplete

A simple Java application that suggests words as you type, similar to a search engine's autocomplete feature.

## Features
- Shows up to 4 suggestions in alphabetical order
- Case-insensitive search
- Supports words with spaces and special characters
- Real-time suggestions as you type

## Prerequisites
- Java JDK 11 or higher
- JUnit 4 for running tests
- VS Code with "Extension Pack for Java" and "Test Runner for Java" or IntelliJ IDEA

## Project Structure

project/
├── src/
│ ├── main/
│ │ └── java/
│ │ ├── TextPredictor.java # Core prediction logic
│ │ ├── UserInterface.java # Swing UI implementation
│ │ └── Main.java # Application entry point
│ └── test/
│   └── java/
│       └── TextPredictorTest.java # Unit tests


## Running the Application

### Using VS Code
1. Clone the repository
2. Open the project in VS Code
3. Run `Main.java`

### Using IntelliJ IDEA
1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Right-click on `Main.java`
4. Select "Run 'Main.main()'"

## Running Tests

### Using VS Code
1. Open `TextPredictorTest.java`
2. Click the "Run Test" button above any test method
3. Or use the Test Explorer in VS Code

### Using IntelliJ IDEA
1. Open `TextPredictorTest.java`
2. Click the green play button next to the class or individual test
3. Or right-click on the test folder and select "Run Tests"

## Test Cases
- Empty input
- Case sensitivity
- Special characters
- Maximum results limit
- Words with spaces
- Non-matching searches

## Screenshots
![Autocomplete Demo](screenshots/demo.png)

## License
MIT License - feel free to use this code for any purpose.