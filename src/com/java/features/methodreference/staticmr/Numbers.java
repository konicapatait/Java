package com.java.features.methodreference.staticmr;

import java.util.List;
import java.util.function.BiPredicate;

public class Numbers {

    public static boolean isMorethan30(Integer i1, Integer i2) {
        return i1+i2 > 30;
    }

    public static void findNumbers(String callType, List<Integer> integers , BiPredicate<Integer,Integer> predicate){
        System.out.println(callType);
        for(Integer integer : integers){
            if(predicate.test(integer, integer+5)){
                System.out.println("Number is "+ integer);
            }
        }

    }


}
