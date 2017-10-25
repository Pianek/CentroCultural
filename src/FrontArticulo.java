import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrontArticulo  extends JFrame{
	private JPanel  panelPrincipal;
	//JLabel idCD;
	//JTextField textoId;
	JLabel tituloCD;
	JTextField textoTituloCD;
	JLabel discografia;
	JTextField textoDiscografia;
	JLabel stockCD;
	JTextField textoStock;
	JLabel cantante;
	JTextField textoCantante;
	JButton anadirCD;
	JLabel lblcd ;

	public FrontArticulo(){
		this.setTitle("Selecciona tu art�culo");
		this.setSize(1000,500);
		init();
		setVisible(true);
		this.setResizable(false);  
		this.setLocationRelativeTo(null);   
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void init() {
		
		//posiciono el JPanel
		setBounds(100, 100, 419, 234);
		panelPrincipal=new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//this.setPanelPrincipal(panelPrincipal);
		panelPrincipal.setLayout(new GridLayout(2, 2, 100, 30));
		add(panelPrincipal);
		
		//aqui se crea y posiciona el panel de pesta�as
		JTabbedPane panelDePestanas = new JTabbedPane();
		panelDePestanas.setBounds(10, 11, 383, 174);
		panelPrincipal.add(panelDePestanas);
		 
		//primera pesta�a
		JPanel panelcd = new JPanel();
		panelDePestanas.addTab("CD", null, panelcd, null);
		panelcd.setLayout(null);
				  
		//Elementos de la pesta�a de cd
		JLabel lblcd = new JLabel("A�adir CD");
		panelcd.add(lblcd);
		panelcd.setBounds(50, 50, 100, 25);
		
		JLabel idCD = new JLabel("idCD");
		panelcd.add(idCD);
		panelcd.setBounds(150, 50, 100, 25);
		
		JTextField textoId = new JTextField(10);
		panelcd.add(textoId);
		panelcd.setBounds(50, 100, 200, 30);
//		
//		tituloCD = new JLabel("Titulo");
//		textoTituloCD = new JTextField(10);
//		
//		discografia = new JLabel("Discografia");
//		textoDiscografia = new JTextField(10);
//		
//		stockCD = new JLabel("Stock");
//		textoStock = new JTextField(10);
//		
//		cantante = new JLabel("Cantante");
//		textoCantante = new JTextField(10);
//		
//		anadirCD = new JButton("A�adir");
		
		//panelcd = new JPanel();
//		add(panelcd);
//		lblcd.add(idCD);
//		lblcd.add(textoId);
//		lblcd.add(tituloCD);
//		lblcd.add(textoTituloCD);
//		panelcd.add(discografia);
//		panelcd.add(textoDiscografia);
//		panelcd.add(stockCD);
//		panelcd.add(textoStock);
//		panelcd.add(cantante);
//		panelcd.add(textoCantante);
//		panelcd.add(anadirCD);
//		
		
		//segunda pesta�a
		JPanel paneldvd = new JPanel();
		panelDePestanas.addTab("DVD", null, paneldvd, null);
		paneldvd.setLayout(null);
		  
		//etiqueta para la pesta�a de dvd
		JLabel lbldvd = new JLabel("Segunda dvd");
		lbldvd.setBounds(10, 11, 348, 14);
		paneldvd.add(lbldvd);
		 
		//tercera pesta�a
		JPanel panelLibro = new JPanel();
		panelDePestanas.addTab("LIBRO", null, panelLibro, null);
		panelLibro.setLayout(null);
			  
		//etiqueta para la pesta�a de cd
		JLabel lblLibro = new JLabel("Tercera Libro");
		lblcd.setBounds(10, 11, 348, 14);
		panelLibro.add(lblLibro);
		
	
	}
}
