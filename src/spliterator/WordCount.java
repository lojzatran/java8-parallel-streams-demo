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
            return lastSpace ? this : new WordCount(count, true);
        } else {
            return lastSpace ? new WordCount(count + 1, false) : this;
        }
    }

    public WordCount combine(WordCount wordCount) {
        return new WordCount(this.count + wordCount.count, wordCount.lastSpace);
    }

    public int getCount() {
        return count;
    }
}