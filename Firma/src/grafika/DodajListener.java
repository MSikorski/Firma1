package grafika;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import firma.Baza;
import firma.Pracownik;

public class DodajListener implements ActionListener {
	private Gui gui;
	private OknoDodawania oknoDodawania;
	private OknoUsuwania oknoUsuwania;

	int przycisk = 0;

	private PanelPrzyciskow panelPrzyciskow;

	private DodajListener listener;

	public void setPanel(PanelPrzyciskow panelPrzyciskow) {
		this.panelPrzyciskow = panelPrzyciskow;

	}

	public DodajListener(Gui gui) {
		this.gui = gui;
		przycisk = 1;
	}

	public DodajListener(OknoDodawania oknoDodawania, Gui gui) {
		this.oknoDodawania = oknoDodawania;
		this.gui=gui;
		przycisk = 2;
	}

	public DodajListener(OknoUsuwania oknoUsuwania, Gui gui) {
		this.oknoUsuwania = oknoUsuwania;
		this.gui=gui;
		przycisk = 3;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(1);

		if (przycisk == 1) {
			if (e.getSource() == panelPrzyciskow.pDodaj) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override

					public void run() {
						new OknoDodawania(gui);
					}
				});
			} else if (e.getSource() == panelPrzyciskow.pUsun) {

				SwingUtilities.invokeLater(new Runnable() {
					@Override

					public void run() {
						new OknoUsuwania(gui);
					}
				});
			} else if (e.getSource() == panelPrzyciskow.pRestart) {
				Baza.restart();
				Baza.zainicjuj();
				gui.Restart();
			}
		}
		if (przycisk == 2) {
			if (e.getSource() == oknoDodawania.Dodaj) {

				System.out.println(2);
				if (!((oknoDodawania.Imie.getText() == "") && (oknoDodawania.Nazwisko.getText() == "")
						&& (oknoDodawania.Wiek.getText() == ""))) {
					Baza.dodajPracownika(oknoDodawania.Imie.getText(), oknoDodawania.Nazwisko.getText(),
							oknoDodawania.Wiek.getText());
					oknoDodawania.dispose();
					gui.Restart();
				}
			}
		}
		if (przycisk == 3) {
			if (e.getSource() == oknoUsuwania.Usun) {
				if (Integer.parseInt(oknoUsuwania.Id.getText()) > 0) {
					oknoUsuwania.dispose();
					Baza.pracownikUsun(Integer.parseInt(oknoUsuwania.Id.getText()));
					gui.Restart();
				}
			}

		}
	}

}
