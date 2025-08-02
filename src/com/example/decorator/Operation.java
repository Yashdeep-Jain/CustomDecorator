package com.example.decorator;

@FunctionalInterface
public interface Operation<T, R> {
    R execute(T input);
}
