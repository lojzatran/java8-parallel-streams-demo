package spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

public class WordCountSpliterator implements Spliterator<Character> {
    private final String text;
    private int currentChar = 0;

    public WordCountSpliterator(String text) {
        this.text = text;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        action.accept(text.charAt(currentChar++));
        return currentChar < text.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        System.out.println("Current thread name: " + Thread.currentThread().getName());
        int currentSize = text.length() - currentChar;
        if (currentSize < 10) {
            return null;
        }
        for (int splitPos = currentSize / 2 + currentChar; splitPos < text.length(); splitPos++) {
            if (Character.isWhitespace(text.charAt(splitPos))) {
                WordCountSpliterator spliterator = new WordCountSpliterator(text.substring(currentChar, splitPos));
                currentChar = splitPos;
                return spliterator;
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return text.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + NONNULL + IMMUTABLE + SUBSIZED;
    }
}