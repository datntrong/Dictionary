import java.util.Scanner;
import java.io.*;

public class DictionaryManagement {
    protected Dictionary dictionary = new Dictionary();

    public void insertFromCommandline() {
        Scanner scanner = new Scanner(System.in);

        int numberOfWord = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= numberOfWord; i++) {
            String line = scanner.nextLine();
            String English    = line.split("\t")[0];
            String Vietnamese = line.split("\t")[1];
            Word newWord = new Word(English, Vietnamese);
            dictionary.addWord(newWord);
        }
    }
    public void insertFromFile(){
        Scanner sc = null;
        try {
            sc = new Scanner(new File("Dictionaries.txt"));
            int wordCount = sc.nextInt();
            sc.nextLine();
            for(int i=0;i<wordCount;i++){
                String line = sc.nextLine();
                String word_target = line.split("\t")[0];
                String word_explain = line.split("\t")[1];
                this.dictionary.addWord(new Word(word_target,word_explain));
            }
        } catch (FileNotFoundException e){
            System.out.println("file Dictionaries.txt not found\n");
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

    public void dictionaryLookup(){
        System.out.println("Tra cu tu dien bang dong lenh: ");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        if(dictionary.getWord(word)!=null){
            String English    = dictionary.getWord(word).getWord_target();
            String Vietnamese = dictionary.getWord(word).getWord_explain();
            System.out.printf("%-18s| %s\n", English, Vietnamese);
        }
        else {
            System.out.println("Word not found");
        }
    }


    public void dictionarySearcher () {
        System.out.println("Tim kiem tu bang dong lenh");
        Scanner scanner = new Scanner(System.in);
        String t = scanner.nextLine();
        int sz = this.dictionary.getSize();
        System.out.printf("%-6s| %-18s| %s\n", "No", "English", "Vietnamese");

        for (int i = 0, no = 0; i < sz; ++i) {
            Word word = this.dictionary.getWord(i);
            if (word.getWord_target().toUpperCase().startsWith(t.toUpperCase()))
                System.out.printf("%-6s| %-18s| %s\n", String.valueOf(++no), word.getWord_target(), word.getWord_explain());
        }
    }

    public void dictionaryExportToFile(String url){
        try {
            PrintWriter printWriter = new PrintWriter(new File(url));
            int size = this.dictionary.getSize();
            printWriter.println(size);
            for (int i = 0; i < size; i++) {
                Word w = this.dictionary.getWord(i);
                printWriter.printf("%s\t%s\n", w.getWord_target(), w.getWord_explain());
            }
            printWriter.flush();
            System.out.printf("Xuat file %s thanh cong\n",url);
        }
        catch (IOException e) {
            System.err.println("\nLoi: Khong ghi duoc file");
        }

    }
}