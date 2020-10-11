package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebView;
import sample.Word;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private TextArea inputWord ;

    @FXML
    private ListView<String> listView;

    @FXML
    private WebView webViewWord = new WebView();

    private GetDataWord getDataWord = new GetDataWord();

    public Controller(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void initComponents(Scene scene) {
        this.webViewWord = (WebView) scene.lookup("#webViewWord");
        this.listView = (ListView<String>) scene.lookup("#listView");
        this.listView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    Word selectedWord = getDataWord.getData().get(newValue.trim());
                    String definition = selectedWord.getWord_explain();
                   // String definition="1111";
                    this.webViewWord.getEngine().loadContent(definition, "text/html");
                }
        );
    }

    public void loadlistvew(){
        this.listView.getItems().addAll(getDataWord.getData().keySet());

    }



}
