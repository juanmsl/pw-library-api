package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EntityLibroprestamoPK implements Serializable {
    private int libroId;
    private int prestamoId;

    @Column(name = "libro_id")
    @Id
    public int getLibroId() {
        return libroId;
    }

    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }

    @Column(name = "prestamo_id")
    @Id
    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityLibroprestamoPK that = (EntityLibroprestamoPK) o;

        if (libroId != that.libroId) return false;
        if (prestamoId != that.prestamoId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = libroId;
        result = 31 * result + prestamoId;
        return result;
    }
}
