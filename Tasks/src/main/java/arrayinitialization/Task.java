package arrayinitialization;
import java.util.stream.Stream;

public class Task {
    public static void main(String[] args) {
        //initialize an array by unique values randomly in increasing order
        //size could be less than the pointed value due to distinct operation
        int[] array = arrayInitialization(5);
        for (int i = 0; i < array.length; i++) {
            System.out.println(String.format("array[%d] = %d", i, array[i]));
        }

        //get even numbers from stream
        System.out.println("--------------");
        Stream.iterate(0, n -> n + 2)
                .limit(5)
                .forEach(System.out::println);

        //get 2**n numbers from stream
        System.out.println("--------------");
        Stream.iterate(0, n -> (int) Math.pow(2, n))
                .limit(5)
                .forEach(System.out::println);


    }

    static int[] arrayInitialization(int size) {
        return Stream.generate(() ->
                        (int) (Math.random() * 10))
                .limit(size)
                .sorted()
                .distinct()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
