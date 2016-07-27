import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.TransferHandler;


public class Transfer extends TransferHandler{
	String sciezka;
	String s2;
	
	public Transfer(String sciezka,String s2 ){
		this.sciezka=sciezka;
		this.s2=s2;
	}
	public int getSourceActions(JComponent source){
		return COPY_OR_MOVE;
	}
	protected Transferable createTransferable(JComponent source){
		List<File> lista=new ArrayList<File>();
		JLabel label=(JLabel) source;
		String tekst=label.getText();
		File plik=new File(s2+"/"+sciezka);
		lista.add(plik);
		FileTransferable tars=new FileTransferable(lista);
		return tars;
		
	}
}
