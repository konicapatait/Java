# Java 8 Features

## Table of Contents

* Lambda function
* Functional Interface
* Method Reference
* Default Methods
* Streams
* Date/Time API Changes


## Lambda

Lambda function is an anonymous function i.e. a function with no name or without being bounded by identifier.
 
Most important feature of lambda is that **they execute in context of their appearance.** So same lambda function can be executed differently in different context.


## Functional Interface

*Functional interface* permits exactly one abstract method inside them. Java8 introduced an annotation i.e. **@FunctionalInterface** which can be used for compiler level errors when the interface you have annotated violates the contracts of exactly one abstract method.

A functional interface is still valid even if the **@FunctionalInterface** annotation will be omitted.

A functional interface can have as many as  default methods.

If an interface declares an abstract method overriding one of the public methods of *java.lang.Object*, that also doesn't count towards the interface's abstract method count.
E.g. **Comparator** is a functional interface even though it declared two abstract methods since of these abstract method is **equals()** whiach has the signature equals to public method in **Object** class. 

## Method Reference

Method reference is important feature related to lambda expressions, which can let you use the existing method definitions and pass them just like lambda expressions .
In Java, we can use references to object, either by creating the new object or by using the existing objects.

First of all, a method reference can't be used for any method. **They can only be used to replace a single-method lambda expression.**
 
So to use a method reference, you first need a lambda expression with one method. And to use a lambda expression, you first need a functional interface, an interface with just one abstract method.

In other words:
    
    Instead of using

    AN ANONYMOUS CLASS

    you can use

    A LAMBDA EXPRESSION

    And if this just calls one method, you can use

    A METHOD REFERENCE

There are 4 types of method references:

| Type	                                                |  Syntax                                           | Lambda                                                            |   
| ------------------------------------------------------| ------------------------------------------------- | --------------------------------------------------------------    | 
| Reference to a static method                          | ClassName::staticMethodName                       | (args) -> ClassName.staticMethodName(args)                        |
| Reference to an instance method of an existing object | object::instanceMethodName                        | (args) -> object.instanceMethodName(args)                         |
| Reference to an instance method of an arbitrary object of a particular type| ClassName::instanceMethodName| (arg0,rest) -> arg0.instanceMethodName(rest) Note: argo is of type ClassName |
| Reference to a constructor                            | ClassName::new                                    | (args) -> new ClassName(args)                                     |           
