package sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class GetDataWord {

    private static final String DATA_FILE_PATH = "E_V.txt";
    private static final String DATA_FILE_PATH_VE = "V_E.txt";
    private static final String SPLITTING_CHARACTERS = "<html>";

    GetDataWord() {}

    public TreeMap<String, Word> readData(String DATA_FILE_PATH_VE) {
        TreeMap<String, Word> dataSort = new TreeMap<>();
        try {
            FileReader fis = new FileReader(DATA_FILE_PATH_VE);
            BufferedReader br = new BufferedReader(fis);
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(SPLITTING_CHARACTERS);
                String word = parts[0];
                String definition = SPLITTING_CHARACTERS + parts[1];
                Word wordObj = new Word(word, definition);
                dataSort.put(word, wordObj);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataSort;
    }

    public Map<String, Word> getDataEV() {
        return readData(DATA_FILE_PATH);
    }

    public Map<String, Word> getDataVE() {
        return readData(DATA_FILE_PATH_VE);
    }
}
