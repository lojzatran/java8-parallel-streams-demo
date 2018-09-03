package forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 13).toArray();
        RecursiveTask<Long> task = new ForkJoinSumCalculator(numbers, 0, numbers.length);
        Long result = ForkJoinPool.commonPool().invoke(task);
        System.out.println("Result is " + result);
    }

}
