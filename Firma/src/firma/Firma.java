package firma;

import java.awt.EventQueue;

import grafika.Gui;

public class Firma {
	
	public static void main(String args[]) {

		Pracownik[] pracownik = new Pracownik[100];
		for (int i = 0; i <= 99; i++) {
			pracownik[i] = new Pracownik();
		}

		Baza.zainicjuj();
		Baza.pracownicyWczytaj(pracownik);

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Gui(pracownik);
			}
		});

	}

	public static int zamknij() {
		return 0;
	}
}
