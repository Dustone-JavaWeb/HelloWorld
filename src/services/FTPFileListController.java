package services;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import gui.fileTable.FTP.FileTable;
import gui.fileTable.FTP.FileTableModel;
import gui.panel.FTPFilePanel;
import gui.panel.LocalFilePanel;
import util.FTPFileLister;
import util.FileLister;

public class FTPFileListController {
	private FTPFilePanel FTPanel;
	private FTPFileLister fileLister;
	private FTPClient ftpClient;
	public FTPFileListController(FTPFilePanel LFPanel,FTPClient ftpClient) {
		this.FTPanel=LFPanel;
		this.ftpClient=ftpClient;
		fileLister=new FTPFileLister();
		this.FTPanel.fileTable.addMouseListener(new FileChooser());
	}
	public void setView(FTPClient f) throws IOException {
		FTPanel.fileTable.setModel(new FileTableModel(fileLister.makeTableData(f)));
	}
	public FTPFile[] getSelectedFiles() {
		int key=FTPanel.fileTable.getSelectedRow();
		if(key==-1) {
			return null;
		}
		int[] filePoints=FTPanel.fileTable.getSelectedRows();;
		FTPFile[] selectedFile=new FTPFile[filePoints.length];
		for(int i=0;i<filePoints.length;i++) {
			selectedFile[i]=(FTPFile) FTPanel.fileTable.getModel().getValueAt(filePoints[i], 0);
		}
		return selectedFile;
	}
	class FileChooser extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			 if(e.getClickCount()==2) {
				 FileTable ft=(FileTable)e.getSource();
				 int row =ft.rowAtPoint(e.getPoint()); //获得行位置
				 FTPFile f=(FTPFile)ft.getModel().getValueAt(row, 0);
				 if(f.isDirectory()) {
					try {
						ftpClient.changeWorkingDirectory(f.getName());
						setView(ftpClient);
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				 }
			 }
		}
	}
	
}
