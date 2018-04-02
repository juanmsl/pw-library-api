package pwlibraryapi.JaveLibrary.controllers;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.web.bind.annotation.*;
import pwlibraryapi.JaveLibrary.entities.*;
import pwlibraryapi.JaveLibrary.models.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@CrossOrigin(allowedHeaders = {"http://192.168.0.10","http://192.168.0.14"})
@RestController
public class LibraryController {

    @Autowired
    private AutorDao autorDao;

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private LibroDao libroDao;

    @Autowired
    private PrestamoDao prestamoDao;

    @Autowired
    private LibroPrestamoDao libroPrestamoDao;

    @GetMapping(value = "/libro/{id}")
    public Libro getLibro(@PathVariable Integer id){
        return libroDao.findById(id).orElseThrow(()-> new EntityNotFoundException());
    }

    @PostMapping(value = "/libro")
    public Libro createLibro(@RequestBody Libro libro){
        AutorController autorController = new AutorController();
        LibroController libroController = new LibroController();
        List<Autor> autores = autorController.createAutors(libro.getAutores(), autorDao);
        Libro libroToCreate = libroController.createLibro(libro, autores);
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
        Usuario userToUpdate = usuarioDao.findById(usuario.getId()).orElseGet(()->{
            Usuario usuarioTemporal = new Usuario();
            usuarioTemporal.setMessage("No se pudo actualizar la info del usuario con id: " +  usuario.getId()
            + "ya que el usuario no existe");
            return usuarioTemporal;
        });
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
    public Optional<Autor> getAutor(@PathVariable Integer id){
        Optional<Autor> autor = autorDao.findById(id);
        return autor;
    }

    @GetMapping(value = "/usuarios")
    public Collection<Usuario> getUsuarios(){
        return (Collection<Usuario>) usuarioDao.findAll();
    }

    @GetMapping(value = "/libros")
    public Collection<Libro> getLibros(){
        return (Collection<Libro>) libroDao.findAll();
    }

    @GetMapping(value = "/autores")
    public Collection<Autor> getAutores(){
        return (Collection<Autor>) autorDao.findAll();
    }

    @GetMapping(value = "/prestamo/{id}")
    public Optional<Prestamo> getPrestamo(@PathVariable Integer id){
        Optional<Prestamo> prestamo = prestamoDao.findById(id);
        return prestamo;
    }

    @PostMapping(value = "/prestamo")
    public Prestamo createPrestamo(@RequestBody Prestamo prestamo){
        PrestamoController prestamoController = new PrestamoController();
        LibroController libroController = new LibroController();
        LibroPrestamoController libroPrestamoController = new LibroPrestamoController();
        Prestamo prestamoToCreate = prestamoController.createPrestamo(prestamo);
        List<Libro> librosPrestamo = libroController.librosPrestamo(prestamo,libroDao);
        prestamoToCreate.setLibrosPrestamo(librosPrestamo);
        libroPrestamoController.createPrestamo(librosPrestamo, prestamoToCreate, libroPrestamoDao);
        return prestamoToCreate;
    }

    @PutMapping(value = "/prestamo")
    public LibroPrestamo updatePrestamo (@RequestBody LibroDevolucion libroDevolucion){
        LibroPrestamoController libroPrestamoController = new LibroPrestamoController();
        LibroPrestamo libroPrestamo = libroPrestamoDao.findByLibro_IdAndPrestamo_Responsable(libroDevolucion.getLibroId(), libroDevolucion.getResponsable());
        libroPrestamoController.updateDevolucion(libroPrestamo);
        Libro libro = libroDao.findById(libroDevolucion.getLibroId()).orElse(null);
        if(libro!=null){
            libro.setDisponible(true);
            libroDao.save(libro);
        }
        libroPrestamoDao.save(libroPrestamo);
        return libroPrestamo;
    }

    @GetMapping(value = "/historial/{id}")
    public List<LibroPrestamo> getHistorialPrestamo (@PathVariable Integer id){
        PrestamoController prestamoController = new PrestamoController();
        List<LibroPrestamo> libroPrestamos = libroPrestamoDao.findAllByLibro_Id(id);
        return libroPrestamos;
    }
}
