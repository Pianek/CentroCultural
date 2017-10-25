import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrontArticulo  extends JFrame{
	private JPanel  panelPrincipal;

	public FrontArticulo(){
		this.setTitle("Selecciona tu artículo");
		this.setSize(1000,500);
		init();
		setVisible(true);
		this.setLocationRelativeTo(null);   
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void init() {
		
		//posiciono el JPanel
		setBounds(1000, 500, 1000, 1000);
		panelPrincipal=new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 100, 5, 100));
		
		//this.setPanelPrincipal(panelPrincipal);
		panelPrincipal.setLayout(new GridLayout(2, 2, 100, 30));
		
		
		//aqui se crea y posiciona el panel de pestañas
		JTabbedPane panelDePestanas = new JTabbedPane();
		
		 
		//primera pestaña
		JPanel panelcd = new JPanel();	
		
		
		panelcd.setLayout(null);
		
		//Elementos de la pestaña de cd
		JLabel lblcd = new JLabel(" AÑADIR CD");
		lblcd.setBounds(10, 20, 50, 50);
		panelcd.add(lblcd);
		
//		JLabel idCD = new JLabel(" idCD");
//		idCD.setBounds(620, 18, 50, 50);
//		panelcd.add(idCD);
//	
//		
//		JTextField textoId = new JTextField(10);
//		textoId.setBounds(545,53,200,25);
//		panelcd.add(textoId);
//		
		JLabel tituloCD = new JLabel("Título");
		tituloCD.setBounds(620, 68, 100, 50);	;
		panelcd.add(tituloCD);
		
		JTextField  textoTituloCD= new JTextField(10);
		textoTituloCD.setBounds(545, 103, 200, 25);	
		panelcd.add(textoTituloCD);	

		
		JLabel discografia = new JLabel("Discografia");
		discografia.setBounds(610,118,100,50);
		panelcd.add(discografia);
		
		JTextField textoDiscografia = new JTextField(10);
		textoDiscografia.setBounds(545,153,200,25);
		panelcd.add(textoDiscografia);
		
		JLabel stockCD = new JLabel("Stock");
		stockCD.setBounds(620,168,50,50);
		panelcd.add(stockCD);
		
		JTextField textoStock = new JTextField(10);
		textoStock.setBounds(545,203,200,25);
		panelcd.add(textoStock);
		
		JLabel cantante = new JLabel("Cantante");
		cantante.setBounds(620,218,90,50);
		panelcd.add(cantante);
		
		JTextField textoCantante = new JTextField(10);
		textoCantante.setBounds(545,253,200,25);
		panelcd.add(textoCantante);
		
		JButton anadirCD = new JButton("Añadir");
		anadirCD.setBounds(600,283,100,20);
		panelcd.add(anadirCD);
		
		
		panelDePestanas.addTab("CD", panelcd);
		panelPrincipal.add(panelDePestanas);
		add(panelPrincipal);
		
		
		//segunda pestaña
		JPanel paneldvd = new JPanel();
		panelDePestanas.addTab("DVD", null, paneldvd, null);
		paneldvd.setLayout(null);
		  
		//etiqueta para la pestaña de dvd
		JLabel lbldvd = new JLabel("Añadir dvd");
		lbldvd.setBounds(10, 11, 348, 14);
		paneldvd.add(lbldvd);
		
		JLabel tituloDVD = new JLabel("Titulo Pelicula");
		tituloDVD.setBounds(600, 18, 100,50);
		paneldvd.add(tituloDVD);
		
		JTextField TextoTitulo = new JTextField(10);
		TextoTitulo.setBounds(545, 53,200,25);
		paneldvd.add(TextoTitulo);
		
		
		JLabel director = new JLabel("Director");
		tituloDVD.setBounds(600, 68, 100,50);
		paneldvd.add(tituloDVD);
		
		JTextField TextoDirector = new JTextField(10);
		TextoDirector.setBounds(545,103,200,25 );
		paneldvd.add(TextoDirector);
		
		JLabel productor = new JLabel("Productora");
		productor.setBounds(600, 118, 100,50);
		paneldvd.add(productor);
		
		JTextField TextoProductor = new JTextField(10);
		TextoProductor.setBounds(545,153,200,25 );
		paneldvd.add(TextoProductor);
		
		JLabel stockDVD = new JLabel("Stock");
		stockDVD.setBounds(600,168,100,50);
		paneldvd.add(stockDVD);
		
		JTextField TextoStock = new JTextField(10);
		TextoStock.setBounds(545,203,200,25);
		paneldvd.add(TextoStock);
			
	
		JButton anadir = new JButton("Añadir");
		anadir.setBounds(600,233,25,25);
		paneldvd.add(anadir);
		 
		//tercera pestaña
		JPanel panelLibro = new JPanel();
		panelDePestanas.addTab("LIBRO", null, panelLibro, null);
		panelLibro.setLayout(null);
			  
		//etiqueta para la pestaña de cd
		JLabel lblLibro = new JLabel("Tercera Libro");
		lblcd.setBounds(10, 11, 348, 14);
		panelLibro.add(lblLibro);
		
	
	}
}
