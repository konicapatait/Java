package com.java.features.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Characterstics of Stream:
 * 1.) Sized/ unbounded
 * 2.) Ordered/ Unordered
 * 3.) Distinct/ Indistinct
 * 4.) Sorted/ Unsorted
 */
public class StreamCharacterstics {
    public static void main(String... args){
        List<Integer> numbers = Arrays.asList(1,2,3 ,4,5,1,2,3,4,5);
        System.out.println("Original List:");
         numbers.stream()
                 .filter(e-> e % 2==0)
                 .forEach(System.out::println);

        System.out.println("Sorted:");
        numbers.stream()
                .filter(e-> e % 2==0)
                .sorted()
                .forEach(System.out::println);

        System.out.println("Distinct:");
        numbers.stream()
                .filter(e-> e % 2==0)
                .distinct()
                .forEach(System.out::println);


    }
}
