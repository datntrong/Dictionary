import java.util.Scanner;

public class DictionaryManagement {
    protected Dictionary dictionary = new Dictionary();

    public void insertFromCommandline() {
        Scanner scanner = new Scanner(System.in);

        int numberOfWord = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= numberOfWord; i++) {
            String English    = scanner.nextLine();
            String Vietnamese = scanner.nextLine();
            Word newWord = new Word(English, Vietnamese);
            dictionary.addWord(newWord);
        }
    }
}
