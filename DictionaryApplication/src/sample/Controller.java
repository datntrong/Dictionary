package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
    private WebView webViewWord = new WebView();

    private DictionaryManagement dictionaryManagement = new DictionaryManagement();

    public Controller() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void initComponents(Scene scene) {
        //dictionaryManagement.dictionarySearcher();//ham dung phu
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

    public void loadlistvew() {
        this.listView.getItems().addAll(dictionaryManagement.getData().keySet());
    }

    public void setInputWord(TextField inputWord) {
        this.inputWord = inputWord;
    }

    public String inputW() {
        return inputWord.getText();
    }

    public void dictionarySearcher() {
        String t = "H";
        this.listView.getItems().removeAll(dictionaryManagement.getData().keySet());
        List<String> listwordsearch = dictionaryManagement.dictionarySearcher();

        this.listView.getItems().addAll(listwordsearch);

    }

    public void getWordSearch(Scene scene) {

        this.listView.refresh();
    }
}
