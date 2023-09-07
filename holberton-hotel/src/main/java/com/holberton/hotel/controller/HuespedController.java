package com.holberton.hotel.controller;

import com.holberton.hotel.dao.HuespedDao;
import com.holberton.hotel.dao.ReservaDao;
import com.holberton.hotel.factory.ConexionFactory;
import com.holberton.hotel.model.Huesped;


import java.sql.Connection;
import java.util.List;

public class HuespedController {
    private ReservaDao reservaDao;
    private HuespedDao huespedDao;
    private static Long reserva = ReservaController.getReservaId();
    private Connection con;

    public HuespedController() {
        this.con = new ConexionFactory().recuperaConexion();
        this.huespedDao = new HuespedDao(this.con);
    }

    public void guardar(Huesped huesped){

        huesped.setReservaId(reserva);



        this.huespedDao.guardarHuesped(huesped);
    }

    public Long getReserva() {
        return reserva;
    }

    public List<Huesped> obtenerHuespedes() {
        return this.huespedDao.obtenerHuespedes();
    }

    public List<Huesped> obtenerPorApellido(String apellido) {
        return this.huespedDao.obtenerPorApellido(apellido);
    }

    public List<Huesped> obtenerPorReserva(int text) {
        return this.huespedDao.obtenerPorReserva(text);
    }

    public int modificar(Huesped huesped) {
        return this.huespedDao.modificar(huesped);
    }

    public int eliminar(int id) {
        return this.huespedDao.eliminar(id);
    }
}
