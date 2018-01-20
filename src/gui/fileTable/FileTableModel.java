package gui.fileTable;
import java.io.File;

import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;


public class FileTableModel extends DefaultTableModel {
	private static String[] tableHeader = {"名称", "修改日期", "类型", "大小"};
	//获得当前系统的文件样式
    private FileSystemView fileSystemView = FileSystemView.getFileSystemView();
    public FileTableModel(Object[][] objects){
        super(objects, tableHeader);
    }
    //列表不可编辑
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    //设置每行每个列
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