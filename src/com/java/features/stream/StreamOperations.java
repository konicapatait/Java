package com.java.features.stream;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Stream Operations can be used to create the:
 * List
 * Set
 * Map
 */
public class StreamOperations {
    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);

        /** Double the even values and put that in list **/

        List doubleOfEvenWrong = new ArrayList();

        /** Stream is trying to modify/mutate the shared variable( i.e. doubleOfEvenWrong)**/
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .map(i -> i * 2.0)  // taking integer and returning double
                .forEach(e -> doubleOfEvenWrong.add(e));    // **DON'T DO THIS**. Shared mutability is devil's work

        System.out.println(doubleOfEvenWrong);

        List doubleOfEven = numbers.stream()
                .filter(i -> i % 2 == 0)
                .map(i -> i * 2.0)  // taking integer and returning double
                .collect(Collectors.toList());

        System.out.println(doubleOfEven);

        Set doubleOfEvenInSet = numbers.stream()
                .filter(i -> i % 2 == 0)
                .map(i -> i * 2.0)  // taking integer and returning double
                .collect(Collectors.toSet());

        System.out.println(doubleOfEvenInSet);


        List<Person> people = Arrays.asList(
                new Person("Garima", 27, "Female"),
                new Person("Nishi", 21, "Female"),
                new Person("Sachit", 24, "Male"),
                new Person("Shubham", 27, "Male"),
                new Person("Harsh", 15, "Male"),
                new Person("Garima", 31, "Female")

        );

        Map ListToMap = people.stream().collect(toMap(
                person -> person.getName() + "-" + person.getAge(),
                person -> person
        ));

        System.out.println("Map from a Stream::" + ListToMap);

        /**
         * Given the list of people, create a map where key is their name and value is all the people with that name
         */

        Map mapOfList = people.stream().collect(groupingBy(Person::getName));

        System.out.println("Map of list from a Stream::" + mapOfList);

        /**
         * Given the list of people, create a map where key is their name and value is all the ages of people with that name
         */

        Map mapOfList2 = people.stream().collect(groupingBy(Person::getName, mapping(Person::getAge, toList())));

        System.out.println("Map of list from a Stream::" + mapOfList2);

    }
}
