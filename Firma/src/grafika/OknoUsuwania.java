package grafika;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OknoUsuwania extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton Usun = new JButton("Usun");
	JLabel label = new JLabel("ID");
	JTextField Id = new JTextField(""); 
	
	private DodajListener listener; 
	private Gui gui;
	
	public OknoUsuwania(Gui gui) {
		super( "Usuwanie pracownika" );
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(100, 100);
		setLocation(50,50);	
		setLayout(new GridLayout(2,1));// set LayoutManager
		setVisible(true);
		
		this.gui=gui;
		DodajListener listener = new DodajListener(this, gui);
		Usun.addActionListener(listener);
		
		JPanel pomocny = new JPanel();
		pomocny.add(label);
		pomocny.add(Id);
		pomocny.setLayout(new GridLayout(1,2));
		add(pomocny);
		add(Usun);
		
		pack();
	}
}
