package pwlibraryapi.JaveLibrary.controllers;

import pwlibraryapi.JaveLibrary.entities.Usuario;

public class UsuarioController {

    public Usuario createUsuario(Usuario usuario){
        Usuario user = new Usuario();

        user.setNombres(usuario.getNombres());
        user.setApellidos(usuario.getApellidos());
        user.setUsuario(usuario.getUsuario());
        user.setTipo(usuario.getTipo());
        user.setDocumento(usuario.getDocumento());

        return user;
    }

    public void updateUsuario (Usuario usuario , Usuario userToUpdate){
        userToUpdate.setUsuario(usuario.getUsuario());
        userToUpdate.setNombres(usuario.getNombres());
        userToUpdate.setApellidos(usuario.getApellidos());
        userToUpdate.setTipo(usuario.getTipo());
        userToUpdate.setDocumento(usuario.getDocumento());

    }
}
