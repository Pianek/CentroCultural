package src;

import java.awt.Component;
import java.awt.GridLayout;
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

public class FrontAlquilarDVD  extends JFrame{

	Articulo articulo;
	JPanel panelPrincipal;
	JTable tabla;
	JButton alquilar; 
	
	public FrontAlquilarDVD() {
		this.setTitle("Panel Administrador");
		init();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void init() {
		panelPrincipal = new JPanel();
		/*AQUI LAS COORDENADAS PARA SITUARLO EN LAS PESTA�AS*/
		panelPrincipal.setBorder(new EmptyBorder(100,100,50,100));
		panelPrincipal.setLayout(new GridLayout(2,2,10,30));
		
		alquilar = new JButton();
		
		tabla = rellenarTabla();
		
		panelPrincipal.add(new JScrollPane(tabla));

		getContentPane().add(panelPrincipal);
	}
	
	public JTable rellenarTabla() {
		DefaultTableModel modelo = new DefaultTableModel() {
			//setting the jtable read only
			public boolean isCellEditable(int row, int column) {
				boolean editable = false;
				if(column == 4) {
					editable = true;
				}
				return editable;
			}
        };
		
		
		try {
			Connection conexion = (Connection) new Conexion().establecerConexion();
			Statement s = (Statement) conexion.createStatement();
			ResultSet rs = s.executeQuery("SELECT titulo, director, productora, stock FROM dvd");
			// Creamos las columnas.
			modelo.addColumn("T�tulo");
			modelo.addColumn("Director");
			modelo.addColumn("Productora");
			modelo.addColumn("Stock");
			modelo.addColumn("Opciones");
			
			// Bucle para cada resultado en la consulta
			while (rs.next()){
				
				String titulo = rs.getString(1);
				String director = rs.getString(2);
				String productora = rs.getString(3);
				String stock = String.valueOf(rs.getInt(4));
				
				modelo.addRow(new Object[] {titulo,director,productora,stock});
			}
		} catch (SQLException e) {
			System.out.println("Error al crear la tabla");
			e.printStackTrace();
		}
		
		tabla = new JTable(modelo);
		
		tabla.getColumnModel().getColumn(4).setCellRenderer(new ClientsTableButtonRenderer());
		tabla.getColumnModel().getColumn(4).setCellEditor(new ClientsTableRenderer(new JCheckBox(), articulo));
		
		return tabla;
	}
}

