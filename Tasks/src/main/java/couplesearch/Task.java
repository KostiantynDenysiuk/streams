package couplesearch;

import java.util.List;

public class Task {
    private static final int pairSum = 10;

    //find all pair combinations which sum equals pattern
    public static void main(String[] args) {
        List<Integer> list = List.of(7, 4, 10, 0, 1, 2, 0, 10, 9, 7,
                1, 5, 7, 5, 11, 6, 4, 5);

        list.stream()
                .forEach(i -> list.stream()
                        .forEach(j -> {
                            if (i + j == pairSum) {
                                System.out.println(String.format("%d + %d = %d", i, j, i + j));
                            }
                        }));
    }
}
