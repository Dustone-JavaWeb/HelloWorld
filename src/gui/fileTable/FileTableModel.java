package gui.fileTable;
import java.io.File;

import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;


public class FileTableModel extends DefaultTableModel {
	private static String[] tableHeader = {"����", "�޸�����", "����", "��С"};
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
        File file = (File) super.getValueAt(row, column);
        if (column == 0){
            return file;
        } else if (column == 1){
            return file.lastModified();
        } else if (column == 2) {
            return fileSystemView.getSystemTypeDescription(file);
        } else if (column == 3){
            return file.length();
        }
        return super.getValueAt(row, column);
    }
}