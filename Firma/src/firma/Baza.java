package firma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.LinkedList;
//import java.util.List;

public class Baza {

	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String DB_URL = "jdbc:sqlite:pracownicy.db";

	private static Connection conn;
	private static Statement stat;

	public static void zainicjuj() {
		try {
			Class.forName(Baza.DRIVER);
		} catch (ClassNotFoundException e) {
			System.err.println("Brak sterownika JDBC");
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(DB_URL);
			stat = conn.createStatement();
		} catch (SQLException e) {
			System.err.println("Problem z otwarciem polaczenia");
			e.printStackTrace();
		}

		createTables();
	}

	public static boolean createTables() {
		String createPracownicy = "CREATE TABLE IF NOT EXISTS pracownicy (id_pracownika INTEGER PRIMARY KEY AUTOINCREMENT, imie varchar(255), nazwisko varchar(255), wiek varchar(255))";
		try {
			stat.execute(createPracownicy);
		} catch (SQLException e) {
			System.err.println("Blad przy tworzeniu tabeli");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void dodajPracownika(String imie, String nazwisko, String wiek) {
		try {
			PreparedStatement prepStmt = conn.prepareStatement("insert into pracownicy values (NULL, ?, ?, ?);");
			prepStmt.setString(1, imie);
			prepStmt.setString(2, nazwisko);
			prepStmt.setString(3, wiek);
			System.out.println("Dodano pracownika "+imie+" "+nazwisko+" "+wiek);
			prepStmt.execute();
		} catch (SQLException e) {
			System.err.println("Blad przy dodawaniu pracownika");
			e.printStackTrace();
		}
	}

	public static void pracownicyWczytaj(Pracownik[] pracownik) {
		try {
			int i = 0;
			ResultSet result = stat.executeQuery("SELECT * FROM pracownicy");
			while (result.next()) {
				pracownik[0].ilu = i+1;
				pracownik[i].id = result.getInt("id_pracownika");
				pracownik[i].imie = result.getString("imie");
				pracownik[i].nazwisko = result.getString("nazwisko");
				pracownik[i].wiek = result.getString("wiek");
				i++;
			}
			for (int j = i; j < pracownik.length; j++) {
				pracownik[j] = new Pracownik();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Problem z pobraniem danych pracownikow");
		}
	}

	public static void pracownikUsun(int id) {
		try {
			PreparedStatement prepStmt = conn.prepareStatement("DELETE FROM pracownicy WHERE id_pracownika = ?;");
			prepStmt.setInt(1, id);
			prepStmt.execute();
			System.out.println("Usunieto pracownika o id "+id);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Problem z usunieciem pracownika");
		}
	}

	public static void pracownikWyzerujId(Pracownik[] pracownik) {
		Pracownik[] pracownik1 = new Pracownik[pracownik.length];
		// for(int i=0; )
	}

	public static void restart() {
		try {
			PreparedStatement prepStmt = conn.prepareStatement("DROP TABLE pracownicy");
			prepStmt.execute();
			System.out.println("Zrestartowano baze");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Problem z zrestartowaniem bazy");
		}

	}

	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println("Problem z zamknieciem polaczenia");
			e.printStackTrace();
		}
	}
}