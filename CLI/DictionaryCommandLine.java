public class DictionaryCommandLine extends DictionaryCommandline {

    public void dictionaryBasic() {
        insertFromCommandline();
        showAllWords();
    }

    public static void main(String[] args) {
        DictionaryCommandLine run = new DictionaryCommandLine();
        run.dictionaryBasic();
    }
}
