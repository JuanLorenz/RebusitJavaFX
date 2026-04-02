module com.example.rebusitjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens CharacterRemoverProject to javafx.fxml;
    exports CharacterRemoverProject;
}