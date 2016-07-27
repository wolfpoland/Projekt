

import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;

public class Start {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		 try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Windows".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				JFrame ramka;
				try {
					ramka = new NewJFrame();
					ramka.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//ramka.setBackground(new Color(95,89,89));
			
			}
		});
		//TestBaza.CreateTable();
	//	TestBaza.Rejestracja(new Uzytkownik(0,"Lol","lolkowski","lol@mail.com","lol"));
	/*	File plik = new File("C:/PicSwaper");
		if(!plik.exists()){
			plik.mkdir();
		}
		plik=new File("C:/PicSwaper/Users");
		if(!plik.exists()){
			plik.mkdir();
		}
		plik=new File("C:/PicSwaper/Temp");
		if(!plik.exists()){
			plik.mkdir();
			
		}*/
		
		
	}

}
