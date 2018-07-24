package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;

import java.util.ArrayList;
import java.util.Random;

public class Controller {

    @FXML
    public TextField generateNum;
    @FXML
    public TextField range;
    @FXML
    public ListView<Integer> generatedList;
    @FXML
    public ListView<Integer> sortedList;

    public void generateNumbers() {

        ArrayList<Integer> array = new ArrayList<>();
        Random random = new Random();

        for (int j = 0; j <= Integer.parseInt(generateNum.getText()); j++) {
            int randomNumberArray = random.nextInt(Integer.parseInt(range.getText())) + 1;
            array.add(randomNumberArray);
        }
        int l = array.size();
        System.out.println(array);

        for (int z : array) {
            generatedList.getItems().add(z);
        }

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l - 1; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    array.set(j, array.get(j) + array.get(j + 1));
                    array.set(j + 1, array.get(j) - array.get(j + 1));
                    array.set(j, array.get(j) - array.get(j + 1));
                } else if (array.get(j).equals(array.get(j + 1))) {
                    array.remove(j);
                    l = array.size();
                }
            }
        }
        for (int s : array) {
            System.out.print(s + ", ");
            sortedList.getItems().add(s);
        }
    }
}