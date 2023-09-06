package com.registro.usuarios.controlador;

import com.registro.usuarios.modelo.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.servicio.UsuarioServicio;

import java.util.List;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

    private UsuarioServicio usuarioServicio;

    public RegistroUsuarioControlador(UsuarioServicio usuarioServicio) {
        super();
        this.usuarioServicio = usuarioServicio;
    }

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro(Model model) {
        // Agregar aquí la lógica para cargar la lista de usuarios y enviarla a la vista.
        List<Usuario> usuarios = usuarioServicio.listarUsuarios();
        model.addAttribute("usuarios", usuarios);

        return "registro";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
        usuarioServicio.guardar(registroDTO);
        return "redirect:/registro?exito";
    }

    // Editar un usuario (mostrar formulario de edición)
    @GetMapping("/{id}/editar")
    public String mostrarFormularioEditarUsuario(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioServicio.obtenerUsuarioPorId(id);
        model.addAttribute("usuario", usuario);
        return "editar_usuario";
    }

    // Actualizar un usuario
    @PostMapping("/{id}/editar")
    public String actualizarUsuario(@PathVariable Long id, @ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
        usuarioServicio.actualizarUsuario(id, registroDTO);
        return "redirect:/registro?exito";
    }

    // Eliminar un usuario
    @DeleteMapping("/{id}/eliminar")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioServicio.eliminarUsuario(id);
        return "redirect:/registro?exito";
    }
}