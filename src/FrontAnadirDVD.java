import javax.swing.JButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrontAnadirDVD extends JFrame{
	
	JPanel panel;
	JLabel id;
	JLabel titulo;
	JLabel director;
	JLabel stock;
	JLabel productora;
	JTextField fId;
	JTextField fTitulo;
	JTextField fDirector;
	JTextField fStock;
	JTextField fProductora;
	JButton anadir;


	public FrontAnadirDVD() {
		this.setTitle("DVD");
		this.setSize(1000,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
			id = new JLabel("idDVD");
			fId = new JTextField(10);
			
			
			
			titulo = new JLabel("Titulo");
			fTitulo = new JTextField(10);
			
			director = new JLabel("Director");
			fDirector = new JTextField(10);
			
			stock = new JLabel("Stock");
			fStock = new JTextField(10);
			
			productora = new JLabel("Productora");
			fProductora = new JTextField(10);
			
			anadir = new JButton("Añadir");
			
			panel = new JPanel();
			add(panel);
			panel.add(id);
			panel.add(fId);
			panel.add(titulo);
			panel.add(fTitulo);
			panel.add(director);
			panel.add(fDirector);
			panel.add(stock);
			panel.add(fStock);
			panel.add(productora);
			panel.add(fProductora);
			panel.add(anadir);
		
		setVisible(true);
		
		
	}
		
	
	
}


