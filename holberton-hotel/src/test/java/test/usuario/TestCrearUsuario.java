package test.usuario;

import com.holberton.hotel.Enums.FormPago;
import com.holberton.hotel.dao.UsuarioDao;
import com.holberton.hotel.factory.ConexionFactory;
import com.holberton.hotel.model.Reserva;
import com.holberton.hotel.model.Usuario;
import com.holberton.hotel.utils.ValidatePasswords;

import java.sql.Connection;
import java.sql.Date;


public class TestCrearUsuario {
    public static void main(String[] args) {


        Connection con = new ConexionFactory().recuperaConexion();
        String password = ValidatePasswords.encryptPassword("300804");

        Usuario usuarioTest = new Usuario("Cristian","Barajas","cristianb19",password);




        UsuarioDao usuarioDao = new UsuarioDao(con);

        usuarioDao.guardarUsuario(usuarioTest);


    }
}
