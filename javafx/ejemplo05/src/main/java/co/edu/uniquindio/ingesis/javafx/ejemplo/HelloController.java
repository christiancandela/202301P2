package co.edu.uniquindio.ingesis.javafx.ejemplo;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private ComboBox<String> cbOpciones;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("seleccionó "+cbOpciones.getValue());
    }

    @FXML
    public void initialize(){
        cbOpciones.getItems().add("Opcion 1");
        cbOpciones.getItems().add("Opcion 2");
        cbOpciones.getItems().add("Opcion 3");
        cbOpciones.getItems().add("Opcion 4");
    }
}