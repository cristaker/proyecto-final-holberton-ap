package test.usuario;

import com.holberton.hotel.controller.SessionController;
import com.holberton.hotel.dao.UsuarioDao;
import com.holberton.hotel.factory.ConexionFactory;
import com.holberton.hotel.model.Session;
import com.holberton.hotel.model.Usuario;
import com.holberton.hotel.utils.ValidatePasswords;

import java.sql.Connection;


public class TestSesion {
    public static void main(String[] args) {
        crearSesion();
    }

    public static void eliminarSesion(){
        SessionController sessionController = new SessionController();
        sessionController.eliminarSesion();
    }

    public static void crearSesion(){
        Session session = new Session(1L);

        SessionController sessionController = new SessionController();
        sessionController.guardarSession(session);

        Session session1 =  sessionController.obtenerSession();

        System.out.println(session1.getIdUsuario());
    }
    public static void crearUsuario(){
        Connection con = new ConexionFactory().recuperaConexion();
        UsuarioDao usuarioDao = new UsuarioDao(con);

        String password = ValidatePasswords.encryptPassword("031182");
        Usuario usuario = new Usuario("Juan","Barajas","JBarajas",password);

        usuarioDao.guardarUsuario(usuario);
        Usuario usuario1 = usuarioDao.obtenerUsuario("JBarajas");
    }
}
