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
            System.out.println("Chon chuc nang tu dien");
            System.out.println("1:Them tu bang Cml \t  2:Them tu tu file  ");
            System.out.println("3: Tra cuu tu dien bang dong lenh \t 4:Tim kiem tu");

            Scanner scanner = new Scanner(System.in);
            i = scanner.nextInt();
            if(i==1){
                System.out.println("Dong dau nhap so tu \n Dong 2 nhap tu va nghia cach nhau boi dau tab");
                run.dictionaryBasic();
            }
            if(i==2){
                run.dictionaryAdvanced();
            }
            if(i==3){
                run.dictionaryLookup();
            }
            if(i==4){
                run.dictionarySearcher();
            }
        }
    }
}