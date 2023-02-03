package co.edu.uniquindio.ingesis.javafx.ejemplo.controllers;

import co.edu.uniquindio.ingesis.javafx.ejemplo.model.Diplomado;
import co.edu.uniquindio.ingesis.javafx.ejemplo.utils.PersistenciaUtil;

public enum AppController {
    INSTANCE;
    private final Diplomado diplomado;
    private static final String ARCHIVO = "diplomado.dat";
    AppController() {
        diplomado = (Diplomado) PersistenciaUtil.cargar(ARCHIVO).orElse(new Diplomado("Programación",10));
    }

    public Diplomado getDiplomado() {
        return diplomado;
    }

    public void guardar(){
        PersistenciaUtil.guardar(ARCHIVO,diplomado);
    }
}
