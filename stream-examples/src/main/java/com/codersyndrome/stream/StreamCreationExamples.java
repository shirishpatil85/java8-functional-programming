package com.codersyndrome.stream;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class StreamCreationExamples {

    public static void main(String[] args) {

        // ARRAYS.STREAM.FOREACH
        String[] arr = { "strItem1", "strItem2" };
        Stream<String> stream = Arrays.stream(arr);
        System.out.println("\n** ARRAYS.STREAM.FOREACH");
        stream.forEach(str -> System.out.print(str + " "));

        // STREAM TO ARRAY
        Stream<String> strToArr = Stream.of("A1", "A2");
        System.out.println("\n ** Stream to array = " + Arrays.toString(strToArr.toArray()));

        // LIST.STREAM.FOREACH
        Stream<String> listStream = new ArrayList<String>(Arrays.asList("listItem1", "listItem2")).stream();
        System.out.println("\n** LIST.STREAM.FOREACH");
        listStream.forEach(System.out::print);

        // SET.STREAM.FOREACH
        Stream<String> setStream = new HashSet<String>(Arrays.asList("setItem1", "setItem2")).stream();
        System.out.println("\n** SET.STREAM.FOREACH");
        setStream.forEach(System.out::print);

        // MAP.ENTRYSET.STREAM
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "A");
        map.put(2, "B");
        System.out.println("\n** MAP.ENTRYSET.STREAM.FOREACH");
        Stream<Map.Entry<Integer, String>> mapStream = map.entrySet().stream();
        mapStream.forEach(System.out::println);

        // STREAM TO COLLECTION
        Stream<String> strToList = Stream.of("A1", "A2");
        Stream<String> strToSet = Stream.of("S1", "S2");
        List<String> listFromStr = strToList.map(p -> p + "1").collect(Collectors.toList());
        Set<String> setFromStr = strToSet.map(p -> p + "1").collect(Collectors.toSet());
        List<String> givenList = new ArrayList<String>();
        givenList.add("a");
        givenList.add("b");
        givenList.add("c");
        Map<String, Integer> mapFromStr = givenList.stream()
                .collect(Collectors.toMap(value -> value, value -> value.length()));

        System.out.println("\n\n **  listFromStr = " + listFromStr);
        System.out.println("\n\n ** setFromStr = " + setFromStr);
        System.out.println("\n\n ** mapFromStr = " + mapFromStr);

        // FILES.LINES
        try {
            Path pathTempFile = Files.createTempFile("tmp", ".txt");
            Files.write(pathTempFile, "Hello From Temp File\n".getBytes(StandardCharsets.UTF_8));
            Stream<String> lines = Files.lines(pathTempFile);
            System.out.println("\n**FILES.LINES.FOREACH");
            lines.forEach(System.out::println);
            lines.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // STREAM CONCAT
        Stream<String> stream1 = Stream.of("STR1", "STR12");
        Stream<String> stream2 = Stream.of("STR2", "STR22");
        Stream<String> concatStream = Stream.concat(stream1, stream2);
        System.out.println("\n\n ** concatStream =");
        concatStream.forEach(System.out::println);

        // STREAM BUILDER FOR APPENDING STREAM ELEMENTS AFTER INIT
        Stream.Builder<String> b = Stream.builder();
        b.accept("buil");
        b.accept("der");
        Stream<String> s = b.build();
        s.forEach(System.out::println);

        // OPTIONAL - USED TO CAPTURE RESULT OF AGGREGATION AND SHORT-CIRCUIT TERMINAL
        // OPERATIONS
        Stream<String> matchStream4 = Stream.of("abc", "bcd", "bcde");
        Optional<String> findFirstResult = matchStream4.findFirst();
        System.out.println("Stream- abc bcd , bcde - findFirstResult = " + findFirstResult);

        // PARALLEL STREAM
        IntStream range2 = IntStream.rangeClosed(1, 10);
        System.out.println("** Parallel printing of Stream 1-10");
        range2.parallel().forEach(System.out::println);
        List<String> alpha = Arrays.asList(new String[] { "A", "B", "C", "D", "E" });
        System.out.println("** Parallel printing of Stream A-E");
        alpha.parallelStream().forEach(System.out::println);
    }
}