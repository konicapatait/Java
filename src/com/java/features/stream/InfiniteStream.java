package com.java.features.stream;

import java.util.stream.Stream;

public class InfiniteStream {
    public static void main(String... args) {
        System.out.println(Stream.iterate(100, e->e+1));

        //Stream.iterate(100, e->e+1).forEach(System.out::println);

        System.out.println(
        Stream.iterate(100, e->e+1)     // unbounded, lazy
                .filter(e -> e%2 ==0)           // unbounded, lazy
                .filter(e -> Math.sqrt(e) >20)      // unbounded, lazy
                .mapToInt(e -> e*2)             // unbounded, lazy
                .limit(20)                      // sized, lazy
                .sum());                        // Trigger the evaluation

        // To find if the function is lazy or eager evaluation, look for the function output. If the output is Stream, it is Lazy.
        // Any functions that return stream are Lazy evaluation.
    }
}
