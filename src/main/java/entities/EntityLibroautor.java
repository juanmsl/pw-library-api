package entities;

import javax.persistence.*;

@Entity
@Table(name = "libroautor", schema = "javelibrary", catalog = "")
@IdClass(EntityLibroautorPK.class)
public class EntityLibroautor {
    private int libroId;
    private int autorId;

    @Id
    @Column(name = "libro_id")
    public int getLibroId() {
        return libroId;
    }

    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }

    @Id
    @Column(name = "autor_id")
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

        EntityLibroautor that = (EntityLibroautor) o;

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
