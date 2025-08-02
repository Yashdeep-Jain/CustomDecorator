package com.example.decorator;

@FunctionalInterface
public interface SimpleOperation<R>{
    R execute();
}
