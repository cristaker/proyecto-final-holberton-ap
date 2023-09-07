package com.holberton.hotel.controller;

import com.holberton.hotel.dao.SessionDao;
import com.holberton.hotel.factory.ConexionFactory;
import com.holberton.hotel.model.Session;

import java.sql.Connection;

public class  SessionController {
    private static Session session;

    private  SessionDao sessionDao;

    public SessionController(){
        Connection con = new ConexionFactory().recuperaConexion();
        this.sessionDao = new SessionDao(con);
    }

    public void guardarSession(Session sessionUser){
        session = sessionUser;
        this.sessionDao.guardarSession(sessionUser);
    }

    public Session obtenerSession(){
        if(session == null){
            return this.sessionDao.obtenerSession();
        }

        return session;
    }

    public void eliminarSesion() {
        if(session == null) {
            this.sessionDao.eliminarSession();
            return;
        }
        session = null;

    }
}
