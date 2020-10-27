package sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GetDataWord {

    private static final String DATA_FILE_PATH = "E_V.txt";
    private static final String DATA_FILE_PATH_VE = "V_E.txt";
    private static final String SPLITTING_CHARACTERS = "<html>";
    private static final String DATA_FILE_PATH_NEW = "E_V_new.txt";
    private static final String FAVOURITE_FILE_PATH ="Favourite.txt";

    GetDataWord() { }

     public TreeMap<String, Word> readData(String DATA_FILE_PATH) {
         TreeMap<String, Word> dataSort = new TreeMap<String, Word>();
        try {

            FileReader fis = new FileReader(DATA_FILE_PATH);
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

    public List<String> readFavourite(String DATA_FILE_PATH){
        List<String> strings = new ArrayList<String>();
        try{
            FileReader fis = new FileReader(DATA_FILE_PATH);
            BufferedReader br = new BufferedReader(fis);
            String line;

            while ((line=br.readLine())!=null){
                strings.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    public Map<String, Word> getDataEV() {
        return readData(DATA_FILE_PATH);
    }
    public Map<String, Word> getDataVE() {
        return readData(DATA_FILE_PATH_VE);
    }
    public Map<String,Word> getData(){
        return readData(DATA_FILE_PATH_NEW);
    }

    public List<String> getFavorite(){
        return readFavourite(FAVOURITE_FILE_PATH);
    }
}
