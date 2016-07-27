import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;


public class FileTransferable implements Transferable {
	
	private List lista;
	
	public  FileTransferable(List lista) {
		this.lista=lista;
	}

	@Override
	public Object getTransferData(DataFlavor arg0)
			throws UnsupportedFlavorException, IOException {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		// TODO Auto-generated method stub
		return new DataFlavor[]{DataFlavor.javaFileListFlavor};
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		// TODO Auto-generated method stub
		return DataFlavor.javaFileListFlavor.equals(flavor);
	}

}
