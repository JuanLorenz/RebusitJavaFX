package CharacterRemoverProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CharacterRemoverApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CharacterRemoverApplication.class.getResource("character_remover.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 240);
        stage.setResizable(false);
        stage.setTitle("CharacterRemover");
        stage.setScene(scene);
        stage.show();
    }
}
