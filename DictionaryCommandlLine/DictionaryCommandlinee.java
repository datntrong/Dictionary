public class DictionaryCommandlinee extends DictionaryManagement {


    public void showAllWords() {
        int numberOfWord = dictionary.getSize();
        System.out.printf("%-6s| %-18s| %s\n", "No", "English", "Vietnamese");
        for (int i = 0; i < numberOfWord; i++) {
            String English    = dictionary.getWord(i).getWord_target();
            String Vietnamese = dictionary.getWord(i).getWord_explain();
            System.out.printf("%-6d| %-18s| %s\n", i+1, English, Vietnamese);
        }
    }
}