package pwlibraryapi.JaveLibrary.controllers;

import pwlibraryapi.JaveLibrary.entities.Libro;
import pwlibraryapi.JaveLibrary.entities.LibroPrestamo;
import pwlibraryapi.JaveLibrary.entities.Prestamo;
import pwlibraryapi.JaveLibrary.models.LibroPrestamoDao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LibroPrestamoController {
    public void createPrestamo (List<Libro> librosPrestamo, Prestamo prestamo, LibroPrestamoDao libroPrestamoDao){
        for(Libro libro : librosPrestamo){
            LibroPrestamo libroPrestamo = new LibroPrestamo();
            libroPrestamo.setLibro(libro);
            libroPrestamo.setPrestamo(prestamo);
            libroPrestamoDao.save(libroPrestamo);
        }
    }

    public void updateDevolucion (LibroPrestamo libroPrestamo){
        if(libroPrestamo.getFechadevolucion()== null){
            Date fechaDevolucion;
            Calendar fecha = Calendar.getInstance();
            fechaDevolucion = fecha.getTime();
            libroPrestamo.setFechadevolucion(fechaDevolucion);
        }
    }
}
