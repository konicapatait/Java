package com.java.features.methodreference.staticmr;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class MainClass {

    public static void main(String... args) {
        List listOfNumbers = Arrays.asList(20, 13, 40, 10, 5);

        // Using an anonymous class
        Numbers.findNumbers("Using Anonymous Class", listOfNumbers, new BiPredicate<Integer,Integer>() {
            @Override
            public boolean test(Integer int1, Integer int2) {
                return Numbers.isMorethan30(int1, int2);
            }
        });

        // Using a lambda expression
        Numbers.findNumbers("Using Lambda Expression", listOfNumbers, (int1, int2) -> Numbers.isMorethan30(int1, int2));

        // Using a method reference
        Numbers.findNumbers("Using Method Reference", listOfNumbers, Numbers::isMorethan30);


    }
}
