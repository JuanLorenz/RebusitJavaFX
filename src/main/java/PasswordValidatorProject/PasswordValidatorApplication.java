package PasswordValidatorProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PasswordValidatorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PasswordValidatorApplication.class.getResource("password_validator.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 460, 120);
        stage.setResizable(false);
        stage.setTitle("Password Validation System");
        stage.setScene(scene);
        stage.show();
    }
}
