public class DictionaryCommandLine extends DictionaryCommandlinee {

    public void dictionaryBasic() {
        insertFromCommandline();
        showAllWords();
    }

    public static void main(String[] args) {
        DictionaryCommandLine run = new DictionaryCommandLine();
        run.dictionaryBasic();
    }
}