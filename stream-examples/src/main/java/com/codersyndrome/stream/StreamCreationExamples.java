package com.codersyndrome.stream;

import java.util.*;
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
        Stream<Map.Entry<Integer, String> > mapStream =  map.entrySet().stream();
        mapStream.forEach(System.out::println);

        // FILES.LINES
        try {
            Path pathTempFile = Files.createTempFile("tmp", ".txt");
            Files.write(pathTempFile, "Hello From Temp File\n".getBytes(StandardCharsets.UTF_8));
            Stream<String> lines = Files.lines(pathTempFile);
            System.out.println("\n**FILES.LINES.FOREACH");
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}