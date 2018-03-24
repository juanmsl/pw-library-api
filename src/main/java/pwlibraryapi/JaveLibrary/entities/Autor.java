package pwlibraryapi.JaveLibrary.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String nombre;

    public Autor(){}

    public Autor(int id){
        this.id = id;
    }

    public Autor(@NotNull String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

