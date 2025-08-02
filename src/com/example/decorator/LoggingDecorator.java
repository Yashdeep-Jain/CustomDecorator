package com.example.decorator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

public class LoggingDecorator {
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Decorator for operations with input and output
    public static <T, R> Operation<T, R>  withLogging(Operation<T, R> operation, String methodName) {
        return input -> {
            long startTime = System.currentTimeMillis();
            String timeStamp = LocalDateTime.now().format(TIME_FORMAT);

            System.out.println("[" + timeStamp + "] [ENTRY] " + methodName + "called with parameter: " + input);

            try {
                R result = operation.execute(input);
                long executionTime = System.currentTimeMillis() - startTime;

                System.out.println("[" + timeStamp + "] [EXIT] " + methodName + " executed successfully");
                System.out.println("[" + timeStamp + "] [RESULT] " + methodName + "returned: " + result);
                System.out.println("[" + timeStamp + "] [PERFORMANCE] " + methodName + executionTime + " ms");

                return result;

            } catch (Exception e) {
                long executionTime = System.currentTimeMillis() - startTime;
                System.out.println("[" + timeStamp + "] [ERROR] " + methodName + " failed with exception: " + e.getMessage());
                System.out.println("[" + timeStamp + "] [PERFORMANCE] " + methodName + " execution time: " + executionTime + "ms");
                throw e; // rethrow the exception after logging
            }
        };
    }

    // Decorator for operations without parameters
//    public static <T, R> SimpleOperation<R> withLogging(SimpleOperation<R> operation, String methodName) {
//        return () -> {
//            long startTime = System.currentTimeMillis();
//            String timestamp = LocalDateTime.now().format(TIME_FORMAT);
//
//            System.out.println("[" + timestamp + "] [ENTRY] " + methodName + " called");
//
//            try {
//                R result = operation.execute();
//                long executionTime = System.currentTimeMillis() - startTime;
//
//                System.out.println("[" + timestamp + "] [EXIT] " + methodName + " completed successfully");
//                System.out.println("[" + timestamp + "] [RESULT] " + methodName + " returned: " + result);
//                System.out.println("[" + timestamp + "] [PERFORMANCE] " + methodName + " execution time: " + executionTime + "ms");
//
//                return result;
//            } catch (Exception e) {
//                long executionTime = System.currentTimeMillis() - startTime;
//                System.out.println("[" + timestamp + "] [ERROR] " + methodName + " failed with exception: " + e.getMessage());
//                System.out.println("[" + timestamp + "] [PERFORMANCE] " + methodName + " execution time: " + executionTime + "ms");
//                throw e;
//            }
//        };
//    }


    // Decorator using Java 8 Function interface
//    public static <T, R> Function<T, R> withLogging(Function<T, R> function, String methodName) {
//        return input -> {
//            long startTime = System.currentTimeMillis();
//            String timestamp = LocalDateTime.now().format(TIME_FORMAT);
//
//            System.out.println("[" + timestamp + "] [ENTRY] " + methodName + " called with parameter: " + input);
//
//            try {
//                R result = function.apply(input);
//                long executionTime = System.currentTimeMillis() - startTime;
//
//                System.out.println("[" + timestamp + "] [EXIT] " + methodName + " completed successfully");
//                System.out.println("[" + timestamp + "] [RESULT] " + methodName + " returned: " + result);
//                System.out.println("[" + timestamp + "] [PERFORMANCE] " + methodName + " execution time: " + executionTime + "ms");
//
//                return result;
//            } catch (Exception e) {
//                long executionTime = System.currentTimeMillis() - startTime;
//                System.out.println("[" + timestamp + "] [ERROR] " + methodName + " failed with exception: " + e.getMessage());
//                System.out.println("[" + timestamp + "] [PERFORMANCE] " + methodName + " execution time: " + executionTime + "ms");
//                throw e;
//            }
//        };
//    }
}
