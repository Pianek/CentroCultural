package src;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Prestamo {

	private int id_prestamo;
	private Usuario usuario;
	private Articulo articulo;
	private String fecha_reserva;
	private String fecha_devolucion; 
	
	
	public Prestamo( Usuario usu, String reserva, String devolucion) {
		id_prestamo = crearId();
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
	
	public int crearId() {
		int id=0;
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
				id=rs.getInt("1");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			rs = c.getResultSet("SELECT max(idPrestamo) FROM prestamo");
			try {
				id=rs.getInt("1")+1;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	}

	public String crear() {
		this.setIdPrestamo(crearId());	
		return "INSERT INTO	prestamo (idPrestamo, fechaPrestamo, fechaDevolucion, Usuario_idUsuario)"+				  
				"VALUES (" + id_prestamo +",\""+ fecha_reserva+ ",\""+ fecha_devolucion+ ",\""+ usuario.getIdUsuario()+ ")\";";
		
	}
	
	
	public String buscar() {
		return "SELECT idPrestamo, fechaPrestamo,fechaDevolucion, Usuario_idUsuario FROM prestamo";
	}
	

	public String actualizarStock() {
		return "UPDATE " + articulo.getTipo() + "SET stock = " + articulo.getStock() + "WHERE id" + articulo.getTipo().toUpperCase() + " = " + articulo.getId_articulo();
	}
	
	public String anadirArticuloPres() {
		this.setIdPrestamo(crearId());	
		articulo.setStock(articulo.getStock()-1);
		return "INSERT INTO " + articulo.getTipo() + "_has_prestamo (" + articulo.getTipo().toUpperCase() + "_id" + articulo.getTipo().toUpperCase() + ", Prestamo_idPrestamo, Prestamo_Usuario_idUsuario) "
				+ " VALUES " + articulo.getId_articulo() + "," + this.id_prestamo + "," + this.usuario.getIdUsuario();
	}
	
	public String devolverArticuloPres() {
		this.setIdPrestamo(crearId());	
		articulo.setStock(articulo.getStock()+1);
		
		return "UPDATE " + articulo.getTipo() + "_has_prestamo "
				+ "SET fechaDevolucion = CURDATE() " + articulo.getTipo() 
				+ " WHERE "		
				+ articulo.getTipo().toUpperCase() + "_id" + articulo.getTipo().toUpperCase() + " = " + articulo.getId_articulo() 
				+ " Prestamo_idPrestamo = " + this.id_prestamo 
				+" Prestamo_Usuario_idUsuario = " + this.usuario.getIdUsuario();
	}
	
}
