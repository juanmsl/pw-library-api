package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EntityLibroautorPK implements Serializable {
    private int libroId;
    private int autorId;

    @Column(name = "libro_id")
    @Id
    public int getLibroId() {
        return libroId;
    }

    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }

    @Column(name = "autor_id")
    @Id
    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityLibroautorPK that = (EntityLibroautorPK) o;

        if (libroId != that.libroId) return false;
        if (autorId != that.autorId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = libroId;
        result = 31 * result + autorId;
        return result;
    }
}
