package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private Controller controller = new Controller();


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Dictionary");

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);

        primaryStage.show();

        controller.initComponents(scene);
        controller.loadlistvew();
        //controller.dictionarySearcher();
        //controller.getWordSearch();
        controller.initComponents(scene);

    }


    public static void main(String[] args) {
        launch(args);
    }


}
