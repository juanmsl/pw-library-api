package pwlibraryapi.JaveLibrary.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "libro")
public class Libro{

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "libroautor", joinColumns = @JoinColumn(name = "libro_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id", referencedColumnName = "id"))
    private List<Autor> autores;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String nombre;

    @NotNull
    private String isbn;

    @NotNull
    private Boolean disponible;

    @Transient
    private String message;

    @JsonIgnore
    @OneToMany(mappedBy = "libro")
    private List<LibroPrestamo> prestamos;


    public Libro(int id){
        this.id = id;
    }

    public Libro (){}

    public Libro(List<Autor> autores, @NotNull String nombre, @NotNull String isbn, @NotNull Boolean disponible) {
        this.autores = autores;
        this.nombre = nombre;
        this.isbn = isbn;
        this.disponible = disponible;
    }

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


    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<LibroPrestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<LibroPrestamo> prestamos) {
        this.prestamos = prestamos;
    }
}
