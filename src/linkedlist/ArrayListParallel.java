package linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ArrayListParallel {
    public static void main(String[] args) {
        ArrayList<Long> numbers = LongStream.range(0, 10_000_000L).boxed()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        long start = System.nanoTime();
        long sum = numbers.parallelStream().mapToLong(i -> i).sum();
        long end = System.nanoTime();
        System.out.println("sum is " + sum);
        System.out.println("duration " +  ((end - start) / 1_000_000));
    }
}