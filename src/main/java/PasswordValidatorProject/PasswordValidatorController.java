package PasswordValidatorProject;

import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidatorController {

    public Label displayText;
    public PasswordField passFieldMain;
    private String input;
    private Pattern pattern1 = Pattern.compile("[0-9]");
    private Pattern pattern2 = Pattern.compile("[^a-zA-Z0-9 ]");
    private Matcher matcher;

    public void onKeyTypedListener(KeyEvent keyEvent) {

        PasswordField pf = (PasswordField) keyEvent.getSource();

        input = pf.getText();

        if (!(input.length() >= 8)){
            displayText.setText("Password must be 8 characters long");
            displayText.setTextFill(Color.RED);
        } else if (!(pattern1.matcher(input)).find()){
            displayText.setText("Password must contain at least 1 digit");
            displayText.setTextFill(Color.RED);
        } else if (!(pattern2.matcher(input)).find()){
            displayText.setText("Password contain at least one special character");
            displayText.setTextFill(Color.RED);
        } else {
            displayText.setText("Password is valid");
            displayText.setTextFill(Color.GREEN);
        }
    }

}
