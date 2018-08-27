package reduce;

import java.util.stream.LongStream;

public class ReduceExample {

    public static void main(String[] args) {
        Long sum = LongStream.rangeClosed(0, 10)
//                .parallel()
                .reduce(1L, (partialSum, element) -> partialSum + element);

        // should be 55
        System.out.println("sum is " + sum);
    }
}