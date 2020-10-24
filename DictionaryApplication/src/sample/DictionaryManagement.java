package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DictionaryManagement {
    private GetDataWord getData = new GetDataWord();

    private List<String> history = new ArrayList<String>();

    private Map<String, Word> data = getData.getData();

    public List<String> dictionarySearcher(String t) {
        List<String> dictionary = new ArrayList<String>();
        List<String> listWordSearch = new ArrayList<String>();
        dictionary.addAll(data.keySet());
        int sz = dictionary.size();
        for (int i = 0, no = 0; i < sz; ++i) {
            String word = dictionary.get(i);
            if (word.toUpperCase().startsWith(t.toUpperCase()))
                listWordSearch.add(word);
        }

        return listWordSearch;
    }

    public void addWord(String word_target, String word_explain){
        data.put(word_target,new Word(word_target,word_explain));
    }
    public Map<String, Word> getData() {
        return data;
    }

    public List<String> getHistory(){
        return history;
    }

    public void setDataHistory(String n) {
        history.add(n);
    }
}
