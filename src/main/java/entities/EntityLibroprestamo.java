package entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "libroprestamo", schema = "javelibrary", catalog = "")
@IdClass(EntityLibroprestamoPK.class)
public class EntityLibroprestamo {
    private int libroId;
    private int prestamoId;
    private Date fechadevolucion;

    @Id
    @Column(name = "libro_id")
    public int getLibroId() {
        return libroId;
    }

    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }

    @Id
    @Column(name = "prestamo_id")
    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    @Basic
    @Column(name = "fechadevolucion")
    public Date getFechadevolucion() {
        return fechadevolucion;
    }

    public void setFechadevolucion(Date fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityLibroprestamo that = (EntityLibroprestamo) o;

        if (libroId != that.libroId) return false;
        if (prestamoId != that.prestamoId) return false;
        if (fechadevolucion != null ? !fechadevolucion.equals(that.fechadevolucion) : that.fechadevolucion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = libroId;
        result = 31 * result + prestamoId;
        result = 31 * result + (fechadevolucion != null ? fechadevolucion.hashCode() : 0);
        return result;
    }
}
