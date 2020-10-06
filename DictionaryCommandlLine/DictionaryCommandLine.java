import java.util.Scanner;

public class DictionaryCommandLine extends DictionaryCommandlinee {

    public void dictionaryBasic(){
        //insertFromFileEV();
        insertFromCommandline();
        showAllWords();
    }

    public void dictionaryAdvanced(){
        insertFromFile();
        showAllWords();
        //dictionaryLookup();

    }
    public static void main(String[] args){
        DictionaryCommandLine run = new DictionaryCommandLine();
        int i = 20;
        while (i!=0){
            System.out.println("----------------------------------");
            System.out.println("Chon chuc nang tu dien");
            System.out.println("1: Them tu bang Cml");
            System.out.println("2: Them tu tu file");
            System.out.println("3: Tra cuu tu dien bang dong lenh");
            System.out.println("4: Tim kiem tu");
            System.out.println("0: Thoa chuong trinh");

            Scanner scanner = new Scanner(System.in);
            i = scanner.nextInt();

            switch (i) {
                case 1:
                    System.out.println("Dong dau nhap so tu");
                    System.out.println("Dong 2 nhap tu va nghia cach nhau boi dau tab");
                    run.dictionaryBasic();
                    break;
                case 2:
                    run.dictionaryAdvanced();
                    break;
                case 3:
                    run.dictionaryLookup();
                    break;
                case 4:
                    run.dictionarySearcher();
                    break;
                case 0:
                    System.out.println("Bye");
                    break;
            }
        }
    }
}