module com.example.rebusitjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.rebusitjavafx to javafx.fxml;
    exports com.example.rebusitjavafx;
}