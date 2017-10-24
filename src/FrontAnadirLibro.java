import javax.swing.JButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrontAnadirLibro extends JFrame{
	
	JPanel panel;
	JLabel id;
	JLabel titulo;
	JLabel numpag;
	JLabel stock;
	JLabel autor;
	JLabel capitulo;
	JTextField fId;
	JTextField fTitulo;
	JTextField fNumpag;
	JTextField fStock;
	JTextField fAutor;
	JTextField fCapitulo;
	JButton anadir;


	public FrontAnadirLibro() {
		this.setTitle("Libros");
		this.setSize(1000,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
			id = new JLabel("idLibro");
			fId = new JTextField(10);
			
			
			
			titulo = new JLabel("Titulo");
			fTitulo = new JTextField(10);
			
			numpag = new JLabel("Número de páginas");
			fNumpag = new JTextField(10);
			
			stock = new JLabel("Stock");
			fStock = new JTextField(10);
			
			autor = new JLabel("Autor");
			fAutor = new JTextField(10);
			
			capitulo = new JLabel("Capitulo");
			fCapitulo = new JTextField(10);
			
			anadir = new JButton("Añadir");
			
			panel = new JPanel();
			add(panel);
			panel.add(id);
			panel.add(fId);
			panel.add(titulo);
			panel.add(fTitulo);
			panel.add(numpag);
			panel.add(fNumpag);
			panel.add(stock);
			panel.add(fStock);
			panel.add(autor);
			panel.add(fAutor);
			panel.add(capitulo);
			panel.add(fCapitulo);
			panel.add(anadir);
		
		setVisible(true);
		
		
	}
		
	
	
}
