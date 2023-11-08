package com.example.base7;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> choice;

    @FXML
    private TextFlow gram;

    @FXML
    private TextField inputs;

    @FXML
    private TextFlow kilo;

    @FXML
    private TextFlow tonn;

    @FXML
    void initialize() {
        choice.getItems().addAll("Граммы", "Килограммы", "Тонны");
        choice.setValue("Граммы");
        choice.setOnAction(event -> {
            convertUnits();
        });
        inputs.setOnKeyReleased(event -> {
            convertUnits();
        });
    }

    private void convertUnits() {
        try {
            double inputValue = Double.parseDouble(inputs.getText());
            String selectedUnit = choice.getValue();
            double gramValue = 0;
            double kiloValue = 0;
            double tonnValue = 0;

            if (selectedUnit.equals("Граммы")) {
                gramValue = inputValue;
                kiloValue = inputValue / 1000;
                tonnValue = inputValue / 1000000;
            } else if (selectedUnit.equals("Килограммы")) {
                kiloValue = inputValue;
                gramValue = inputValue * 1000;
                tonnValue = inputValue / 1000;
            } else if (selectedUnit.equals("Тонны")) {
                tonnValue = inputValue;
                kiloValue = inputValue * 1000;
                gramValue = inputValue * 1000000;
            }

            updateTextFlow(gram, Double.toString(gramValue));
            updateTextFlow(kilo, Double.toString(kiloValue));
            updateTextFlow(tonn, Double.toString(tonnValue));
        } catch (NumberFormatException e) {
            updateTextFlow(gram, "Некорректные данные");
            updateTextFlow(kilo, "Некорректные данные");
            updateTextFlow(tonn, "Некорректные данные");
        }
    }

    private void updateTextFlow(TextFlow textFlow, String text) {
        textFlow.getChildren().clear();
        Text newText = new Text(text);
        textFlow.getChildren().add(newText);
    }
}
