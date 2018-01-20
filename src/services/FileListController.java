package services;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import org.apache.commons.net.ftp.FTPFile;

import gui.fileTable.FileTable;
import gui.fileTable.FileTableModel;
import gui.panel.LocalFilePanel;
import util.FileLister;

public class FileListController {
	private LocalFilePanel LFPanel;
	private FileLister fileLister;
	public File workingFile;
	public FileListController(LocalFilePanel LFPanel) {
		this.LFPanel=LFPanel;
		fileLister=new FileLister();
		this.LFPanel.fileTable.addMouseListener(new FileChooser());
	}
	public void setView(File file) {
		workingFile=file;
		LFPanel.fileTable.setModel(new FileTableModel(fileLister.makeTableData(file)));
	}
	public void refresh() {
		LFPanel.fileTable.setModel(new FileTableModel(fileLister.makeTableData(workingFile)));
	}
	public File[] getSelectedFiles() {
		int key=LFPanel.fileTable.getSelectedRow();
		if(key==-1) {
			return null;
		}
		int[] filePoints=LFPanel.fileTable.getSelectedRows();;
		File[] selectedFile=new File[filePoints.length];
		for(int i=0;i<filePoints.length;i++) {
			selectedFile[i]=(File) LFPanel.fileTable.getModel().getValueAt(filePoints[i], 0);
		}
		return selectedFile;
	}
	class FileChooser extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			 if(e.getClickCount()==2) {
				 FileTable ft=(FileTable)e.getSource();
				 int row =ft.rowAtPoint(e.getPoint()); //获得行位置
				 File f=(File)ft.getModel().getValueAt(row, 0);
				 setView(f);
			 }
		}
	}
}
