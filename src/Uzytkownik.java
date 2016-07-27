

import java.io.Serializable;

public class Uzytkownik implements Serializable{

	private int ID;
	private String imie;
	private String nazwisko;
	private String mail;
	private String haslo;
	
	public Uzytkownik(){
		
	}
	public Uzytkownik(String imie, String nazwisko, String mail,String haslo){
		
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.mail=mail;
		this.haslo=haslo;
	}
public Uzytkownik(int ID,String imie, String nazwisko, String mail,String haslo){
		this.ID=ID;
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.mail=mail;
		this.haslo=haslo;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getHaslo() {
		return haslo;
	}
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}
	
}
