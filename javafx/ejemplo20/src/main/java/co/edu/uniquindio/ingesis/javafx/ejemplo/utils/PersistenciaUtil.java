package co.edu.uniquindio.ingesis.javafx.ejemplo.utils;

import java.io.*;
import java.util.Optional;

public class PersistenciaUtil {
    private PersistenciaUtil(){

    }

    public static void guardar(String nombreArchivo, Serializable objeto){
        try(ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            archivo.writeObject(objeto);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Optional cargar(String nombreArchivo){
        Object objeto = null;
        try(ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            objeto = archivo.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.ofNullable(objeto);
    }
}
