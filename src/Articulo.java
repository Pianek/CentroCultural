public class Articulo {
	
	private int id_articulo;
	private String titulo;
	private int stock;
	
	
	public Articulo(int id, String ti, int stock) {
		this.id_articulo=id;
		this.titulo=ti;
		this.stock=stock;
	}
	
	public int getId_articulo() {
		return id_articulo;
	}
	public void setId_articulo(int id_articulo) {
		this.id_articulo = id_articulo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
