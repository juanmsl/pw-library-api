package pwlibraryapi.JaveLibrary.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String usuario;

    @NotNull
    private String nombres;

    @NotNull
    private String apellidos;

    @NotNull
    private String tipo;

    @NotNull
    private String documento;

    @Transient
    private String message;

    public Usuario(int id){
        this.id = id;
    }

    public Usuario() {}

    public Usuario(@NotNull String usuario, @NotNull String nombres, @NotNull String apellidos, @NotNull String tipo, @NotNull String documento) {
        this.usuario = usuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipo = tipo;
        this.documento = documento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
