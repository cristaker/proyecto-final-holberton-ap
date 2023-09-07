package com.holberton.hotel;
import com.holberton.hotel.controller.SessionController;
import com.holberton.hotel.model.Session;
import com.holberton.hotel.view.MenuPrincipal;
import com.holberton.hotel.view.MenuUsuario;


import java.awt.*;


public class Main {
    private static final SessionController session = new SessionController();
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Session session1 = session.obtenerSession();
            try {
                if(session1.getIdUsuario() == null) {
                    MenuPrincipal frame = new MenuPrincipal();
                    frame.setVisible(true);
                } else {
                    MenuUsuario frame = new MenuUsuario();
                    frame.setVisible(true);
                }




            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}