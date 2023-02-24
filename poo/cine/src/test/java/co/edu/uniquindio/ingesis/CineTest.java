package co.edu.uniquindio.ingesis;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CineTest {

    @Test
    public void adicionarClienteTest() throws Exception {
        Cine cine = new Cine();
        String nombre = "Pedro";
        String cedula = "123";
        cine.adicionarUsuario(nombre,cedula);
        Usuario usuario = cine.buscarUsuario(cedula);
        Assertions.assertNotNull(usuario);
        Assertions.assertEquals(nombre,usuario.getNombre());
    }

    @Test
    public void adicionarClienteTest02() throws Exception {
        Cine cine = new Cine();
        String nombre = "Pedro";
        String cedula = "123";
        cine.adicionarUsuario(nombre,cedula);
        Usuario usuario = cine.buscarUsuario(cedula);



        Assertions.assertNotNull(usuario);
        Assertions.assertEquals(nombre,usuario.getNombre());

        // Ya esta adicionado
        Assertions.assertThrows(Exception.class,( )->cine.adicionarUsuario(nombre,cedula));

    }

    @Test
    public void adicionarClienteTest03() throws Exception {
        Cine cine = new Cine();
        String nombre = null;
        String cedula = "123";

        Assertions.assertThrows(Exception.class,( )->cine.adicionarUsuario(nombre,cedula));
    }

    @Test
    public void adicionarClienteTest04() throws Exception {
        Cine cine = new Cine();
        String nombre = "pedro";
        String cedula = null;

        Assertions.assertThrows(Exception.class,( )->cine.adicionarUsuario(nombre,cedula));
    }

    @Test
    public void adicionarClienteTest05() throws Exception {
        Cine cine = new Cine();
        String nombre = "Pedro";
        String cedula = "123";
        cine.adicionarUsuario(nombre,cedula);
        Usuario usuario = cine.buscarUsuario(cedula);
        Assertions.assertNotNull(usuario);
        Assertions.assertEquals(nombre,usuario.getNombre());

        String nuevoNombre = "juan";
        // Ya esta adicionado
        Exception e = Assertions.assertThrows(Exception.class,( )->cine.adicionarUsuario(nuevoNombre,cedula));
        Assertions.assertEquals("El usuario ya existe",e.getMessage());
    }

    @Test
    public void adicionarClienteTest06() throws Exception {
        Cine cine = new Cine();
        String nombre = "Pedro";
        String cedula = "123";
        cine.adicionarUsuario(nombre,cedula);
        Usuario usuario = cine.buscarUsuario(cedula);
        Assertions.assertNotNull(usuario);
        Assertions.assertEquals(nombre,usuario.getNombre());

        String nuevaCedula = "789";
        // Ya esta adicionado
        cine.adicionarUsuario(nombre,nuevaCedula);

        Usuario nuevoUsuario = cine.buscarUsuario(nuevaCedula);
        Assertions.assertNotNull(nuevoUsuario);
        Assertions.assertEquals(nombre,nuevoUsuario.getNombre());

    }

    @Test
    public void adicionarClienteTest07() throws Exception {
        Cine cine = new Cine();
        String nombre = null;
        String cedula = null;

        Assertions.assertThrows(Exception.class,( )->cine.adicionarUsuario(nombre,cedula));
    }

    @Test
    public void adicionarClienteTest08() throws Exception {
        Cine cine = new Cine();
        String nombre = "";
        String cedula = "123";

        Assertions.assertThrows(Exception.class,( )->cine.adicionarUsuario(nombre,cedula));
    }

    @Test
    public void adicionarClienteTest09() throws Exception {
        Cine cine = new Cine();
        String nombre = "pedro";
        String cedula = " ";

        Assertions.assertThrows(Exception.class,( )->cine.adicionarUsuario(nombre,cedula));
    }

    @Test
    public void adicionarClienteTest10() throws Exception {
        Cine cine = new Cine();
        String nombre = "pedro";
        String cedula = "ABC";

        Assertions.assertThrows(Exception.class,( )->cine.adicionarUsuario(nombre,cedula));
    }
}
