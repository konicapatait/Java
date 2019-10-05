package com.java.features.methodreference.staticmr;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class MainClass {

    public static void main(String... args) {
        List listOfNumbers = Arrays.asList(20, 13, 40, 10, 5, 120);

        // Using an anonymous class
        findNumbers("Using Anonymous Class", listOfNumbers, new BiPredicate<Integer, Integer>() {
            @Override
            public boolean test(Integer int1, Integer int2) {
                return Numbers.isMorethan30(int1, int2);
            }
        });

        // Using a lambda expression
        findNumbers("Using Lambda Expression", listOfNumbers, (int1, int2) -> Numbers.isMorethan30(int1, int2));

        // Using a method reference if number is greater than 30
        findNumbers("Using Method Reference(Number greater than 30)", listOfNumbers, Numbers::isMorethan30);

        // Using a method reference if number is greater than 50
        findNumbers("Using Method Reference(Number greater than 50)", listOfNumbers, Numbers::isMorethan50);

        // Using a method reference if number is greater than 100
        findNumbers("Using Method Reference(Number greater than 100)", listOfNumbers, Numbers::isMorethan100);
    }

    public static void findNumbers(String callType, List<Integer> integers, BiPredicate<Integer, Integer> predicate) {
        System.out.println(callType);
        for (Integer integer : integers) {
            if (predicate.test(integer, integer + 5)) {
                System.out.println("Number is " + integer);
            }
        }

    }

}
