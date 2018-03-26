package pwlibraryapi.JaveLibrary.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String nombre;

    @NotNull
    private String isbn;

    @NotNull
    private Boolean disponible;

    public Libro(int id){
        this.id = id;
    }

    public Libro (){}

    public Libro(@NotNull String nombre, @NotNull String isbn, @NotNull Boolean disponible) {
        this.nombre = nombre;
        this.isbn = isbn;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
}
