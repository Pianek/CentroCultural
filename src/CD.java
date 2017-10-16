
public class CD extends Articulo {
	
	
	private String cantante;
	private String discografia;
	
	
public CD(int id, String ti, int stock,   String cantante, String discografia) {
		super(id, ti, stock);
			
		this.cantante = cantante;
		this.discografia = discografia;
	}

public String getCantante() {
	return cantante;
}


public void setCantante(String cantante) {
	this.cantante = cantante;
}


public String getDiscografia() {
	return discografia;
}


public void setDiscografia(String discografia) {
	this.discografia = discografia;
}

public void borrar() {
	
}
public void actualizar() {
	
}
public void anadir() {
	
}
	

	
	

}
