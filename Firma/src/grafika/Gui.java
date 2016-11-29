package grafika;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;

import firma.*;

public class Gui extends JFrame {
	public Pracownik[] pracownik;
	DodajListener listener = new DodajListener(this);
	PanelPrzyciskow panelPrzyciskow = new PanelPrzyciskow(listener);
	public PanelPracownikow panelPracownikow;
	
	
	
	public Gui(Pracownik[] pracownik) {
		
		super("Firma");
		this.pracownik=pracownik;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setSize(700, 400);
		setLocation(50, 50);
		
		setVisible(true);
		
		Ustaw(pracownik);

	}

	public void Ustaw(Pracownik[] pracownik) {
		
		setLayout(new GridBagLayout());// set LayoutManager
		GridBagConstraints gbc = new GridBagConstraints();
		Border eBorder = BorderFactory.createEtchedBorder();
		
		panelPracownikow = new PanelPracownikow(pracownik);
		panelPracownikow.setBorder(BorderFactory.createTitledBorder(eBorder, ""));
		
		gbc.gridx = gbc.gridy = 0;
		gbc.gridwidth = gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.weightx = gbc.weighty = 300;
		add(panelPracownikow, gbc);

		
		panelPrzyciskow.setBorder(BorderFactory.createTitledBorder(eBorder, ""));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 0;
		gbc.gridheight = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		gbc.weightx = 150;
		gbc.weighty = 100;
		add(panelPrzyciskow, gbc);

		pack();
	}
	
	public void Restart(){
		remove(panelPracownikow);
		remove(panelPrzyciskow);
		Baza.pracownicyWczytaj(pracownik);
		Ustaw(pracownik);
	}
}