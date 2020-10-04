import java.io.FileNotFoundException;
import java.io.IOException;

public class DictionaryCommandLine extends DictionaryCommandlinee {

    public void dictionaryBasic(){
        //6insertFromFileEV();
        insertFromCommandline();
        showAllWords();
    }

    public void DictionaryAdvanced(){
        insertFromFile();
        showAllWords();
        dictionaryLookup();
    }
    public static void main(String[] args){
        DictionaryCommandLine run = new DictionaryCommandLine();
        //run.dictionaryBasic();
        run.DictionaryAdvanced();
    }
}