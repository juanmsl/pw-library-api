package pwlibraryapi.JaveLibrary.controllers;

import org.springframework.web.bind.annotation.*;
import pwlibraryapi.JaveLibrary.entities.Libro;
import pwlibraryapi.JaveLibrary.entities.Usuario;
import pwlibraryapi.JaveLibrary.models.AutorDao;
import pwlibraryapi.JaveLibrary.entities.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import pwlibraryapi.JaveLibrary.models.LibroDao;
import pwlibraryapi.JaveLibrary.models.UsuarioDao;

import javax.persistence.EntityNotFoundException;

@RestController
public class LibraryController {

    @Autowired
    private AutorDao autorDao;

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private LibroDao libroDao;

    @GetMapping(value = "/libro/{id}")
    public Libro getLibro(@PathVariable Integer id){
        return libroDao.findById(id).orElseThrow(()-> new EntityNotFoundException());
    }

    @PostMapping(value = "/libro")
    public Libro createLibro(@RequestBody Libro libro){
        Libro libroToCreate = new LibroController().createLibro(libro);
        libroDao.save(libroToCreate);
        return libroToCreate;
    }

    @PutMapping(value = "/libro")
    public Libro updateLibro(@RequestBody Libro libro){
        Libro libroToUpdate = libroDao.findById(libro.getId()).orElseThrow(()-> new EntityNotFoundException());
        LibroController libroController = new LibroController();
        libroController.updateLibro(libro, libroToUpdate);
        libroDao.save(libroToUpdate);
        return libroToUpdate;
    }

    @DeleteMapping(value = "/libro")
    public String deleteLibro(@RequestBody Libro libro){
        libroDao.deleteById(libro.getId());
        return "Libro eliminado";
    }

    @GetMapping(value = "/usuario/{id}")
    public Usuario getUsuario(@PathVariable Integer id){
        return usuarioDao.findById(id).orElseThrow(()-> new EntityNotFoundException());
    }

    @PostMapping(value = "/usuario")
    public Usuario createUsuario(@RequestBody Usuario usuario){
        Usuario user = new UsuarioController().createUsuario(usuario);
        usuarioDao.save(user);
        return user;
    }

    @PutMapping(value = "/usuario")
    public Usuario updateUsuario(@RequestBody Usuario usuario){
        Usuario userToUpdate = usuarioDao.findById(usuario.getId()).orElseThrow(()-> new EntityNotFoundException());
        UsuarioController usuarioController = new UsuarioController();
        usuarioController.updateUsuario(usuario, userToUpdate);
        usuarioDao.save(userToUpdate);
        return userToUpdate;
    }

    @DeleteMapping(value = "/usuario")
    public String deleteUsuario(@RequestBody Usuario usuario){
        usuarioDao.deleteById(usuario.getId());
        return "Usuario eliminado";
    }


    @GetMapping(value = "/autor/{id}")
    public Autor getAutor(@PathVariable Integer id){
        Autor autor = autorDao.findById(id).orElseThrow(()-> new EntityNotFoundException());
        return autor;
    }

}
