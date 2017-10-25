import java.awt.Component;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

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
			
			// Bucle para cada resultado en la consulta
			while (rs.next()){
				
				String titulo = rs.getString(1);
				String cantante = rs.getString(2);
				String discogradia = rs.getString(3);
				String stock = String.valueOf(rs.getInt(4));
				
				modelo.addRow(new Object[] {titulo,cantante,discogradia,stock});
			}
		} catch (SQLException e) {
			System.out.println("Error al crear la tabla");
			e.printStackTrace();
		}
		
		tabla = new JTable(modelo);
		
		tabla.getColumnModel().getColumn(4).setCellRenderer(new ClientsTableButtonRenderer());
		tabla.getColumnModel().getColumn(4).setCellEditor(new ClientsTableRenderer(new JCheckBox()));
		

		tabla.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        final JScrollPane scrollPane = new JScrollPane( tabla );
        getContentPane().add( scrollPane );
		
		tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(3).setPreferredWidth(50);
		tabla.getColumnModel().getColumn(4).setPreferredWidth(100);
		
		return tabla;
	}
}

class ClientsTableButtonRenderer extends JButton implements TableCellRenderer {
	public ClientsTableButtonRenderer() {
		setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		setBackground(UIManager.getColor("Button.background"));
		setText((value == null) ? "Alquilar" : value.toString());
		return this;
	}
}


//public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
//Component c = (Component) tabla.prepareRenderer(renderer, row, column);
//if (isRowSelected(row) && isColumnSelected(column)) {
//	((JComponent) c).setBorder(new LineBorder(Color.red));
//}
//return c;
//}

//public String buscarArticulos() {
//String select = "";
//if(tipo.equalsIgnoreCase("cd")) {
//	select = "SELECT idCD, titulo, cantante, discografia, stock FROM cd";
//}else if(tipo.equalsIgnoreCase("dvd")) {
//	select = "SELECT idDVD, titulo, director, productora, stock FROM dvd";
//}else{
//	select = "SELECT idLibro, titulo, numPagina, capMuestra, stock FROM libro";
//}
//return select;
//}
//
//public int numeroAriticulos() {
//int cont = 0;
//Conexion conexion = new Conexion();
//Connection conn = (Connection) conexion.establecerConexion();
//
//try {
//	conexion.setConsulta(conn.prepareStatement(this.buscarArticulos()));
//	ResultSet rs = conexion.getConsulta().executeQuery(buscarArticulos());
//	while(rs.next()) {
//		cont++;
//	}
//} catch (SQLException e) {
//	System.out.println("Error al calcular el número de articulos");
//	e.printStackTrace();
//}
//
//return cont;
//}