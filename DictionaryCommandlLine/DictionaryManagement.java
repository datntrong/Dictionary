import java.util.Scanner;
import java.io.*;

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
    public void insertFromFile(){
        Scanner sc = null;
        try {
            sc = new Scanner(new File("dictionaries.txt"));
            int wordCount = sc.nextInt();
            sc.nextLine();
            for(int i=0;i<wordCount;i++){
                String line = sc.nextLine();
                String word_target = line.split("\t")[0];
                String word_explain = line.split("\t")[1];
                this.dictionary.addWord(new Word(word_target,word_explain));
            }
        } catch (FileNotFoundException e){
            System.out.println("file dictionaries.txt not found\n");
        }
    }

    public void insertFromFileEV(){
        try{
            FileReader fis = new FileReader("E_V.txt");
            BufferedReader br = new BufferedReader(fis);

            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("<html>");
                String word = parts[0];
                String definition = "<html>" + parts[1];
                System.out.println(word);
                System.out.println("==> " + definition);
                Word wordObj = new Word(word, definition);
                dictionary.addWord(wordObj);
                i++;
                if (i > 5) break;
            }


            // Cập nhật 1 từ
            /*
            for (Word word : dictionary) {
                if (word.getWord_target().equals("-manship")) {
                    word.setWord_explain("<html>Nghĩa mới</html>");
                }
            }
            FileWriter fw = new FileWriter("E_V.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Word word : dictionary) {
                bw.write(word.getWord_target() + word.getWord_explain() + "\n");
            }
            bw.flush();
            bw.close();

             */
        }  catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}