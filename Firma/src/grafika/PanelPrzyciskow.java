package grafika;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelPrzyciskow extends JPanel {

	private static final long serialVersionUID = 1L;
	private DodajListener listener;
	private Gui gui;

	JButton pDodaj = new JButton("Dodaj nowego pracownika");
	JButton pUsun = new JButton("Usun pracownika");
	JButton pRestart = new JButton("Zrestartuj baze");

	public PanelPrzyciskow(DodajListener listener) {

		super();
		this.listener = listener;
		this.listener.setPanel(this);

		pDodaj.addActionListener(listener);
		pUsun.addActionListener(listener);
		pRestart.addActionListener(listener);

		setLayout(new GridLayout(3, 1));
		add(pDodaj);
		add(pUsun);
		add(pRestart);
	}

}
