package com.java.features.methodreference;


import java.util.Arrays;
import java.util.List;

public class WhatIsMethodReference {
    /**
     * Only useful in a simplest and trivial use case i.e. when you getting the parameter and you don't want to do anything but pass through.
     * Should not be used if you have to do anything with the value
     *
     * Different options to use the method reference:
     * 1.) parameter as an argument
     * 2.) parameter as an argument to a static method
     * 3.) parameter as a target
     * 4.) two parameters as arguments
     * 5.) two parameters, one as target and other as an argument
     */
    public static void main(String... args){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        /**
         * This is calling the instance method println on out instance
         */
        numbers.forEach(System.out::println);

        /**
         * Method reference on static method.
         *  Here, element become the parameter to the function
         */
        numbers.stream()
                //.map(number -> String.valueOf(number));
                .map(String::valueOf)
                .forEach(System.out::println);

        /**
         * If element become the target.
         * The syntax is exactly same for static method and when element become the target
         */

        numbers.stream()
                .map(String::valueOf) // Calling static method of String class and passing the element as parameter
                .map(String::toString) // Calling the instance method of String class on the element.
                .forEach(System.out::println);

        /********************************************************************************************/
        /**
         * How to use method reference on 2 parameters?
         *
         */

        System.out.println(numbers.stream().reduce(0,(total, element) -> {
                    System.out.println("Total:"+total);
                    System.out.println("element:"+element);
            return Integer.sum(total,element);
        }
        ));
        System.out.println(numbers.stream().reduce(0,(total, element) -> Integer.sum(total, element)));
        System.out.println(numbers.stream().reduce(0,Integer::sum));



        /**
         * Method reference can be used when one element becomes the target
         */

        numbers.stream().map(String::valueOf).reduce("",(carry, str)-> carry.concat(str)); // Lambda Version
        /**
         * Above code can be rewritten as below with method reference. concat function is called on `carry`
         * and `str` is passed as the parameter.
         */
        numbers.stream().map(String::valueOf).reduce("",String::concat); // Method Reference Version

        /********************************************************************************************/

    }


}


