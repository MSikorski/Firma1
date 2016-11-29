package grafika;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OknoDodawania extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Gui gui;
	
	JButton Dodaj = new JButton("Dodaj pracownika");
	JTextField Imie = new JTextField(); 
	JTextField Nazwisko = new JTextField(); 
	JTextField Wiek = new JTextField();

	private DodajListener listener; 
	
	public OknoDodawania(Gui gui) {
		super( "Dodawanie pracownika" );
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(100, 150);
		setLocation(50,50);	
		setLayout(new GridLayout(2,1));// set LayoutManager
		setVisible(true);
		
		this.gui=gui;
		
		DodajListener listener = new DodajListener(this, gui);
		Dodaj.addActionListener(listener);
	
		JPanel panelPrzyciskow = new PanelPrzyciskow(listener);
		
		Imie.setText("");
		Nazwisko.setText("");
		Wiek.setText("");
		
		JPanel pomocniczy = new JPanel();
		pomocniczy.setLayout(new GridLayout(3,2));
		pomocniczy.add(new JLabel("Imie:"));
		pomocniczy.add(Imie);
		pomocniczy.add(new JLabel("Nazwisko:"));
		pomocniczy.add(Nazwisko);
		pomocniczy.add(new JLabel("Wiek:"));
		pomocniczy.add(Wiek);
		add(pomocniczy);
		add(Dodaj);
		

		
		pack();
	}

}
