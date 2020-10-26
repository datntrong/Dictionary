package sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GetDataWord {


    private Map<String, Word> dataEV = new HashMap<>();
    private Map<String, Word> dataVE = new HashMap<>();
    private static final String DATA_FILE_PATH = "E_V.txt";
    private static final String DATA_FILE_PATH_VE = "V_E.txt";
    private static final String SPLITTING_CHARACTERS = "<html>";

    private TreeMap<String, Word> dataSortEV = new TreeMap<String, Word>(dataEV);
    private TreeMap<String, Word> dataSortVE = new TreeMap<String, Word>(dataVE);

    GetDataWord() {
    }

    public void readDataEV() {
        try {

            FileReader fis = new FileReader(DATA_FILE_PATH);
            BufferedReader br = new BufferedReader(fis);
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(SPLITTING_CHARACTERS);
                String word = parts[0];
                String definition = SPLITTING_CHARACTERS + parts[1];
                Word wordObj = new Word(word, definition);
                dataEV.put(word, wordObj);
            }
            dataSortEV.putAll(dataEV);
            dataSortEV.entrySet();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void readDataVE() {
        try {

            FileReader fis = new FileReader(DATA_FILE_PATH_VE);
            BufferedReader br = new BufferedReader(fis);
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(SPLITTING_CHARACTERS);
                String word = parts[0];
                String definition = SPLITTING_CHARACTERS + parts[1];
                Word wordObj = new Word(word, definition);
                dataVE.put(word, wordObj);
            }
            dataSortVE.putAll(dataVE);
            dataSortVE.entrySet();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Word> getDataEV() {
        readDataEV();
        return dataSortEV;
    }

    public Map<String, Word> getDataVE() {
        readDataVE();
        return dataSortVE;
    }
}
