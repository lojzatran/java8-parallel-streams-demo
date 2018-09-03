package spliterator;

public class WordCount {

    private final int count;
    private final boolean lastSpace;

    public WordCount(int count, boolean lastSpace) {
        this.count = count;
        this.lastSpace = lastSpace;
    }

    public WordCount accumulate(Character c) {
        if (Character.isSpaceChar(c)) {
            return lastSpace ? this // we have multiple spaces between words
                    : new WordCount(count, true);  // we came to the end of a word
        } else {
            return lastSpace ? new WordCount(count + 1, false) // we came from space to a new word
                    : this; // we are still in the same word
        }
    }

    public WordCount combine(WordCount wordCount) {
        return new WordCount(this.count + wordCount.count, wordCount.lastSpace);
    }

    public int getCount() {
        return count;
    }
}