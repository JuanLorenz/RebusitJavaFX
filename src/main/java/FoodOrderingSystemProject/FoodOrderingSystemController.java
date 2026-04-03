package FoodOrderingSystemProject;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class FoodOrderingSystemController {

    public CheckBox chkbxPizza;
    public CheckBox chkbxBurger;
    public CheckBox chkbxFries;
    public CheckBox chkbxSoftDrinks;
    public CheckBox chkbxTea;
    public CheckBox chkbxSundae;
    public ArrayList<CheckBox> cbList = new ArrayList<>();

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

        cbList.add(chkbxPizza);
        cbList.add(chkbxBurger);
        cbList.add(chkbxFries);
        cbList.add(chkbxSoftDrinks);
        cbList.add(chkbxTea);
        cbList.add(chkbxSundae);
    }

    public Label labelResult;
    public Button btnOrder;
    private int total = 0;
    private double discount;
    private final boolean[] chkbxStates = {false,false,false,false,false,false};
    private final int[] prices = {100,80,65,55,50,45};

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

        int idx = cbList.indexOf(src);
        chkbxStates[idx] = !(chkbxStates[idx]);
        total = (chkbxStates[idx]) ? (total + prices[idx]) : (total - prices[idx]);

    }
}
