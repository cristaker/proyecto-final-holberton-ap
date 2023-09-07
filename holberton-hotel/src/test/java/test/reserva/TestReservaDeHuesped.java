package test.reserva;

import com.holberton.hotel.Enums.FormPago;
import com.holberton.hotel.dao.HuespedDao;
import com.holberton.hotel.dao.ReservaDao;
import com.holberton.hotel.factory.ConexionFactory;
import com.holberton.hotel.model.Huesped;
import com.holberton.hotel.model.Reserva;

import java.sql.Connection;
import java.sql.Date;

public class TestReservaDeHuesped {
    public static void main(String[] args) {
        Connection con = new ConexionFactory().recuperaConexion();
        HuespedDao huespedDao = new HuespedDao(con);
        ReservaDao reservaDao = new ReservaDao(con);


        Reserva reserva = new Reserva(
                Date.valueOf("2023-08-30"),
                Date.valueOf("2023-09-5"),
                10,
                "Dinero en efectivo"
        );

        Long result =  reservaDao.guardar(reserva);

        Huesped huesped = new Huesped(
                "Shiara",
                "Barajas",
                Date.valueOf("2019-05-09"),
                "Venezolana",
                "01234567890",
                result
        );

        huespedDao.guardarHuesped(huesped);





    }
}
