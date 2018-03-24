package pwlibraryapi.JaveLibrary.controllers;

import pwlibraryapi.JaveLibrary.entities.Autor;

public class AutorController {

    public Autor createAutor (String nombre){
        Autor autor = new Autor(nombre);
        return autor;
    }
}
