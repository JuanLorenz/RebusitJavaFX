package CharacterRemoverProject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class CharacterRemoverController {
    @FXML
    public CheckBox chkbxVowels;
    public CheckBox chkbxConsonants;
    public CheckBox chkbxNumbers;
    public Button btnRemove;
    public Button btnRestore;
    public Label displayText;
    private final String defaultText = "ABCDEFGHIJKLMNOPQRSTUVWXWYZ0123456789";
    private boolean[] map = {false,false,false};
    private boolean[] state = {false,false,false};

    public void onChkbxClicked(MouseEvent mouseEvent) {
        CheckBox src = (CheckBox) mouseEvent.getSource();
        if (src.equals(chkbxVowels)){
            map[0] = true;
            state[0] = (!state[0]);
        }else if(src.equals(chkbxConsonants)){
            map[1] = true;
            state[1] = (!state[1]);
        }else{
            map[2] = true;
            state[2] = (!state[2]);
        }
    }

    public void onBtnClicked(MouseEvent mouseEvent) {
        Button src = (Button) mouseEvent.getSource();

        if (src.equals(btnRemove)){

            if (map[0]) {
                if (state[0]) {
                    displayText.setText(displayText.getText().replaceAll("[AEIOU]", ""));
                }
            }
            if (map[1]) {
                if (state[1]) {
                    displayText.setText(displayText.getText().replaceAll("[B-DF-HJ-NP-TV-Z]", ""));
                }
            }
            if (map[2]) {
                if (state[2]){
                    displayText.setText(displayText.getText().replaceAll("[0123456789]",""));
                }
            }

        }else{
            for (boolean b: map){
                b = false;
            }
            displayText.setText(defaultText);
        }
    }
}
