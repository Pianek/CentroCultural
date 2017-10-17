import java.util.ArrayList;

public class Prestamo {

	private int id_prestamo;
	private Usuario usuario;
	private ArrayList<Articulo> articulos;
	private String fecha_reserva;
	private String fecha_devolucion; 
	
	
	public Prestamo(int id, Usuario usu, String reserva, String devolucion) {
		id_prestamo = id;
		usuario = usu;
		fecha_reserva = reserva;
		fecha_devolucion = devolucion;
	}
	
	
	
	public int getIdPrestamo() {
		return id_prestamo;
	}



	public void setIdPrestamo(int id_prestamo) {
		this.id_prestamo = id_prestamo;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public String getFechaReserva() {
		return fecha_reserva;
	}



	public void setFechaReserva(String fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}



	public String getFechaDevolucion() {
		return fecha_devolucion;
	}



	public void setFechaDevolucion(String fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}

	public String actualizar() {
		return "UPDATE prestamo\r\n" + 
				"SET\r\n" + 
				"idPrestamo = ,\r\n" + 
				"fechaPrestamo = ,\r\n" + 
				"fechaDevolucion = ,\r\n" + 
				"Usuario_idUsuario = \r\n" + 
				"WHERE idPrestamo =  AND Usuario_idUsuario = ;";
	}
	
	
	public String crear() {
		return "";
	}
	
	public String buscar() {
		return "SELECT idPrestamo, fechaPrestamo,fechaDevolucion, Usuario_idUsuario FROM prestamo";
	}
	

	public void actualizarStock() {
		
	}
	
	public void anadirProducto() {
		
	}
	
	public void borrarProducto() {
		
	}
	
	public void devolverProducto() {
		
	}
	
}
