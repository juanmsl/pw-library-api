package pwlibraryapi.JaveLibrary.controllers;

import pwlibraryapi.JaveLibrary.entities.Libro;

public class LibroController {

    public Libro createLibro (Libro libroToCreate){
        Libro libro = new Libro();
        libro.setNombre(libroToCreate.getNombre());
        libro.setIsbn(libroToCreate.getIsbn());
        libro.setDisponible(libroToCreate.getDisponible());
        libro.setAutores(libroToCreate.getAutores());

        return libro;
    }

    public void updateLibro (Libro libro , Libro libroToUpdate){
        libroToUpdate.setNombre(libro.getNombre());
        libroToUpdate.setIsbn(libro.getIsbn());
        libroToUpdate.setDisponible(libro.getDisponible());
    }
}
