package ui.random;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import logic.Logic;

import java.net.URL;
import java.util.ResourceBundle;

public class RandomController implements Initializable{
    @FXML
    private Label wordLabel;
    @FXML private JFXButton confirm;
    @FXML private JFXButton next;
    @FXML private Label meaningLabel;

    @FXML private ToggleGroup group;
    @FXML private JFXRadioButton A;
    @FXML private JFXRadioButton B;
    @FXML private JFXRadioButton C;
    @FXML private JFXRadioButton D;

    Logic logic;
    String word;
    String meaning;

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logic = Logic.getInstance();
        String[] temp = logic.nextRandom();
        word = temp[0];
        meaning = temp[1];
        wordLabel.setText(word);
        group=new ToggleGroup();

        int correct = (int) (Math.random() * 4);

        if (correct == 0) {
            A.setText(meaning);
            B.setText(logic.getRandomChinese());
            C.setText(logic.getRandomChinese());
            D.setText(logic.getRandomChinese());
        } else if (correct == 1) {
            A.setText(logic.getRandomChinese());
            B.setText(meaning);
            C.setText(logic.getRandomChinese());
            D.setText(logic.getRandomChinese());
        } else if (correct == 2) {
            A.setText(logic.getRandomChinese());
            B.setText(logic.getRandomChinese());
            C.setText(meaning);
            D.setText(logic.getRandomChinese());
        } else if (correct == 3) {
            A.setText(logic.getRandomChinese());
            B.setText(logic.getRandomChinese());
            C.setText(logic.getRandomChinese());
            D.setText(meaning);
        }

        A.setToggleGroup(group);
        B.setToggleGroup(group);
        C.setToggleGroup(group);
        D.setToggleGroup(group);
    }

    @FXML
    public void onConfirm(){
        String selected=((JFXRadioButton)group.getSelectedToggle()).getText();
        if(selected.equals(meaning)){
            meaningLabel.setText("选择正确");
        }else{
            meaningLabel.setText(meaning);
        }
    }

    @FXML
    public void onNext(){
        String[] temp = logic.nextRandom();
        word = temp[0];
        meaning = temp[1];
        wordLabel.setText(word);
        meaningLabel.setText("");

        int correct = (int) (Math.random() * 4);

        if (correct == 0) {
            A.setText(meaning);
            B.setText(logic.getRandomChinese());
            C.setText(logic.getRandomChinese());
            D.setText(logic.getRandomChinese());
        } else if (correct == 1) {
            A.setText(logic.getRandomChinese());
            B.setText(meaning);
            C.setText(logic.getRandomChinese());
            D.setText(logic.getRandomChinese());
        } else if (correct == 2) {
            A.setText(logic.getRandomChinese());
            B.setText(logic.getRandomChinese());
            C.setText(meaning);
            D.setText(logic.getRandomChinese());
        } else if (correct == 3) {
            A.setText(logic.getRandomChinese());
            B.setText(logic.getRandomChinese());
            C.setText(logic.getRandomChinese());
            D.setText(meaning);
        }
        A.setSelected(true);
    }
}
