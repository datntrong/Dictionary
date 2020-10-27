package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private TextField inputWord;

    @FXML
    private static volatile ListView<String> listView;

    @FXML
    private Button btn = new Button();

    @FXML
    private WebView webViewWord = new WebView();

    @FXML
    private Button add = new Button();

    @FXML
    private Button translateWindow = new Button();

    @FXML
    private Button translate = new Button();

    @FXML
    private TextArea target = new TextArea();

    @FXML
    private TextArea explain = new TextArea();

    @FXML
    private TextField addWord_t;

    @FXML
    private TextField addWord_e;

    @FXML
    private TextField wordDelete;

    @FXML
    private Button showDelete = new Button();

    @FXML
    private Button delete = new Button();

    @FXML
    private Button speech = new Button();

    private DictionaryManagement dictionaryManagement = new DictionaryManagement();

    public Controller() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void initComponents(Scene scene) {
        this.webViewWord = (WebView) scene.lookup("#webViewWord");
        listView = (ListView<String>) scene.lookup("#listView");
        inputWord = (TextField) scene.lookup("#inputWord");
        listView.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
//                System.out.println(observable + " " + oldValue + " " + newValue);
                if (observable != null && newValue != null) {
//                    System.out.println(listView);
                    Word selectedWord = dictionaryManagement.getData().get(newValue.trim());
                    String definition = selectedWord.getWord_explain();
                    this.webViewWord.getEngine().loadContent(definition, "text/html");
                }
            }
        );
        inputWord.textProperty().addListener((observable, oldValue, newValue) -> {
//          System.out.println("textfield changed from " + oldValue + " to " + newValue);
//          word = newValue;
//          dictionaryManagement.setDataHistory(word);
//          System.out.println(word);
            dictionarySearcher(newValue);
        });
    }

    public void loadListView() {
        listView.getItems().addAll(dictionaryManagement.getData().keySet());
    }

    public void updateListView(String t) {
        listView.getItems().clear();
        List<String> listWordSearch = dictionaryManagement.dictionarySearcher(t);
        listView.getItems().addAll(listWordSearch);
        listView.refresh();
    }


    public void setInputWord(TextField inputWord) {
        this.inputWord = inputWord;
    }

    public String inputW() {
        return inputWord.getText();
    }

    public void dictionarySearcher(String word) {
        if (word != null) {
            updateListView(word);
        }
    }

    public void textToSpeech(ActionEvent e) {
        String text = listView.getSelectionModel().getSelectedItem();
//        TextToSpeech.speak(text, false);
        if (text != null) {
            TextToSpeech.speak(text, false);
        }
    }

    public void translateWindow(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("GoogleTranslate.fxml"));

            Stage primaryStage = new Stage();
            primaryStage.setTitle("Translate");

            Scene scene = new Scene(root, 600, 450);
            primaryStage.setScene(scene);

            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void translate(ActionEvent event) throws IOException {
        explain.clear();
        String Vietnamese = Translate.translate("en", "vi", target.getText());
        explain.appendText(Vietnamese);
    }

    public void speechVN(ActionEvent e) {
        String text = target.getText();
//        TextToSpeech.speak(text, false);
        if (text != null) {
            TextToSpeech.speak(text, false);
        }
    }

    public void addWord(ActionEvent e) {
        dictionaryManagement.addWord(addWord_t.getText(), addWord_e.getText());
//        System.out.println(addWord_t.getText());
    }

    public void showAddWord(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("WordEdit.fxml"));

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Edit Word");

        Scene scene = new Scene(root, 600, 450);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public void showHistory() {
        if (dictionaryManagement.getHistory() != null) {
            listView.getItems().clear();
            listView.getItems().addAll(dictionaryManagement.getHistory());
            listView.refresh();
        }
    }

    public void favourite(ActionEvent e) {
        String word = listView.getSelectionModel().getSelectedItem();
        if (word != null) {
            dictionaryManagement.addFavourite(word);
        }
    }

    public void showFavourite() {
        if (dictionaryManagement.getFavourite() != null) {
            listView.getItems().clear();
            listView.getItems().addAll(dictionaryManagement.getFavourite());
            listView.refresh();
        }
    }

    public void deleteWord(ActionEvent e) {
        String word = listView.getSelectionModel().getSelectedItem();
        if (word != null) {
            dictionaryManagement.deleteWord(word);
            listView.getItems().remove(word);
        }

    }

    public void VE() {
        listView.getItems().clear();
        dictionaryManagement.VE();
        listView.getItems().addAll(dictionaryManagement.getData().keySet());
        listView.refresh();

    }

    public void EV() {
        listView.getItems().clear();
        dictionaryManagement.EV();
        listView.getItems().addAll(dictionaryManagement.getData().keySet());
        listView.refresh();
    }
}