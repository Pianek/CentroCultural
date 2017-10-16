
public class DVD extends Articulo{

	private String productora;
	private String director;
	
	public DVD (int id, String titulo, int stock, String prod, String dire) {
		super(id,titulo,stock);
		productora = prod;
		director = dire;
	}

	public String getProductora() {
		return productora;
	}

	public void setProductora(String productora) {
		this.productora = productora;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
	
}
