package co.edu.uniquindio.ingesis.ejemplojavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField campoTexto2;
    @FXML
    private TextField campoTexto;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Hola "+campoTexto.getText());
    }

    public void sumar(ActionEvent actionEvent) {
        try {
            int resultado = Integer.parseInt(campoTexto.getText()) +
                    Integer.parseInt(campoTexto2.getText());
            welcomeText.setText("El valor es " + resultado);
        }catch (Exception e){
            Alert alerta = new Alert(Alert.AlertType.ERROR,"Solo se aceptan números");
            alerta.showAndWait();
        }
    }
}