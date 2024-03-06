package org.example.functionalInterface;

@FunctionalInterface
public interface TestInterface<T> {
    void fun1(T t);

    default void fun2() {
        System.out.println("Default Method");
    }

//    void fun2();
}
