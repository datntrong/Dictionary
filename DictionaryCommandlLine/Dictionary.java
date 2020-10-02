import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    public List<Word> dictionary = new ArrayList<Word>();
    public void addWord(Word word){
        this.dictionary.add(word);
    }
    public void removeWord(Word word){
        this.dictionary.remove(word);
    }
    public int getSize(){
        return this.dictionary.size();
    }
    public Word getWord(int i){
        return this.dictionary.get(i);
    }
    public Word getWord(String w){
        for(int i=0;i<dictionary.size();i++){
            Word word = this.dictionary.get(i);
            if(word.getWord_target().equals(w)) return word;
        }
        return null;
    }

}