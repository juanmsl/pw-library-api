package pwlibraryapi.JaveLibrary.models;

import org.springframework.data.repository.CrudRepository;
import pwlibraryapi.JaveLibrary.entities.LibroPrestamo;

import java.util.List;

public interface LibroPrestamoDao extends CrudRepository<LibroPrestamo, Integer> {
    List<LibroPrestamo> findAllByLibro_Id(int id);
    LibroPrestamo findByLibro_IdAndPrestamo_Responsable(int id, String responsable);
}
