package co.edu.uniquindio.ingesis.javafx.ejemplo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private Button btnLogin;

    @FXML
    protected void onLoginButtonClick(ActionEvent actionEvent) {
        try {
            Control source = (Control) actionEvent.getSource();
            Parent parent = FXMLLoader.load(
                    MainApp.class.getResource("/co/edu/uniquindio/ingesis/javafx/ejemplo/principal-view.fxml")
            );
            Scene scene = new Scene(parent, 320, 240);
            Stage stage = new Stage();
            stage.setTitle("Principal");
            stage.setScene(scene);
            stage.initOwner(source.getScene().getWindow());
            btnLogin.getScene().getWindow().hide();
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
