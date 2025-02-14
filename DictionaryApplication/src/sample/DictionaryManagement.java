package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionaryManagement {
    private static GetDataWord getData = new GetDataWord();

    private static List<String> history = new ArrayList<String>();

    private static List<String> favourite = getData.getFavorite();

    private static Map<String, Word> dataEV = getData.getDataEV();

    private static Map<String, Word> dataVE = getData.getDataVE();

    private static Map<String, Word> add = new HashMap<>();

    private static Map<String, Word> data = dataEV;

    public List<String> dictionarySearcher(String t) {

        List<String> listWordSearch = new ArrayList<String>();
        for (String word : data.keySet()) {
            if (word.toUpperCase().startsWith(t.toUpperCase()))
                listWordSearch.add(word);
        }

        return listWordSearch;
    }

    public void addWord(String word_target, String word_explain) {
        word_explain = "<html><i>" + word_target
                + "</i><br/><ul><li><font color='#cc0000'><b>"
                + word_explain + "</b></font></li></ul></html>";
        if (data.containsKey(word_target)) {
            data.replace(word_target, new Word(word_target, word_explain));
        } else {
            add.put(word_target, new Word(word_target, word_explain));
            data.put(word_target, new Word(word_target, word_explain));
        }
    }

    public void deleteWord(String deleteWord) {
        data.remove(deleteWord);
    }

    public Map<String, Word> getData() {
        return data;
    }

    public List<String> getHistory() {
        return history;
    }

    public void addHistory(String n) {
        if(!history.contains(n)){
            history.add(n);
        }

    }

    public void addFavourite(String favourite) {
        if(favourite.contains(favourite)) {
            this.favourite.add(favourite);
        }
    }

    public List<String> getFavourite() {

        return favourite;
    }

    public void VE() {
        data.putAll(getData.getData());
        data = dataVE;
    }

    public void EV() {
        data.putAll(getData.getData());
        data = dataEV;
    }
    public Map<String, Word> getAdd() {
        return add;
    }

}
