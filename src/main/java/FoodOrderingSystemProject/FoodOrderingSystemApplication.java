package FoodOrderingSystemProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FoodOrderingSystemApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FoodOrderingSystemApplication.class.getResource("food_ordering.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 350);
        stage.setResizable(false);
        stage.setTitle("Food Ordering System");
        stage.setScene(scene);
        stage.show();
    }
}
