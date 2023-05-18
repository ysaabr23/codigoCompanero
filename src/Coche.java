public class Coche {
	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	private int precio;
	private String extra;

	public Coche() {
		super();
	}

	public Coche(String matricula, String marca, String modelo, String color, int precio, String extra) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.precio = precio;
		this.extra = extra;
	}
	
	public Coche(String matricula, String marca, String modelo, String color, int precio) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.precio = precio;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public void mostrarDatos() {
		System.out.println("Matrícula: " + this.matricula);
		System.out.println("Marca: " + this.marca);
		System.out.println("Modelo: " + this.modelo);
		System.out.println("Color: " + this.color);
		System.out.println("Precio: " + this.precio);
		System.out.println("Extras: " + this.extra);
		System.out.println("----------------------");
	}
	
}
