package findfirstfindany;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class FindFirst {
    public static void main(String[] args) {
        List<Long> numbers = LongStream.range(0, 10_000_000L).boxed()
                .collect(Collectors.toList());
        long start = System.nanoTime();
        Optional<Long> first = numbers.stream()
                .filter(l -> l > 500_000)
                .findFirst();
        long end = System.nanoTime();
        System.out.println("Found number " + first.orElse(-1L));
        System.out.println("duration " + ((end - start) / 1_000_000));
    }
}