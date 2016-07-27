import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

//import FolderWorker.Typ;


public class Komunikacja {
	private static String ip="localhost";
	private static int port=55;
	public Komunikacja(String ip,int port){
		this.ip=ip;
		this.port=port;
	}
	public void polacz() throws UnknownHostException, IOException, ClassNotFoundException{
		System.out.println("IP: "+ip+"\n Port:"+port);
		Socket socket=new Socket(ip,port);
		System.out.println("Polaczono z Serwerem");
		InputStream in=socket.getInputStream();
		OutputStream out=socket.getOutputStream();

		ObjectOutputStream outer=new ObjectOutputStream(out);
		ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
		//ObjectOutputStream outer=new ObjectOutputStream(out);
	//	DataOutputStream outD=new DataOutputStream(out);
//		DataInputStream inD=new DataInputStream(in);
		System.out.println("Wysylam wiadomosc powitalna");
		out.write(1);
		out.flush();
		System.out.println("Czekam na pytanie o id");
		
		int id=in.read();
		System.out.println("Otrzymane pytanie: "+id);
		System.out.println("Wysylam id:");
		out=socket.getOutputStream();
		out.write(1);
		out.flush();
		
		System.out.println("Czekanie na liste");
		List<String> lista=(List<String>) ois.readObject();
		ois.close();
		System.out.println("Wypisuje liste: ");
		for(String s: lista){
			System.out.println(s);
		}
		PanelGlowny.robie(lista, PanelGlowny.getjComboBox1());
		/*
		if(id==1){
			out.write(1);
			out.flush();
		//	ObjectOutputStream outer=new ObjectOutputStream(out);
			File plik=new File("C:/Users/pacio_000/Desktop/pobrane.png");
			BufferedImage img;
			img=ImageIO.read(plik);
			PlikInfo pliko=new PlikInfo("nowy",1,1,"wielblady.wielkie.duze.",1,plik);
			outer.writeObject(pliko);
			outer.flush();
		
		}*/
		
		
		//inD.close();
		//outD.close();
		//outer.close();
		outer.close();
		out.close();
		in.close();
		socket.close();
		System.out.println("Polaczenie zamkniete");
	}
	public static void odbierzPlik(File f) throws UnknownHostException, IOException, ClassNotFoundException{
		System.out.println("IP: "+ip+"\n Port:"+port);
		Socket socket=new Socket(ip,port);
		System.out.println("Polaczono z Serwerem");
		InputStream in=socket.getInputStream();
		OutputStream out=socket.getOutputStream();

		ObjectOutputStream outer=new ObjectOutputStream(out);
		ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
		//ObjectOutputStream outer=new ObjectOutputStream(out);
	//	DataOutputStream outD=new DataOutputStream(out);
//		DataInputStream inD=new DataInputStream(in);
		System.out.println("Wysylam wiadomosc powitalna");
		out.write(3);
		out.flush();
		System.out.println("Czekam na pytanie o id");
		
		int id=in.read();
		System.out.println("Otrzymane pytanie: "+id);
		System.out.println("Wysylam id:");
		out=socket.getOutputStream();
		out.write(1);
		out.flush();
		
		System.out.println("Wysylam plik do klienta");
		outer.writeObject(f);
		//List<String> lista=(List<String>) ois.readObject();
		//ois.close();
		//System.out.println("Wypisuje liste: ");
		//for(String s: lista){
	//		System.out.println(s);
	//	}
		System.out.println("Przed odbieraniem pliku od serwera");
		PlikInfo plik=(PlikInfo) ois.readObject();
		System.out.println("Plik odebrano ");
		if(plik.isPlikor()){
			String combo=PanelGlowny.getjComboBox1().getSelectedItem().toString();
			File plik2=new File(combo+File.separator+plik.getNazwa());
			System.out.println("Sciezka: "+plik2.getAbsolutePath());
			if(!plik2.exists()){
				plik2.createNewFile();
			}
			FileOutputStream fos=new FileOutputStream(plik2);
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			bos.write(plik.getTablica());
			bos.close();
			fos.close();
			
		}else{
		String combo=PanelGlowny.getjComboBox1().getSelectedItem().toString();
		List<TypyFile> ls=plik.getLista();
		String dodatek="";
		String sciezka=combo;
		String sciezka2=combo;
		List<String> lista=new ArrayList<String>();
		List<String> lista2=new ArrayList<String>();
		//System.out.println("TMPO: "+tmp);
		int m=0;
		for(TypyFile fw : ls){
			System.out.println("Pierwszy typ: "+fw.getTyp());
			if(fw.getTyp()==FolderWorker.Typ.Plik){
				System.out.println("Imiona: "+fw.getNazwa());
				System.out.println("Pierwotna sciezka: "+fw.getFile().getAbsolutePath());
				sciezka2=combo;
				
				if(dodatek.equals("")){
				System.out.println("Zachodzi null");
				 //sciezka=combo;
				 System.out.println("Wstêpna œcie¿ka: "+sciezka);
				 lista2.add(fw.getFile().getName());
				 dodatek=fw.getFile().getName();
				 System.out.println("Dodatek: "+dodatek);
				 sciezka+=File.separator+dodatek;
						 
				}else{
					System.out.println("Zachodzi elese");
					//sciezka=combo+File.separator+dodatek;
					System.out.println("Sciezka w else: "+sciezka);
					//int n=0;
					
					for(int n=0;n<lista2.size();n++){
						System.out.println("Dodaje do sciezki: "+lista2.get(n));
						sciezka+=File.separator+lista2.get(n);
					}
					sciezka+=File.separator+fw.getFile().getName();
					
					
						System.out.println("\t Zaszlo");
						System.out.println("Dodaje do lsity: "+fw.getFile().getName());
						File test=new File(sciezka+File.separator+fw.getFile().getName());
						System.out.println("Sciezka przed dodaniem do listy: "+test.getAbsolutePath());
						if(test.isDirectory()){
						lista2.add(fw.getFile().getName());
						}
					
				}
				System.out.println("Koncowy efekt sciezka: "+sciezka);
				System.out.println("Sprawdzenie sciezki folder: "+fw.getFile().getAbsolutePath() );
				File pliko=new File(sciezka);
				if(!pliko.exists()){
					System.out.println("Tworze plik");
					pliko.createNewFile();
				}
				//File pliko=new File(combo+File.separator+fw.getNazwa());
				System.out.println("Pelna sciezka pliku: "+pliko.getAbsolutePath());
				if(!pliko.exists()){
					pliko.createNewFile();
				}
				FileOutputStream fos=new FileOutputStream(pliko);
				BufferedOutputStream bos=new BufferedOutputStream(fos);
				bos.write(fw.getTab());
				bos.close();
				fos.close();
			}else{
				sciezka=combo;
				
				if(dodatek.equals("")){
				System.out.println("Zachodzi null");
				 //sciezka=combo;
				 System.out.println("Wstêpna œcie¿ka: "+sciezka);
				 lista.add(fw.getFile().getName());
				 dodatek=fw.getFile().getName();
				 System.out.println("Dodatek: "+dodatek);
				 sciezka+=File.separator+dodatek;
						 
				}else{
					System.out.println("Zachodzi elese");
					//sciezka=combo+File.separator+dodatek;
					System.out.println("Sciezka w else: "+sciezka);
					//int n=0;
					
					for(int n=0;n<lista.size();n++){
						System.out.println("Dodaje do sciezki: "+lista.get(n));
						sciezka+=File.separator+lista.get(n);
					}
					sciezka+=File.separator+fw.getFile().getName();
					
					
						System.out.println("\t Zaszlo");
						System.out.println("Dodaje do lsity: "+fw.getFile().getName());
					lista.add(fw.getFile().getName());
					
					
				}
				System.out.println("Koncowy efekt sciezka: "+sciezka);
				System.out.println("Sprawdzenie sciezki folder: "+fw.getFile().getAbsolutePath() );
				File pliko=new File(sciezka);
				if(!pliko.exists()){
					System.out.println("Tworze folder");
					pliko.mkdir();
				}
			}
		}
		}
		PanelGlowny.robiePanle(PanelGlowny.getjComboBox1());
		
		
	//	PanelGlowny.robie(lista, PanelGlowny.getjComboBox1());
		/*
		if(id==1){
			out.write(1);
			out.flush();
		//	ObjectOutputStream outer=new ObjectOutputStream(out);
			File plik=new File("C:/Users/pacio_000/Desktop/pobrane.png");
			BufferedImage img;
			img=ImageIO.read(plik);
			PlikInfo pliko=new PlikInfo("nowy",1,1,"wielblady.wielkie.duze.",1,plik);
			outer.writeObject(pliko);
			outer.flush();
		
		}*/
		
		
		//inD.close();
		//outD.close();
		//outer.close();
		ois.close();
		outer.close();
		out.close();
		in.close();
		socket.close();
		System.out.println("Polaczenie zamkniete");
	}

}
