package dominio;

public class Cliente {

	private int id_cliente;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private double saldo;
	
	public Cliente(int id_cliente, String nombre, String apellido, String email, String telefono, double saldo) {
		super();
		this.id_cliente = id_cliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.saldo = saldo;
	}
	
	public Cliente(String nombre, String apellido, String email, String telefono, double saldo) {
		super();
	        this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.saldo = saldo;
	}
	
	public Cliente(int id_cliente){
	   this.id_cliente = id_cliente;
	}
	
	public Cliente(){}

	public int getId_cliente() {
		return id_cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefono() {
		return telefono;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
 
 }
