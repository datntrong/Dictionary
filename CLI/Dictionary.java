public class Dictionary {
    private static final int size = 10000;
    private Word[] dictionary;
    private int numberOfWord = 0;

    Dictionary() {
        dictionary = new Word[size];
    }

    public void addWord(Word newWord) {
        if (numberOfWord < size) {
            dictionary[numberOfWord] = newWord;
            numberOfWord++;
        }
    }

    public void removeWord(Word word) {
        for (int i = 0; i < numberOfWord; i++) {
            if (dictionary[i] == word) {
                for (int j = i; j < numberOfWord - 1; j++) {
                    dictionary[j] = dictionary[j + 1];
                }
            }
        }
    }

    public int getSize() {
        return numberOfWord;
    }

    public Word getWord(int id) {
        return dictionary[id];
    }
}
