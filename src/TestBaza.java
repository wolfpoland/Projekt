

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestBaza {
	private static Connection c=null;
	
	public static void polaczZBaza() throws ClassNotFoundException, SQLException{
	
		Class.forName("org.postgresql.Driver");
		c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/test",
            "postgres", "haslo");
		System.out.println("Chyba sie udalo ?");
	}
	public static void CreateTable() throws SQLException, ClassNotFoundException{
		polaczZBaza();
		Statement stm=c.createStatement();
		String sql="CREATE TABLE uzytkownik ("+
		 "ID SERIAL PRIMARY KEY,"+
		 "imie 	TEXT NOT NULL,"+
		 "nazwisko TEXT NOT NULL,"+
		 "mail TEXT NOT NULL,"+
		 "haslo TEXT NOT NULL);";
		stm.executeUpdate(sql);
		stm.close();
		c.close();
		
	}
	public static Uzytkownik Logowanie(String mail, String haslo) throws ClassNotFoundException, SQLException{
		polaczZBaza();
		Statement stm=c.createStatement();
		String sql="SELECT * FROM uzytkownik WHERE mail= '"+mail+"' AND haslo= '"+haslo+"' ;";
		ResultSet rs=stm.executeQuery(sql);
		Uzytkownik uz = null;
		while(rs.next()){
		 uz=new Uzytkownik(rs.getInt("ID"), rs.getString("imie"),rs.getString("nazwisko"),rs.getString("mail"),rs.getString("haslo"));
		}
		rs.close();
		stm.close();
		c.close();
		System.out.println("Wyœwietlam dane zalogowanego uzytkownika: ");
		if(uz!=null){
		System.out.println("ID: "+uz.getID());
		System.out.println("Imie: "+uz.getImie());
		System.out.println("Nazwisko: "+uz.getNazwisko());
		System.out.println("Email: "+uz.getMail());
		System.out.println("Haslo: "+uz.getHaslo());
		}
		return uz;
				
	}
	public static void Rejestracja(Uzytkownik uz) throws ClassNotFoundException, SQLException{
		polaczZBaza();
		Statement stm=c.createStatement();
		String sql="INSERT INTO uzytkownik (imie,nazwisko,mail,haslo) VALUES ( '"+uz.getImie()+"', '"+uz.getNazwisko()+"' , '"+uz.getMail()+ "' , '"+uz.getHaslo()+"' );";
		stm.executeUpdate(sql);
		stm.close();
		
		c.close();
		
		
	}
}
