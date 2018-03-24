package pwlibraryapi.JaveLibrary.controllers;

import pwlibraryapi.JaveLibrary.models.AutorDao;
import pwlibraryapi.JaveLibrary.entities.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {

    @Autowired
    private AutorDao autorDao;



    @GetMapping(value = "/add/autor")
    public Autor createAutor(@RequestParam String nombre){
        Autor autor = new AutorController().createAutor(nombre);
        autorDao.save(autor);
        return autor;
    }

}
