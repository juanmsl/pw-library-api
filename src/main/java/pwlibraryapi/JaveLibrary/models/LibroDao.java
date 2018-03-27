package pwlibraryapi.JaveLibrary.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pwlibraryapi.JaveLibrary.entities.Libro;

import javax.transaction.Transactional;

@Transactional
public interface LibroDao extends JpaRepository<Libro, Integer> {
}
