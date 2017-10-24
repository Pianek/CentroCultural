import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class FrontArticulo  extends JFrame{
	private JPanel  panelPrincipal;

	public FrontArticulo(){
		this.setTitle("Selecciona tu artículo");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//posiciono el JPanel
		setBounds(100, 100, 419, 234);
		panelPrincipal=new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		//this.setPanelPrincipal(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		//aqui se crea y posiciona el panel de pestañas
		JTabbedPane panelDePestanas = new JTabbedPane(JTabbedPane.TOP);
		panelDePestanas.setBounds(10, 11, 383, 174);
		panelPrincipal.add(panelDePestanas);
		 
		//segunda pestaña
		JPanel paneldvd = new JPanel();
		panelDePestanas.addTab("CD", null, paneldvd, null);
		paneldvd.setLayout(null);
		  
		//etiqueta para la pestaña de dvd
		JLabel lbldvd = new JLabel("Segunda dvd");
		lbldvd.setBounds(10, 11, 348, 14);
		paneldvd.add(lbldvd);
		 
		//tercera pestaña
		JPanel panelLibro = new JPanel();
		panelDePestanas.addTab("CD", null, panelLibro, null);
		panelLibro.setLayout(null);
			  
		//etiqueta para la pestaña de cd
		JLabel lblcd = new JLabel("Tercera Libro");
		lblcd.setBounds(10, 11, 348, 14);
		panelLibro.add(lblcd);
				
	}
}
