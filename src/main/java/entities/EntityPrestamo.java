package entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "prestamo", schema = "javelibrary", catalog = "")
public class EntityPrestamo {
    private int id;
    private String responsable;
    private Date fechaprestamo;
    private Date fechavencimiento;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "responsable")
    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    @Basic
    @Column(name = "fechaprestamo")
    public Date getFechaprestamo() {
        return fechaprestamo;
    }

    public void setFechaprestamo(Date fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }

    @Basic
    @Column(name = "fechavencimiento")
    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityPrestamo that = (EntityPrestamo) o;

        if (id != that.id) return false;
        if (responsable != null ? !responsable.equals(that.responsable) : that.responsable != null) return false;
        if (fechaprestamo != null ? !fechaprestamo.equals(that.fechaprestamo) : that.fechaprestamo != null)
            return false;
        if (fechavencimiento != null ? !fechavencimiento.equals(that.fechavencimiento) : that.fechavencimiento != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (responsable != null ? responsable.hashCode() : 0);
        result = 31 * result + (fechaprestamo != null ? fechaprestamo.hashCode() : 0);
        result = 31 * result + (fechavencimiento != null ? fechavencimiento.hashCode() : 0);
        return result;
    }
}
