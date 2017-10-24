import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class FrontAlquilarCD extends JFrame{

	Articulo articulo;
	JPanel panelPrincipal;
	JPanel panelTabla;
	JTable tabla;
	
	JButton alquilar;
	
	public FrontAlquilarCD() {
		this.setTitle("Panel Administrador");
		this.setSize(300,300);
		init();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void init() {
		panelPrincipal = new JPanel();
		panelTabla = new JPanel();
		alquilar = new JButton();
		
		tabla = rellenarTabla();
		
		panelPrincipal.add(panelTabla);
		panelTabla.add(tabla);
		
		getContentPane().add(panelPrincipal);
	}
	
	public JTable rellenarTabla() {
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tabla = new JTable(modelo);
		
		try {
			Connection conexion = (Connection) new Conexion().establecerConexion();
			Statement s = (Statement) conexion.createStatement();
			ResultSet rs = s.executeQuery("SELECT idCD, titulo, cantante, discografia, stock FROM cd");
			// Creamos las columnas.
			modelo.addColumn("Título");
			modelo.addColumn("Cantante");
			modelo.addColumn("Discografia");
			modelo.addColumn("Stock");
			modelo.addColumn("Opciones");

			// Bucle para cada resultado en la consulta
			while (rs.next()){
				// Se crea un array que será cada una de las filas de la tabla.
			    // Hay tres columnas en la tabla
			    Object [] fila = new Object[7]; 

			    // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
			    // El primer indice en rs es el 1, no el cero, por eso se suma 1.
			    for (int i=0;i<5;i++) {
			    	fila[i] = rs.getObject(i+1);
			    }
			    fila[6] = alquilar;

			    // Se añade al modelo la fila completa.
			    modelo.addRow(fila); 
			}
		} catch (SQLException e) {
			System.out.println("Error al crear la tabla");
			e.printStackTrace();
		}
		return tabla;
	}
	
//	public String buscarArticulos() {
//		String select = "";
//		if(tipo.equalsIgnoreCase("cd")) {
//			select = "SELECT idCD, titulo, cantante, discografia, stock FROM cd";
//		}else if(tipo.equalsIgnoreCase("dvd")) {
//			select = "SELECT idDVD, titulo, director, productora, stock FROM dvd";
//		}else{
//			select = "SELECT idLibro, titulo, numPagina, capMuestra, stock FROM libro";
//		}
//		return select;
//	}
//	
//	public int numeroAriticulos() {
//		int cont = 0;
//		Conexion conexion = new Conexion();
//		Connection conn = (Connection) conexion.establecerConexion();
//		
//		try {
//			conexion.setConsulta(conn.prepareStatement(this.buscarArticulos()));
//			ResultSet rs = conexion.getConsulta().executeQuery(buscarArticulos());
//			while(rs.next()) {
//				cont++;
//			}
//		} catch (SQLException e) {
//			System.out.println("Error al calcular el número de articulos");
//			e.printStackTrace();
//		}
//		
//		return cont;
//	}
}
