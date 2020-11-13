package com.codersyndrome.stream;

import java.util.stream.*;

public class IntermediateOperatorExamples {

    public static void main(String[] args) {

        // INTERMEDIATE RETURN STREAM VALUES
        System.out.println(
                "** INTERMEDIATE OPERATOR RETURN STREAM VALUES, NEEDS TERMINAL OP TO WORK. STREAM OUTPUT CANNOT BE USED ELSE ILLEGALACCESS EXCEPTION ");
        Stream<String> stream = Stream.of("a", "b", "c", "d", "e", "f", "f1", "f12");

        stream.peek(s -> System.out.println(" Printing stream : " + s)).filter(i -> i.length() >= 1)
                .peek(s -> System.out.println(" Printing stream  after filtering: " + s)).distinct()
                .peek(s -> System.out.println(" Printing stream  after distinct: " + s)).skip(2)
                .peek(s -> System.out.println(" Printing stream  after skipping first 2: " + s)).limit(2)
                .peek(s -> System.out.println(" Printing stream  after limiting to 2: " + s)).map(i -> {
                    return i + "ABC";
                }).peek(s -> System.out.println(" Printing stream  after map to add ABC: " + s))
                .forEach(System.out::print);
    }
}