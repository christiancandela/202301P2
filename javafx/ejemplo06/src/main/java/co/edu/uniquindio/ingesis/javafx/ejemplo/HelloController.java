package co.edu.uniquindio.ingesis.javafx.ejemplo;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private ComboBox<String> cbOpciones;

    @FXML
    protected void onHelloButtonClick() {
        if( cbOpciones.getValue() != null ){
            welcomeText.setText("seleccionó "+cbOpciones.getValue());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Debe seleccionar una opción");
            alert.showAndWait();
        }
    }

    @FXML
    public void initialize(){
        cbOpciones.setItems(
                FXCollections.observableArrayList("Opcion 1","Opcion 2","Opcion 3","Opcion 4")
        );
    }
}