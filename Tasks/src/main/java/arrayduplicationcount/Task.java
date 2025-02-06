package main.java.arrayduplicationcount;

import java.util.*;
import java.util.stream.Collectors;

//duplication counting in an array
public class Task {
    public static void main(String[] args) {
        int[] array = {1, 1, 1, 2, 2, 4, 4, 4, 4, 5};
        Map<Integer, Long> mapStream = Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        mapStream.entrySet().forEach(System.out::println);
    }
}
