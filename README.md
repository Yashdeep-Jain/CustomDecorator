# Logging Decorator Pattern in Java

A comprehensive implementation of the Decorator Pattern in Java for adding logging functionality to any method or function without modifying the original code.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Usage](#usage)
- [Examples](#examples)
- [API Reference](#api-reference)
- [Design Patterns](#design-patterns)
- [Contributing](#contributing)
- [License](#license)

## 🎯 Overview

This project demonstrates how to implement a custom logging decorator in Java that can wrap around any function to provide:

- **Entry/Exit Logging**: Tracks when methods are called and completed
- **Parameter/Return Value Logging**: Logs input parameters and return values
- **Performance Monitoring**: Measures and logs execution time
- **Exception Handling**: Captures and logs exceptions with execution context
- **Timestamp Tracking**: All logs include formatted timestamps

## ✨ Features

- 🕒 **Timestamp Logging**: Every log entry includes a formatted timestamp
- 📊 **Performance Metrics**: Automatic execution time measurement
- 🔍 **Parameter Tracking**: Logs input parameters and return values
- ⚠️ **Exception Handling**: Comprehensive error logging without breaking flow
- 🧩 **Multiple Interfaces**: Support for various function types
- 🚀 **Zero Modification**: Add logging without changing existing code
- 📦 **Modular Design**: Clean separation of concerns

## 📁 Project Structure

```
src/
└── com/
    └── example/
        ├── decorator/           # Decorator pattern implementation
        │   ├── Operation.java          # Generic operation interface
        │   ├── SimpleOperation.java    # No-parameter operation interface
        │   └── LoggingDecorator.java   # Main decorator class
        ├── business/            # Sample business logic
        │   ├── Calculator.java         # Mathematical operations
        │   └── StringProcessor.java    # String manipulation operations
        └── demo/               # Demonstration code
            └── LoggingDecoratorDemo.java
```

## 🚀 Installation

### Prerequisites

- Java 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code)

### Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/logging-decorator-java.git
   cd logging-decorator-java
   ```

2. **Compile the project:**
   ```bash
   javac -d build src/com/example/**/*.java
   ```

3. **Run the demo:**
   ```bash
   java -cp build com.example.demo.LoggingDecoratorDemo
   ```

## 💡 Usage

### Basic Usage

```java
import com.example.decorator.LoggingDecorator;
import com.example.decorator.Operation;

// Wrap any operation with logging
Operation<String, String> loggedOperation = LoggingDecorator.withLogging(
    input -> someMethod(input),
    "methodName"
);

String result = loggedOperation.execute("test input");
```

### Using with Function Interface

```java
import java.util.function.Function;

Function<String, String> loggedFunction = LoggingDecorator.withLogging(
    String::toUpperCase,
    "toUpperCase"
);

String result = loggedFunction.apply("hello world");
```

### No-Parameter Operations

```java
import com.example.decorator.SimpleOperation;

SimpleOperation<String> loggedOperation = LoggingDecorator.withLogging(
    () -> getCurrentTimestamp(),
    "getCurrentTimestamp"
);

String result = loggedOperation.execute();
```

## 📋 Examples

### Example Output

```
[2024-08-02 15:30:45] [ENTRY] reverseString called with parameter: Hello World
[2024-08-02 15:30:45] [EXIT] reverseString completed successfully
[2024-08-02 15:30:45] [RESULT] reverseString returned: dlroW olleH
[2024-08-02 15:30:45] [PERFORMANCE] reverseString execution time: 2ms
Final result: dlroW olleH
```

### Error Handling Example

```
[2024-08-02 15:30:46] [ENTRY] divide called with parameter: [10.0, 0.0]
[2024-08-02 15:30:46] [ERROR] divide failed with exception: Division by zero is not allowed
[2024-08-02 15:30:46] [PERFORMANCE] divide execution time: 1ms
```

## 📚 API Reference

### LoggingDecorator Class

#### Methods

| Method | Description | Parameters | Returns |
|--------|-------------|------------|---------|
| `withLogging(Operation<T,R>, String)` | Wraps an Operation with logging | operation, methodName | Decorated Operation |
| `withLogging(SimpleOperation<R>, String)` | Wraps a SimpleOperation with logging | operation, methodName | Decorated SimpleOperation |
| `withLogging(Function<T,R>, String)` | Wraps a Function with logging | function, methodName | Decorated Function |

### Interfaces

#### Operation<T, R>
```java
@FunctionalInterface
public interface Operation<T, R> {
    R execute(T input);
}
```

#### SimpleOperation<R>
```java
@FunctionalInterface
public interface SimpleOperation<R> {
    R execute();
}
```

## 🏗️ Design Patterns

This project implements several design patterns:

### 1. **Decorator Pattern**
- Adds logging behavior to existing functions without modifying them
- Maintains the same interface as the original function
- Allows for multiple decorators to be chained

### 2. **Strategy Pattern**
- Different logging strategies can be implemented
- Flexible approach to handling various operation types

### 3. **Template Method Pattern**
- Common logging logic is templated
- Specific behaviors are customized per operation type

## 🔧 Extending the Decorator

### Adding New Decorator Types

```java
// Example: Adding a timing-only decorator
public static <T, R> Operation<T, R> withTiming(Operation<T, R> operation, String methodName) {
    return input -> {
        long startTime = System.currentTimeMillis();
        R result = operation.execute(input);
        long executionTime = System.currentTimeMillis() - startTime;
        System.out.println(methodName + " took " + executionTime + "ms");
        return result;
    };
}
```

### Chaining Decorators

```java
// Chain multiple decorators
Operation<String, String> decorated = LoggingDecorator.withLogging(
    TimingDecorator.withTiming(
        input -> processor.process(input),
        "process"
    ),
    "process"
);
```

## 🧪 Testing

### Running Tests

```bash
# Compile and run the demo
javac -d build src/com/example/**/*.java
java -cp build com.example.demo.LoggingDecoratorDemo
```

### Sample Test Cases

- ✅ Basic operation logging
- ✅ Exception handling and logging
- ✅ Performance measurement
- ✅ Parameter and result logging
- ✅ No-parameter operation support

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Contribution Guidelines

- Follow Java naming conventions
- Add JavaDoc comments for public methods
- Include unit tests for new features
- Update README.md if needed

## 🙏 Acknowledgments

- Inspired by the Gang of Four Design Patterns
- Built using Java 8+ functional programming features
- Follows SOLID principles for clean, maintainable code
---

⭐ **Star this repository if you found it helpful!**
