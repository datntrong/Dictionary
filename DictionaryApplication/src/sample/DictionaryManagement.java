package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DictionaryManagement {
    private GetDataWord getdata = new GetDataWord();

    private Map<String, Word> data = getdata.getData();

    private List<String> dictionary = new ArrayList<String>();

    public void a() {
        dictionary.addAll(data.keySet());
    }

    public List<String> dictionarySearcher() {
        List<String> listwordsearch = new ArrayList<String>();
        //System.out.println("Tim kiem tu bang dong lenh");
        a();
        String t = "H";
        int sz = this.dictionary.size();
        //System.out.printf("%-6s| %-18s| %s\n", "No", "English", "Vietnamese");

        for (int i = 0, no = 0; i < sz; ++i) {
            String word = dictionary.get(i);
            if (word.toUpperCase().startsWith(t.toUpperCase()))
                listwordsearch.add(word);
        }

        return listwordsearch;
    }

    public Map<String, Word> getData() {
        return data;
    }
}
