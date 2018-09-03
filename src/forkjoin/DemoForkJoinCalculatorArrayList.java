package forkjoin;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class DemoForkJoinCalculatorArrayList extends RecursiveTask<Long> {
    private List<Long> numbers;

    public DemoForkJoinCalculatorArrayList(List<Long> numbers) {
        this.numbers = numbers;
    }

    @Override
    protected Long compute() {
        System.out.println("Current thread " + Thread.currentThread().getName());
        if (numbers.size() <= 2) {
            return computeSequentially();
        } else {
            int divisionPoint = numbers.size() / 2;
            DemoForkJoinCalculatorArrayList left = new DemoForkJoinCalculatorArrayList(numbers.subList(0, divisionPoint));
            left.fork();
            DemoForkJoinCalculatorArrayList right = new DemoForkJoinCalculatorArrayList(numbers.subList(divisionPoint, numbers.size()));
            Long rightResult = right.compute();
            Long leftResult = left.join();
            return leftResult + rightResult;
        }
    }

    private long computeSequentially() {
        long sum = 0;
        return numbers.stream().mapToLong(i -> i).sum();
    }
}