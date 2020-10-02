import java.io.FileNotFoundException;
import java.io.IOException;

public class DictionaryCommandLine extends DictionaryCommandlinee {

    public void dictionaryBasic(){
        insertFromFileEV();
        //insertFromCommandline();
        showAllWords();
    }

    public static void main(String[] args){
        DictionaryCommandLine run = new DictionaryCommandLine();
        run.dictionaryBasic();
    }
}