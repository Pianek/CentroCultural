public class Libro extends Articulo {
	
	private String autor;
	private int numPagina;
	private String capMuestra;
	
	public Libro(int id, String ti, int stock, String aut, int nump, String cap) {
		super(id, ti, stock);
		this.autor=aut;
		this.numPagina=nump;
		this.capMuestra=cap;
	}
	
	public void actualizar() {
		
	}
	
	public void borrar() {
		
	}
	
	public void crear() {
		
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNumPagina() {
		return numPagina;
	}

	public void setNumPagina(int numPagina) {
		this.numPagina = numPagina;
	}

	public String getCapMuestra() {
		return capMuestra;
	}

	public void setCapMuestra(String capMuestra) {
		this.capMuestra = capMuestra;
	}
	
	
}
