package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private TextField inputWord;

    @FXML
    private ListView<String> listView;

    @FXML
    private Button btn = new Button();

    @FXML
    private WebView webViewWord = new WebView();

    private DictionaryManagement dictionaryManagement = new DictionaryManagement();

    private String word;

    public Controller() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void initComponents(Scene scene) {
        this.webViewWord = (WebView) scene.lookup("#webViewWord");
        this.listView = (ListView<String>) scene.lookup("#listView");
        this.listView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    Word selectedWord = dictionaryManagement.getData().get(newValue.trim());
                    String definition = selectedWord.getWord_explain();
                    this.webViewWord.getEngine().loadContent(definition, "text/html");
                }
        );
    }

    public void loadListView() {
        this.listView.getItems().addAll(dictionaryManagement.getData().keySet());
    }

    public void setInputWord(TextField inputWord) {
        this.inputWord = inputWord;
    }

    public String inputW() {
        return inputWord.getText();
    }

    public void dictionarySearcher() {
        String t = word;
        //String a = inputWord.getText();

        //System.out.println(a);
        if (word == null) ;
        else {
            this.listView.getItems().removeAll(dictionaryManagement.getData().keySet());
            List<String> listWordSearch = dictionaryManagement.dictionarySearcher(t);

            this.listView.getItems().addAll(listWordSearch);
            this.listView.refresh();
        }

    }

    public void getWordSearch(ActionEvent actionEvent) {
        this.word = this.inputWord.getText();
        System.out.println(word);
        dictionarySearcher();
    }

    public void textToSpeech(ActionEvent e) {
        String text = listView.getSelectionModel().getSelectedItem();
        TextToSpeech.speak(text, false);
    }
}
