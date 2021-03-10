
package pojo;

public class Cliente {

    private int codigo;
    private String nombre;
    private String password;
    private String apellido;
    private String email;
    private String telefono;
    private String provincia;
    private String localidad;
    private String direccion;
    
    public Cliente(int codigo,String nombre,String password,String apellido,String email, String telefono, String provincia, String localidad, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.password = password;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.provincia = provincia;
        this.localidad = localidad;
        this.direccion = direccion;
    }
    
    public Cliente(int codigo){
       this.codigo = codigo;
    }
	
    public Cliente(){}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
