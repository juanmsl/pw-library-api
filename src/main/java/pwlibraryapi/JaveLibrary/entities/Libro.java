package pwlibraryapi.JaveLibrary.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

@Entity
@Table(name = "libro")
public class Libro implements  Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String nombre;

    @NotNull
    private String isbn;

    @NotNull
    private Boolean disponible;

    ArrayList<Autor> autores = new ArrayList<>();


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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "libroautor", joinColumns = @JoinColumn(name = "libro_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "autor_id", referencedColumnName = "id"))
    public ArrayList<Autor> getAutores() {
        return autores;
    }


    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
}
