package sample;

import javafx.scene.control.ListView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetDataWord {


    private Map<String, Word> data = new HashMap<>();
    private static final String DATA_FILE_PATH = "E_V.txt";
    private static final String SPLITTING_CHARACTERS = "<html>";

    private ListView<String> listView;

    GetDataWord(){
        readData();
    }
    public void readData() {
        try{
            FileReader fis = new FileReader(DATA_FILE_PATH);
            BufferedReader br = new BufferedReader(fis);
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(SPLITTING_CHARACTERS);
                String word = parts[0];
                String definition = SPLITTING_CHARACTERS + parts[1];
                Word wordObj = new Word(word, definition);
                data.put(word, wordObj);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public ListView<String> getListView() {
        return listView;

    }

    public Map<String, Word> getData() {
        return data;
    }
}
