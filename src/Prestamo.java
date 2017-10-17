import java.sql.ResultSet;
import java.sql.SQLException;
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

	public String crear() {
		Conexion c = new Conexion();
		c.establecerConexion();
		ResultSet rs = c.getResultSet("SELECT idPrestamo" + 
								 	  "FROM prestamo" + 
								 	  "WHERE fechaPrestamo = \"" + fecha_reserva + "\"" +
								 	  "AND Usuario_idUsuario = " + usuario.getIdUsuario());
		if(rs != null) {
			try {
				/*res.next() coge los valores de la primera fila
				 *this.setIdPrestamo(rs.getInt("1")); nos coge el primer valor de la primera fila*/
				rs.next();
				this.setIdPrestamo(rs.getInt("1"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			rs = c.getResultSet("SELECT max(idPrestamo) FROM prestamo");
			try {
				this.setIdPrestamo(rs.getInt("1")+1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return "INSERT INTO	prestamo (idPrestamo, fechaPrestamo, fechaDevolucion, Usuario_idUsuario)"+				  
				"VALUES (" + id_prestamo +",\""+ fecha_reserva+ ",\""+ fecha_devolucion+ ",\""+ usuario.getIdUsuario()+ ")\";";
		
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
