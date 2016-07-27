

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import java.util.List;

public class PlikInfo implements Serializable{
	private String nazwa;
	private int id;
	private int idSerwera;
	private int idOwnera;
	private String tres;
	//private BufferedImage img;
	private byte[] tablica;
	private File plik;
	private List<TypyFile> lista;
	private boolean plikor;
	public PlikInfo(String nazwa,int id, int idSerwera, String tres,int idOwnera, byte[] tablica) {
		this.tablica=tablica;
		this.idOwnera=idOwnera;
		this.nazwa=nazwa;
		this.id = id;
		this.idSerwera = idSerwera;
		this.tres = tres;
		plikor=true;
	}
	public PlikInfo(String nazwa,int id, int idSerwera, String tres,int idOwnera, List<TypyFile> lista) {
		this.lista=lista;
		this.idOwnera=idOwnera;
		this.nazwa=nazwa;
		this.id = id;
		this.idSerwera = idSerwera;
		this.tres = tres;
		plikor=false;
	}
	public int getId() {
		return id;
	}
	public int getIdOwnera() {
		return idOwnera;
	}
	public void setIdOwnera(int idOwnera) {
		this.idOwnera = idOwnera;
	}
	public File getPlik() {
		return plik;
	}
	public void setPlik(File plik) {
		this.plik = plik;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdSerwera() {
		return idSerwera;
	}
	public void setIdSerwera(int idSerwera) {
		this.idSerwera = idSerwera;
	}
	public String getTres() {
		return tres;
	}
	public void setTres(String tres) {
		this.tres = tres;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	
	
	public byte[] getTablica() {
		return tablica;
	}
	public void setTablica(byte[] tablica) {
		this.tablica = tablica;
	}
	public boolean isPlikor() {
		return plikor;
	}
	public void setPlikor(boolean plikor) {
		this.plikor = plikor;
	}
	public List<TypyFile> getLista() {
		return lista;
	}
	public void setLista(List<TypyFile> lista) {
		this.lista = lista;
	}
	
}
