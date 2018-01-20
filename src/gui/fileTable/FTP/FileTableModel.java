package gui.fileTable.FTP;
import java.io.File;

import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.net.ftp.FTPFile;


public class FileTableModel extends DefaultTableModel {
	private static String[] tableHeader = {"����", "�޸�����", "����", "��С"};
	private static File DIR=new File("DIR");
	private static File FILE=new File("DIR/file");
	//��õ�ǰϵͳ���ļ���ʽ
    private FileSystemView fileSystemView = FileSystemView.getFileSystemView();
    public FileTableModel(Object[][] objects){
        super(objects, tableHeader);
    }
    //�б��ɱ༭
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    //����ÿ��ÿ����
    @Override
    public Object getValueAt(int row, int column) {
        FTPFile file = (FTPFile) super.getValueAt(row, column);
        if (column == 0){
            return file;
        } else if (column == 1){
            return file.getTimestamp().getTime();
        } else if (column == 2) {
        	if(file.isDirectory()) {
        		return fileSystemView.getSystemTypeDescription(DIR);
        	}else {
        		return fileSystemView.getSystemTypeDescription(FILE);
        	}
        } else if (column == 3){
            return file.getSize();
        }
        return super.getValueAt(row, column);
    }
}