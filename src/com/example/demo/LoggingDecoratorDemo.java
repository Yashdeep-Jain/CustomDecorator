package com.example.demo;

import com.example.decorator.LoggingDecorator;
import com.example.decorator.Operation;
import com.example.decorator.SimpleOperation;
import com.example.business.Calculator;
import com.example.business.StringProcessor;

import java.util.function.Function;
import java.time.LocalDateTime;

public class LoggingDecoratorDemo {
    public static void main(String[] args) {
        System.out.println("=== Logging Decorator Demo ===\n");

        Calculator calc = new Calculator();
        StringProcessor processor = new StringProcessor();

        // Example 1: Using custom Operation interface
        System.out.println("1. Using custom Operation interface:");
        Operation<String, String> loggedReverse = LoggingDecorator.withLogging(
                input -> processor.reverseString(input),
                "reverseString"
        );

        String result1 = loggedReverse.execute("Hello World");
        System.out.println("Final result: " + result1 + "\n");

        // Example 2: Using Function interface with method reference
//        System.out.println("2. Using Function interface with method reference:");
//        Function<String, String> loggedUpperCase = LoggingDecorator.withLogging(
//                processor::toUpperCase,
//                "toUpperCase"
//        );

//        String result2 = loggedUpperCase.apply("java decorator pattern");
//        System.out.println("Final result: " + result2 + "\n");

        // Example 3: Using SimpleOperation for no-parameter methods
//        System.out.println("3. Using SimpleOperation for no-parameter methods:");
//        SimpleOperation<String> loggedCurrentTime = LoggingDecorator.withLogging(
//                () -> LocalDateTime.now().toString(),
//                "getCurrentTimestamp"
//        );

//        String result3 = loggedCurrentTime.execute();
//        System.out.println("Final result: " + result3 + "\n");

        // Example 4: Chaining multiple decorators
        System.out.println("4. Using with calculator operations:");
        Operation<int[], Integer> loggedAdd = LoggingDecorator.withLogging(
                input -> calc.add(input[0], input[1]),
                "add"
        );

        int[] addParams = {15, 25};
        int result4 = loggedAdd.execute(addParams);
        System.out.println("Final result: " + result4 + "\n");

        // Example 5: Demonstrating error handling
        System.out.println("5. Demonstrating error handling:");
        Operation<Double[], Double> loggedDivide = LoggingDecorator.withLogging(
                input -> calc.divide(input[0], input[1]),
                "divide"
        );

        try {
            Double[] params = {10.0, 0.0}; // This will cause division by zero
            loggedDivide.execute(params);
        } catch (Exception e) {
            System.out.println("Caught exception in main: " + e.getMessage());
        }

        System.out.println("\n=== Demo Complete ===");
    }
}