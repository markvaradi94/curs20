package ro.fasttrackit.curs20;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsExtra {
    public static void main(String[] args) {
        IntStream.range(1, 11)
                .forEach(System.out::println);

        System.out.println();
        System.out.println(IntStream.range(20, 40)
                .sum());

        System.out.println();
        System.out.println(IntStream.range(20, 40)
                .average());

        System.out.println();
        System.out.println(IntStream.range(20, 40)
                .count());

        System.out.println();
        System.out.println(IntStream.range(20, 40)
                .filter(elem -> elem % 2 == 0)
                .sum());

        System.out.println();
        System.out.println(IntStream.range(44, 80)
                .min());

        System.out.println();
        System.out.println(IntStream.range(1, 10)
                .max());

        int[] ints = new int[]{1, 5, 7, 3, 7, 9, 2};
        System.out.println();
        System.out.println(IntStream.of(ints)
                .min());

        System.out.println();
        IntStream.of(ints)
                .map(a -> a + 1)
                .forEach(System.out::println);

        System.out.println();
        System.out.println(IntStream.of(ints)
                .mapToObj(a -> "element " + a)
                .collect(Collectors.joining(" ~ ")));
    }
}
