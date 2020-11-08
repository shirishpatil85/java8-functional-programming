package com.codersyndrome.lambda;

import java.util.function.Consumer;
import java.util.function.BiConsumer;
import java.util.function.DoubleConsumer;
import java.util.function.LongConsumer;
import java.util.function.IntConsumer;

import java.util.List;
import java.util.Arrays;

public class ConsumerExamples {
    public static void main(String args[]) 
    { 
        System.out.println("** CONSUMER ACCEPT METHOD HAS NO OUTPUT AND ONE INPUT");
        System.out.println("** CONSUMER ACCEPT METHOD CAN BE USED TO POINT TO LAMBDA OR METHOD REFERENCES AND EXECUTED");
        Consumer<Integer> consumer1 = (a) -> System.out.println(a); 
        consumer1.accept(10);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Consumer<Integer> consumer2 = (Integer x) -> System.out.println(x);
        System.out.println("** CONSUMER USES VISITOR PATTERN TO ITERATE THROUGH");
        operateOnElements(list, consumer2);

        System.out.println("** CONSUMER andThen DEFAULT METHOD CAN BE USED FOR CHAINING");
        Consumer<Integer> consumer3 = (a) -> System.out.println("HELLO FROM CONSUMER3 TO ->" + a );
        operateOnElements(list,consumer2.andThen(consumer3));

        BiConsumer<Integer, Integer> biConsumer = (a,b) -> { System.out.println("** BICONSUMER SUM = " + (a + b));} ;
        biConsumer.accept(10, 20);

        IntConsumer intConsumer = (x) -> { System.out.println("** INTEGER OVERFLOW 1000000 * 1000000 = " + x*x); };
        LongConsumer longConsumer = (x) -> { System.out.println("** LONG VALUE 1000000 * 1000000 = " +x*x); };
        DoubleConsumer doubleConsumer = (x) -> { System.out.println("** DOUBLE VALUE 1000000 * 1000000 = "+ x*x); };

        System.out.println("** INT / DOUBLE / LONG CONSUMER TAKES SPECIFIC ARG");
        intConsumer.accept(1000000);
        longConsumer.accept(1000000);
        doubleConsumer.accept(1000000);

    }
    static <T> void operateOnElements(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}