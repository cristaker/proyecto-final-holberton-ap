package com.registro.usuarios.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.modelo.Usuario;


public interface UsuarioServicio extends UserDetailsService {

    Usuario guardar(UsuarioRegistroDTO registroDTO);

    List<Usuario> listarUsuarios();

    Usuario obtenerUsuarioPorId(Long id);

    Usuario actualizarUsuario(Long id, UsuarioRegistroDTO registroDTO);

    void eliminarUsuario(Long id);
}