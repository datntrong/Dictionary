public class Dictionary {
    private static final int size = 10000;
    private Word[] dictionary = new Word[size];
    private int n=0;

    public void addWord(Word newWord){
        if(n<size){
            dictionary[n]=newWord;
            n++;
        }
    }

    public void removeWord(Word word){
        for(int i=0;i<n;i++){
            if(dictionary[i]==word){
                for(int j=i;j<n-1;j++){
                    dictionary[j]=dictionary[j+1];
                }
            }
        }
    }

    public int getSize(){
        return n;
    }

    public Word getWord(int id){
        return dictionary[id];
    }
}
