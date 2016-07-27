import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class FolderWorker implements Serializable{
	private static byte[] tab;
	private Typ typ;
	private static List<String> lista;
	private static File plik;
	private static String name;
	public FolderWorker(byte[] tab, String name, Typ typ){
		this.tab=tab;
		this.typ=typ;
		this.name=name;
	}
	public FolderWorker(File plik, Typ typ){
		FolderWorker.plik=plik;
		this.typ=typ;
	}
	
	public static List<String> robTo(List<String> listaa,File plik){
	//	=new ArrayList<String>();;
	
		if(plik.list()!=null){
		for(String st : plik.list()){
			System.out.println(st);
			File f=new File(plik.getAbsolutePath()+File.separator+st);
			System.out.println("Sciezka: "+f.getAbsolutePath());
			if(f.isDirectory()){
				listaa.add(f.getAbsolutePath());
				System.out.println("Folder");
			//	return lista.addAll(listaa.add(st));
			listaa=robTo(listaa, f);
				//for(String so : lista2){
				//	lista.add(so);
			//	}
			
				
			//lista.addAll(lista2);
			}else{
				System.out.println("Nie folder");
				listaa.add(f.getAbsolutePath());
			}
			
			
		}
		}
	
		return listaa;
		//return listaa;
	}
	/*byte[] tablica=new byte[(int)f.length()];
	FileInputStream fis=new FileInputStream(f);
	BufferedInputStream bis=new BufferedInputStream(fis);
	bis.read(tablica,0,tablica.length);*/
	public static List<TypyFile> tworer(List<String> lista) throws IOException{
		List<TypyFile> listaG=new ArrayList<TypyFile>();
		for(String s: lista){
			File f=new File(s);
			if(f.isFile()){
			byte[] tablica=new byte[(int)f.length()];
			FileInputStream fis=new FileInputStream(f);
			BufferedInputStream bis=new BufferedInputStream(fis);
			bis.read(tablica,0,tablica.length);
			listaG.add(new TypyFile(tablica, f.getName(),f, FolderWorker.Typ.Plik));
			}else{
				listaG.add(new TypyFile(f,Typ.Folder));
			}
		}
		return listaG;
	}
	
	public Typ getTyp() {
		return typ;
	}

	public void setTyp(Typ typ) {
		this.typ = typ;
	}
	
	
	public static List<String> getLista() {
		return lista;
	}

	public static void setLista(List<String> lista) {
		FolderWorker.lista = lista;
	}


	public static byte[] getTab() {
		return tab;
	}
	public static void setTab(byte[] tab) {
		FolderWorker.tab = tab;
	}
	public static File getPlik() {
		return plik;
	}
	public static void setPlik(File plik) {
		FolderWorker.plik = plik;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		FolderWorker.name = name;
	}


	public enum Typ{
		Plik,
		Folder
	}
}

