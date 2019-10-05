package com.java.features.lambda;

public class WhatIsLambda {

    public static void main(String... args) {
        /**
         * A Function has 4 things:
         * 1.) Parameters (2nd most important)
         * 2.) Name
         * 3.) Body (Most importance)
         * 4.) Return type
         */

        Thread t = new Thread(new Runnable(){
            public void run(){
                System.out.println("In Another Thread");
            }
        });
        t.start();
        System.out.println("In Main : "+t.getName());


        /**
         * Since Function's most important components are : 1.) Body 2.) Parameters
         * In below code, Name is anonymous and return type is inferred
         * So, the above code can be written as below by removing the unnecessary noise from the code
         */

        Thread th = new Thread(() ->  System.out.println("In Another Thread (From Lambda)") );
        th.start();
        System.out.println("In Main (Lambda): "+t.getName());

        /**
         *  Lambda is not just the writing a code using different syntax, it also improves the performance.
         *  Using Lambda over inner classes doesn't create a class(also remove the overhead of creating the inner class)
         *  when we compile the class, which allows JVM to
         *  load lesser class and hence lesser object and time spent on GC.
         *  Under the hood, Lambda uses **InvokeDynamic** to call the function.
         */


    }

}


