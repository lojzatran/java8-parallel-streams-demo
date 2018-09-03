package forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class DemoWithArrayList {
    public static void main(String[] args) {
        List<Long> collect = LongStream.rangeClosed(1, 13).boxed().collect(Collectors.toList());
        ForkJoinTask<Long> sumTask = new DemoForkJoinCalculatorArrayList(collect);
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        Long result = commonPool.invoke(sumTask);
        System.out.println("Result is " + result);
    }
}