package fibonacci;

import java.util.stream.Stream;

public class Task {
    public static void main(String[] args) {
        //create fibonacci sequence
        Stream.iterate(new int[] {0, 1}, fib -> new int[] {fib[1], fib[0] + fib[1]})
                .limit(7)
                .map(fib -> fib[0]) //extract the first element of each pair
                .forEach(System.out::println);
    }
}
