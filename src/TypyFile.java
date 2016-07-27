import java.io.File;
import java.io.Serializable;


public class TypyFile implements Serializable{
	private byte[] tab;
	private File file;
	private FolderWorker.Typ typ;
	private String nazwa;
	public TypyFile(byte[] tab, String nazwa,File file, FolderWorker.Typ typ){
		this.tab=tab;
		this.typ=typ;
		this.nazwa=nazwa;
		this.file=file;
	}
	public TypyFile(File file, FolderWorker.Typ typ){
		this.file=file;
		this.typ=typ;
	}
	public byte[] getTab() {
		return tab;
	}
	public void setTab(byte[] tab) {
		this.tab = tab;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public FolderWorker.Typ getTyp() {
		return typ;
	}
	public void setTyp(FolderWorker.Typ typ) {
		this.typ = typ;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	
	
}
