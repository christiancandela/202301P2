# Ejemplo 15
El ejemplo muestra el registro de pasajeros que abordaran un bus de transporte intermunicipal. 
A cada pasajero que abordará el bus se le solicita número de identificación, nombre, apellido y género (Masculino/ Femenenino).
El género de la persona es ingresado mediante el uso de un combobox (lista de selección).


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
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("persona-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 350);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
```


### PersonaController
Controlador de la ventana. Contiene los métodos y lógica de interacción con el usuario. 

```java
public class PersonaController {
    @FXML
    private TableView<Persona> tblPersonas;
    @FXML
    private TableColumn<Persona, String> colNumeroIdentificacion;
    @FXML
    private TableColumn<Persona, String> colNombre;
    @FXML
    private TableColumn<Persona, String> colApellido;
    @FXML
    private TableColumn<Persona, Genero> colGenero;
    @FXML
    private TextField tfNumeroIdentificacion;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfApellido;
    @FXML
    private ComboBox<Genero> cbGenero;

    @FXML
    public void initialize() {
        llenarTabla(INSTANCE.getBus().buscar(null, null, null,null));
        colNumeroIdentificacion.setCellValueFactory(new PropertyValueFactory<>("numeriIdentificacion"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        tblPersonas.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> llenarCampos(newValue));
        tfNumeroIdentificacion.setTextFormatter(new TextFormatter<>(TextFormatterUtil::integerFormat));
        tfNombre.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        tfApellido.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        cbGenero.setItems( FXCollections.observableArrayList(Genero.values()) );
    }

    public void onGuardarClick() {
        try {
            Persona persona = Persona.of(tfNumeroIdentificacion.getText(), tfNombre.getText(), tfApellido.getText(),
                    cbGenero.getValue());
            INSTANCE.getBus().adicionarPersona(persona);
            llenarTabla(INSTANCE.getBus().buscar(null, null, null,null));
            limpiarCampos();
            mostrarInformacion("La persona fue aceptada en el bus");
        } catch (Exception e) {
            mostrarMensaje(e.getMessage());
        }
    }

    public void onCancelarClick() {
        limpiarCampos();
        tblPersonas.getSelectionModel().clearSelection();
    }

    public void onRemoverClick() {
        try {
            INSTANCE.getBus().removerPersona(tfNumeroIdentificacion.getText());
            llenarTabla(INSTANCE.getBus().buscar(null, null, null,null));
            limpiarCampos();
            mostrarInformacion("La persona fue retirada del bus");
        } catch (Exception e) {
            mostrarMensaje(e.getMessage());
        }
    }

    public void onBuscarClick() {
        llenarTabla(
                INSTANCE.getBus().buscar(tfNumeroIdentificacion.getText(), tfNombre.getText(), tfApellido.getText(),cbGenero.getValue())
        );
    }

    private void llenarCampos(Persona persona) {
        if (persona != null) {
            tfNumeroIdentificacion.setText(persona.getNumeriIdentificacion());
            tfNombre.setText(persona.getNombre());
            tfApellido.setText(persona.getApellido());
            cbGenero.setValue( persona.getGenero() );
        }
    }

    private void limpiarCampos() {
        tfNumeroIdentificacion.setText("");
        tfNombre.setText("");
        tfApellido.setText("");
        cbGenero.setValue( null );
    }

    private void llenarTabla(List<Persona> personas) {
        tblPersonas.setItems(FXCollections.observableArrayList(personas));
        tblPersonas.refresh();
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarInformacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
```

### AppController
Clase que contiene los elementos generales de la lógica de la aplicación y permite a la gui acceder a ellos.

```java
public enum AppController {
    INSTANCE;
    private final Bus bus;

    AppController() {
        bus = new Bus();
    }

    public Bus getBus() {
        return bus;
    }
}

```

### PersonaExisteException
Excepción generada cuando se intenta ingresar una persona que ya se ha registrado previamente.

```java
public class PersonaExisteException extends Exception{
    public PersonaExisteException() {
        super("La persona ya esta en el bus");
    }
}
```

### PersonaNoExisteException
Excepción generada cuando se intenta remover una persona que no se ha registrado previamente.

```java
public class PersonaNoExisteException extends Exception {
    public PersonaNoExisteException() {
        super("La persona no existe");
    }
}
```

### ValorRequeridoException
Excepción generada cuando se omite un valor requerido en alguna de las operaciones.

```java
public class ValorRequeridoException extends Exception{
    public ValorRequeridoException(String nombre) {
        super(String.format("El %s es requerido",nombre));
    }
}
```
### Genero
Enumeración que representa el género dela persona.

```java
public enum Genero {
    FEMENINO,
    MASCULINO
}
```

### Bus
Clase que representa el bus en el que se registraran las personas.

```java
public class Bus {
    private final List<Persona> personas;

    public Bus() {
        personas = new ArrayList<>();
    }

    public void adicionarPersona(Persona persona) throws PersonaExisteException {
        if( buscarPersonaByNumeroIdentificacion( persona.getNumeriIdentificacion() ).isPresent() ){
            throw new PersonaExisteException();
        }
        personas.add(persona);
    }

    public void removerPersona(String numeroIdentificacion) throws PersonaNoExisteException, ValorRequeridoException {
        if(Objects.requireNonNull(numeroIdentificacion,"El número de identificación es requerido").isEmpty()){
            throw new ValorRequeridoException("número de identificación");
        }
        Optional<Persona> persona = buscarPersonaByNumeroIdentificacion(numeroIdentificacion);
        if( persona.isEmpty() ){
            throw new PersonaNoExisteException();
        }
        personas.remove(persona.get());
    }

    public Optional<Persona> buscarPersonaByNumeroIdentificacion(String numeriIdentificacion) {
        return personas.stream()
                .filter(PersonaUtil.buscarPorNumeroIdentificacion(numeriIdentificacion))
                .findFirst();
    }

    public List<Persona> buscar(String numeroIdentificacion,String nombre,String apellido){
        return Collections.unmodifiableList(
                personas.stream()
                        .filter(PersonaUtil.buscarPorTodo(numeroIdentificacion,nombre,apellido))
                        .collect(Collectors.toList())
        );
    }
}
```

### Persona
Excepción generada cuando se omite un valor requerido en alguna de las operaciones.

```java
public class Persona {
    private final String numeriIdentificacion;
    private final String nombre;
    private final String apellido;
    private final Genero genero;
    private Persona(String numeriIdentificacion, String nombre, String apellido,Genero genero) {
        this.numeriIdentificacion = numeriIdentificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
    }

    public static Persona of(String numeroIdentificacion, String nombre, String apellido,Genero genero) throws ValorRequeridoException {
        if(Objects.requireNonNull(numeroIdentificacion,"El número de identificación es requerido").isEmpty()){
            throw new ValorRequeridoException("número de identificación");
        }
        if(Objects.requireNonNull(nombre,"El nombre es requerido").isEmpty()){
            throw new ValorRequeridoException("nombre");
        }
        if(Objects.requireNonNull(apellido,"El apellido es requerido").isEmpty()){
            throw new ValorRequeridoException("apellido");
        }
        Objects.requireNonNull(genero,"El genero es requerido");

        return new Persona(numeroIdentificacion, nombre, apellido,genero);
    }

    public String getNumeriIdentificacion() {
        return numeriIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Genero getGenero() {
        return genero;
    }
}
```

### PersonaUtil
Clase utilitaria que permite crear predicados para realizar búsquedas basadas en personas.

```java
public class PersonaUtil {
    public static Predicate<Persona> buscarPorNumeroIdentificacion(String numeroIdentificacion){
        return persona -> persona.getNumeriIdentificacion().equals(numeroIdentificacion);
    }

    public static Predicate<Persona> buscarPorNombre(String nombre){
        return persona -> persona.getNombre().contains(nombre);
    }

    public static Predicate<Persona> buscarPorApellido(String apellido){
        return persona -> persona.getApellido().contains(apellido);
    }

    public static Predicate<? super Persona> buscarPorGenero(Genero genero) {
        return persona -> persona.getGenero() == genero;
    }
    public static Predicate<Persona> buscarPorTodo(String numeroIdentificacion, String nombre, String apellido, Genero genero) {
        Predicate<Persona> predicado = persona -> true;
        if( numeroIdentificacion != null && !numeroIdentificacion.isEmpty() ){
            predicado = predicado.and(buscarPorNumeroIdentificacion(numeroIdentificacion));
        }
        if( nombre != null && !nombre.isEmpty() ){
            predicado = predicado.and(buscarPorNombre(nombre));
        }
        if( apellido != null && !apellido.isEmpty() ){
            predicado = predicado.and(buscarPorApellido(apellido));
        }
        if( genero != null ){
            predicado = predicado.and(buscarPorGenero(genero));
        }
        return predicado;
    }
}
```

### TextFormatterUtil
Clase utilitaria que permite contiene métodos usados para dar formato a las entradas en los campos de textos.

```java
public class TextFormatterUtil {
    public static Change upperCaseFormat(Change change){
        change.setText(change.getText().toUpperCase());
        return change;
    }

    public static Change integerFormat(Change change){
        if (change.getText().matches("[0-9]*")) {
            return change;
        }
        return null;
    }
}
```

## Vista

### persona-view.fxml
Representa la venta. Actualmente, una ventana con una tabla, campos de texto para el ingreso de personas y los botones para la interacción del usuario. 
La ventana apunta a la clase PersonaController como controlador de la ventana.

```xml
<VBox alignment="CENTER" prefHeight="460.0" prefWidth="432.0" spacing="20.0" xmlns="http://javafx.com/javafx/19" xmlns:fx="http://javafx.com/fxml/1" fx:controller="co.edu.uniquindio.ingesis.javafx.ejemplo.controllers.PersonaController">
    <padding>
        <Insets bottom="20.0" left="20.0" right="20.0" top="20.0" />
    </padding>
    <GridPane prefHeight="160.0" prefWidth="392.0">
        <columnConstraints>
            <ColumnConstraints hgrow="SOMETIMES" minWidth="10.0" prefWidth="100.0" />
            <ColumnConstraints hgrow="SOMETIMES" minWidth="10.0" prefWidth="100.0" />
        </columnConstraints>
        <rowConstraints>
            <RowConstraints maxHeight="40.0" minHeight="10.0" prefHeight="40.0" vgrow="SOMETIMES" />
            <RowConstraints maxHeight="40.0" minHeight="10.0" prefHeight="40.0" vgrow="SOMETIMES" />
            <RowConstraints maxHeight="40.0" minHeight="10.0" prefHeight="40.0" vgrow="SOMETIMES" />
            <RowConstraints maxHeight="40.0" minHeight="10.0" prefHeight="40.0" vgrow="SOMETIMES" />
        </rowConstraints>
        <Label text="Número de Identificación:" />
        <Label text="Nombre:" GridPane.rowIndex="1" />
        <Label text="Apellido:" GridPane.rowIndex="2" />
        <TextField fx:id="tfNumeroIdentificacion" GridPane.columnIndex="1" />
        <TextField fx:id="tfNombre" GridPane.columnIndex="1" GridPane.rowIndex="1" />
        <TextField fx:id="tfApellido" GridPane.columnIndex="1" GridPane.rowIndex="2" />
        <Label text="Genero:" GridPane.rowIndex="3" />
        <ComboBox fx:id="cbGenero" prefWidth="150.0" promptText="Seleccione el género" GridPane.columnIndex="1" GridPane.rowIndex="3" />
    </GridPane>
    <HBox prefHeight="41.0" prefWidth="301.0">
        <Button mnemonicParsing="false" onAction="#onGuardarClick" text="Guardar" />
        <Button mnemonicParsing="false" onAction="#onCancelarClick" text="Cancelar" />
        <Button mnemonicParsing="false" onAction="#onRemoverClick" text="Remover" />
        <Button mnemonicParsing="false" onAction="#onBuscarClick" text="Buscar" />
    </HBox>
    <TableView fx:id="tblPersonas" prefHeight="200.0" prefWidth="200.0">
        <columns>
            <TableColumn fx:id="colNumeroIdentificacion" prefWidth="126.0" text="Número Identificación" />
            <TableColumn fx:id="colNombre" prefWidth="98.0" text="Nombre" />
            <TableColumn fx:id="colApellido" prefWidth="73.0" text="Apellido" />
            <TableColumn fx:id="colGenero" prefWidth="73.0" text="Genero" />
        </columns>
    </TableView>
</VBox>
```