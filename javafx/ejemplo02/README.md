# Ejemplo 02
Ejemplo de JavaFX que muestra una ventana con un botón, al dar clic en el botón se muestra un texto de saludo.

## Tools

- java 11
- junit 5.4.0
- JavaFX 19
- maven

## Build and Run

To compile and run the project use the next command:
```shel 
mvn clean javafx:run
```

To generate app use the next command:

```shell
 mvn javafx:jlink
```

The app is generated in target/app and app.zip

## Class and Interfaces

### MainApp
Inicia la aplicación cargando la ventana hello-view

```java
public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
```


### HelloController
Controlador de la ventana. Contiene el método que responde a la acción de clic sobre el botón. 

```java
public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
```

## Vista

### hello-view.fxml
Representa la venta. Actualmente, una ventana con un label y ub botón. La ventana apunta a la clase HelloController como controlador de la ventana.

```xml
<VBox alignment="CENTER" spacing="20.0" xmlns:fx="http://javafx.com/fxml"
      fx:controller="co.edu.uniquindio.ingesis.javafx.ejemplo.HelloController">
    <padding>
        <Insets bottom="20.0" left="20.0" right="20.0" top="20.0"/>
    </padding>

    <Label fx:id="welcomeText"/>
    <Button text="Hello!" onAction="#onHelloButtonClick"/>
</VBox>
```