import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.sun.xml.internal.ws.api.Component;

public class FrontAlquilarCD extends JFrame{

	Articulo articulo;
	JPanel panelPrincipal;
	JPanel panelTabla;
	JTable tabla;
	
	JButton alquilar;
	
	public FrontAlquilarCD() {
		this.setTitle("Panel Administrador");
		init();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//		this.setUn decorated(true);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void init() {
		panelPrincipal = new JPanel();
		panelTabla = new JPanel();
		alquilar = new JButton();
		
		tabla = rellenarTabla();
		
		panelPrincipal.add(panelTabla);
		
		panelTabla.add(new JScrollPane(tabla));
		
		BoxLayout box = new BoxLayout(panelTabla, BoxLayout.Y_AXIS);
		panelTabla.setLayout(box);
		panelTabla.setBorder(new EmptyBorder(new Insets(300, 450, 300, 450)));
		
//		panelTabla.setLocation(150, 150);
		getContentPane().add(panelPrincipal);
	}
	
	public JTable rellenarTabla() {
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tabla = new JTable(modelo);
		
		try {
			Connection conexion = (Connection) new Conexion().establecerConexion();
			Statement s = (Statement) conexion.createStatement();
			ResultSet rs = s.executeQuery("SELECT titulo, cantante, discografia, stock FROM cd");
			// Creamos las columnas.
			modelo.addColumn("Título");
			modelo.addColumn("Cantante");
			modelo.addColumn("Discografia");
			modelo.addColumn("Stock");
			modelo.addColumn("Opciones");

//			tabla.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
			tabla.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
	        final JScrollPane scrollPane = new JScrollPane( tabla );
	        getContentPane().add( scrollPane );
			
			tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
			tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
			tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
			tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
			tabla.getColumnModel().getColumn(4).setPreferredWidth(100);
			
			// Bucle para cada resultado en la consulta
			while (rs.next()){
				// Se crea un array que será cada una de las filas de la tabla.
			    // Hay tres columnas en la tabla
			    Object [] fila = new Object[5]; 

			    // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
			    // El primer indice en rs es el 1, no el cero, por eso se suma 1.
			    for (int i=0;i<4;i++) {
			    	fila[i] = rs.getObject(i+1);
			    }
			    fila[4] = "Boton_alquilar";

			    
			    
			    // Se añade al modelo la fila completa.
			    modelo.addRow(fila); 
			}
		} catch (SQLException e) {
			System.out.println("Error al crear la tabla");
			e.printStackTrace();
		}
		return tabla;
	}
	
//	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
//		Component c = (Component) tabla.prepareRenderer(renderer, row, column);
//		if (isRowSelected(row) && isColumnSelected(column)) {
//			((JComponent) c).setBorder(new LineBorder(Color.red));
//		}
//		return c;
//	}
	
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
