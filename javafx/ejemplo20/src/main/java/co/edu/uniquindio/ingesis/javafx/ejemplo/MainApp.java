package co.edu.uniquindio.ingesis.javafx.ejemplo;

import co.edu.uniquindio.ingesis.javafx.ejemplo.controllers.AppController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("diplomado-estudiante-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 450);
        stage.setTitle("Diplomado de Programación!!!");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        AppController.INSTANCE.guardar();
        super.stop();
    }

    public static void main(String[] args) {
        launch();
    }
}