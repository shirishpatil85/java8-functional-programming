package com.codersyndrome.stream;

import java.util.stream.*;
import java.util.Optional;
import java.util.OptionalInt;

public class TerminalOperatorExamples {

    public static void main(String[] args) {

        Stream<String> matchStream = Stream.of("abc", "bcd", "bcde");
        Stream<String> matchStream2 = Stream.of("abc", "bcd", "bcde");
        Stream<String> matchStream3 = Stream.of("abc", "bcd", "bcde");
        Stream<String> matchStream4 = Stream.of("abc", "bcd", "bcde");
        Stream<String> matchStream5 = Stream.of("abc", "bcd", "bcde");

        // MATCH
        boolean allContainsC = matchStream.allMatch(p -> p.contains("c"));
        boolean anyContainsE = matchStream2.anyMatch(p -> p.contains("e"));
        boolean noneContainsE = matchStream3.noneMatch(p -> p.contains("e"));

        System.out.println("Stream- abc bcd , bcde - allContainsC = " + allContainsC + " anyContainsE = " + anyContainsE
                + " noneContainsE = " + noneContainsE);

        // SHORT CIRCUIT FIND - FINDFIRST , FINDANY. ENDS EXECUTION ONCE SOME ENTRY IS
        // FOUND
        Optional<String> findFirstResult = matchStream4.findFirst();
        Optional<String> findAnyResult = matchStream5.findFirst();
        System.out.println(
                "Stream- abc bcd , bcde - findFirstResult = " + findFirstResult + "findAnyResult = " + findAnyResult);

        // AGGREGATION - SUM, COUNT, MAX, MIN, REDUCE
        IntStream noStream = IntStream.of(2, 3, 4, 5, 6);
        long count = noStream.count();

        IntStream noStream1 = IntStream.of(2, 3, 4, 5, 6);
        OptionalInt max = noStream1.max();

        IntStream noStream2 = IntStream.of(2, 3, 4, 5, 6);
        OptionalInt min = noStream2.min();

        IntStream intStream = IntStream.of(2, 3, 4, 5, 6);
        OptionalInt answer = intStream.reduce(Integer::sum);
        if (answer.isPresent()) {
            System.out.println(" REDUCE USING BINARYOPERATOR INTEGER::SUM = " + answer.getAsInt());
        } else {
            System.out.println("no value");
        }

        System.out.println("Stream- 22 44 , 55 - count = " + count + "max = " + max + " min =" + min);
    }
}