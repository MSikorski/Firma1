package grafika;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import firma.Baza;

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
		if (przycisk == 1) {
			if (e.getSource() == panelPrzyciskow.pDodaj) {
				System.out.println("Kliknieto przycisk dodania pracownika");
				SwingUtilities.invokeLater(new Runnable() {
					@Override

					public void run() {
						new OknoDodawania(gui);
					}
				});
			} else if (e.getSource() == panelPrzyciskow.pUsun) {
				System.out.println("Kliknieto przycisk usuwania pracownika");

				SwingUtilities.invokeLater(new Runnable() {
					@Override

					public void run() {
						new OknoUsuwania(gui);
					}
				});
			} else if (e.getSource() == panelPrzyciskow.pRestart) {
				System.out.println("Kliknieto przycisk restartowania bazy");
				Baza.restart();
				Baza.zainicjuj();
				gui.Restart();
			}
		}
		if (przycisk == 2) {
			if (e.getSource() == oknoDodawania.Dodaj) {
				System.out.println("Kliknieto przycisk dodaj");
				
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
				System.out.println("Kliknieto przycisk usun");
				
				if (Integer.parseInt(oknoUsuwania.Id.getText()) > 0) {
					oknoUsuwania.dispose();
					Baza.pracownikUsun(Integer.parseInt(oknoUsuwania.Id.getText()));
					gui.Restart();
				}
			}

		}
	}

}
