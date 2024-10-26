package modelo;

/**
 *
 * @author ediso
 */
public class Mozo {

    //Atributos
    private int idMozo;
    private String nombre;
    private String direccion;
    private String correo;
    private String password;
    private String telefono;
    private int dni;

    //Contructor vacío
    public Mozo() {
        this.idMozo = 0;
        this.nombre = "";
        this.correo = "";
        this.correo = "";
        this.password = "";
        this.telefono = "";
        this.dni=0;
    }

    //set and get
    public int getIdMozo() {
        return idMozo;
    }

    public void setIdUsuario(int idMozo) {
        this.idMozo = idMozo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
     public int getDNI() {
        return dni;
    }

    public void setDNI(int dni) {
        this.dni = dni;
    }
    
    

    
}
