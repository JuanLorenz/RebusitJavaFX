package FoodOrderingSystemProject;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class FoodOrderingSystemController {

    public CheckBox chkbxPizza;
    public CheckBox chkbxBurger;
    public CheckBox chkbxFries;
    public CheckBox chkbxSoftDrinks;
    public CheckBox chkbxTea;
    public CheckBox chkbxSundae;

    public RadioButton rdbtnNone;
    public RadioButton rdbtn5Percent;
    public RadioButton rdbtn10Percent;
    public RadioButton rdbtn15Percent;

    public ToggleGroup group = new ToggleGroup();

    public void initialize(){
        rdbtnNone.setToggleGroup(group);
        rdbtn5Percent.setToggleGroup(group);
        rdbtn10Percent.setToggleGroup(group);
        rdbtn15Percent.setToggleGroup(group);
    }

    public Label labelResult;
    public Button btnOrder;
    private int total = 0;
    private double discount;
    private boolean[] chkbxStates = {false,false,false,false,false,false};

    public void onRadioButtonClicked(MouseEvent mouseEvent) {
        RadioButton src = (RadioButton) mouseEvent.getSource();

        if (src.equals(rdbtnNone)) {
            discount = 1;
        }else if (src.equals(rdbtn5Percent)) {
            discount = 0.95;
        }else if (src.equals(rdbtn10Percent)){
            discount = 0.90;
        }else{
            discount = 0.85;
        }
    }

    public void onButtonClicked(MouseEvent mouseEvent) {

        RadioButton selected = (RadioButton) group.getSelectedToggle();
        boolean picked = false;

        for (boolean b : chkbxStates){
            if (b){
                picked = true;
                break;
            }
        }

        if (selected == null && !picked) {
            labelResult.setText("Pick a discount and at least one food");
        }else if (selected == null){
            labelResult.setText("Pick a discount");
        }else if(!picked){
            labelResult.setText("Pick at least one food");
        }else{
            labelResult.setText("The total price is Php " + String.format("%.2f",total * discount));
        }
    }

    public void onCheckboxClicked(MouseEvent mouseEvent) {
        CheckBox src = (CheckBox) mouseEvent.getSource();

        if (src.equals(chkbxPizza)){
            chkbxStates[0] = (!chkbxStates[0]);
            if (chkbxStates[0]){
                total += 100;
            }else{
                total -= 100;
            }
        }else if (src.equals(chkbxBurger)){
            chkbxStates[1] = (!chkbxStates[1]);
            if (chkbxStates[1]){
                total += 80;
            }else{
                total -= 80;
            }
        }else if (src.equals(chkbxFries)){
            chkbxStates[2] = (!chkbxStates[2]);
            if (chkbxStates[2]){
                total += 65;
            }else{
                total -= 65;
            }
        }else if (src.equals(chkbxSoftDrinks)){
            chkbxStates[3] = (!chkbxStates[3]);
            if (chkbxStates[3]){
                total += 55;
            }else{
                total -= 55;
            }
        }else if (src.equals(chkbxTea)){
            chkbxStates[4] = (!chkbxStates[4]);
            if (chkbxStates[4]){
                total += 50;
            }else{
                total -= 50;
            }
        }else{
            chkbxStates[5] = (!chkbxStates[5]);
            if (chkbxStates[5]){
                total += 40;
            }else{
                total -= 40;
            }
        }
    }
}
