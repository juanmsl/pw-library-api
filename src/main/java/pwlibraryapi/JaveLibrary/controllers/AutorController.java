package pwlibraryapi.JaveLibrary.controllers;

import pwlibraryapi.JaveLibrary.entities.Autor;

public class AutorController {

    public Autor createAutor (Autor autor){
        Autor autorToCreate = new Autor();
        autorToCreate.setNombre(autor.getNombre());
        autorToCreate.setLibros(autor.getLibros());
        return autorToCreate;
    }
}
