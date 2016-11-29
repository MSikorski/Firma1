package grafika;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

import firma.*;

public class PanelPracownikow extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelPracownikow(Pracownik[] pracownik) {

		Baza.pracownicyWczytaj(pracownik);

		JTextField[] field = new JTextField[pracownik.length];
		for (int i = 0; i < pracownik.length; i++) {
			field[i] = new JTextField();
		}

		if (pracownik[0].ilu() == 0) {
			add(field[0]);
			field[0].setText("Brak pracownikow w bazie.");
			field[0].setEditable(false);
			// setLayout(new GridLayout(1,1));
		} else {

			field[1].setText("Pracownicy w bazie");
			field[1].setEditable(false);
			add(field[1]);
			
			int i = 0;
			while (!(pracownik[i].imie == "")) {
				setLayout(new GridLayout(i, 1));
				field[i+2].setText((pracownik[i].id + ". " + pracownik[i].imie + " " + pracownik[i].nazwisko + " lat "
						+ pracownik[i].wiek));
				field[i + 2].setEditable(false);
				add(field[i + 2]);
				i++;
			}
		}
	}
}
