package co.edu.uniquindio.ingesis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Cine {

    private List<Usuario> usuarios;

    public Cine() {
        usuarios = new ArrayList<>();
    }

    public void adicionarUsuario(String nombre, String cedula) throws Exception {
        Usuario usuario = new Usuario(nombre,cedula);
        if(  buscarUsuario(cedula) != null ){
            throw new Exception("El usuario ya existe");
        }
        usuarios.add(usuario);
    }

    public Usuario buscarUsuario01(String cedula) {
        for (int i = 0; i < usuarios.size(); i++) {
            if( usuarios.get(i).getCedula().equals(cedula) ){
                return usuarios.get(i);
            }
        }
        return null;
    }

    public Usuario buscarUsuario(String cedula) {
        for (Usuario usuario : usuarios) {
            if( usuario.getCedula().equals(cedula) ){
                return usuario;
            }
        }
        return null;
    }

    public Usuario buscarUsuarioNew(String cedula) {
        return usuarios
                .stream()
                .filter( usuario -> usuario.getCedula()
                        .equals(cedula) )
                .findFirst().get();
    }
}
