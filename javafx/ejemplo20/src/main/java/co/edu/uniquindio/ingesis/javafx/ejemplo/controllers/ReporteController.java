package co.edu.uniquindio.ingesis.javafx.ejemplo.controllers;

import co.edu.uniquindio.ingesis.javafx.ejemplo.model.EstudianteNotaDTO;
import co.edu.uniquindio.ingesis.javafx.ejemplo.model.Genero;
import co.edu.uniquindio.ingesis.javafx.ejemplo.model.Reporte;
import co.edu.uniquindio.ingesis.javafx.ejemplo.utils.TextFormatterUtil;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import static co.edu.uniquindio.ingesis.javafx.ejemplo.controllers.AppController.INSTANCE;
import static co.edu.uniquindio.ingesis.javafx.ejemplo.utils.MessageFXUtil.mostrarMensaje;

public class ReporteController {
    @FXML
    private Label lbNotaMaxima;
    @FXML
    private Label lbNotaPromedio;
    @FXML
    private Label lbNotaMinima;
    @FXML
    private Label lbGanaron;
    @FXML
    private Label lbPerdieron;
    @FXML
    private TableView<EstudianteNotaDTO> tblEstudiantes;
    @FXML
    private TableColumn<EstudianteNotaDTO,String> colNumeroIdentificacion;
    @FXML
    private TableColumn<EstudianteNotaDTO,String> colNombre;
    @FXML
    private TableColumn<EstudianteNotaDTO,Float> colNota;
    @FXML
    private TextField tfParcial;
    @FXML
    public ComboBox<Genero> cbGenero;

    @FXML
    public void initialize() {
        colNumeroIdentificacion.setCellValueFactory(new PropertyValueFactory<>("numeroIdentificacion"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colNota.setCellValueFactory(new PropertyValueFactory<>("nota"));
        cbGenero.setItems(FXCollections.observableArrayList(Genero.values()));
        tfParcial.setTextFormatter(new TextFormatter<>(TextFormatterUtil::integerFormat));
    }
    public void onGenerarReporteClick(ActionEvent actionEvent) {
        if(tfParcial.getText().isEmpty()){
            mostrarMensaje("Debe ingresar un parcial");
        } else {
            Genero genero = cbGenero.getValue();
            int parcial = Integer.parseInt(tfParcial.getText());
            Reporte reporte = genero != null ? INSTANCE.getDiplomado().generarReporte(parcial,genero)
                    : INSTANCE.getDiplomado().generarReporte(parcial);
            lbGanaron.setText(""+reporte.getNumeroGanaron());
            lbPerdieron.setText(""+reporte.getNumeroPerdieron());
            lbNotaMaxima.setText(""+reporte.getNotaMaxima());
            lbNotaPromedio.setText(""+reporte.getNotaPromedio());
            lbNotaMinima.setText(""+reporte.getNotaMinima());
        }
    }

    public void onLimpiarClick(ActionEvent actionEvent) {
        lbGanaron.setText("0");
        lbPerdieron.setText("0");
        lbNotaMaxima.setText("0");
        lbNotaPromedio.setText("0");
        lbNotaMinima.setText("0");
        tfParcial.setText("");
        cbGenero.setValue(null);
        tblEstudiantes.getItems().clear();
    }
}

