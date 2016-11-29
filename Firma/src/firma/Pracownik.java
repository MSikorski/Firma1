package firma;

public class Pracownik{
	public String imie,nazwisko,wiek;
	public int id,ilu;

	public Pracownik(){
		id=0;
		imie="";
		nazwisko="";
		wiek="";
	}
	public Pracownik(int id, String imie, String nazwisko, String wiek){
		this.id=id;
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.wiek=wiek;
	}
	public String dajImie(){
		return this.imie;
	}
	public String dajNazwisko(){
		return this.nazwisko;
	}
	public String dajWiek(){
		return this.wiek;
	}
	public int dajId(){
		return this.id;
	}
	public void ustawId(int id){
		this.id=id;
	}
	public void ustawImie(String imie){
		this.imie=imie;
	}
	public void ustawNazwisko(String nazwisko){
		this.nazwisko=nazwisko;
	}
	public void ustawWiek(String wiek){
		this.wiek=wiek;
	}
	public int ilu(){
		return ilu;
	}
}

