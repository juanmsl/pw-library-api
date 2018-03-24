package pwlibraryapi.JaveLibrary.models;


import pwlibraryapi.JaveLibrary.entities.Autor;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface AutorDao extends CrudRepository<Autor, Long> {

}
