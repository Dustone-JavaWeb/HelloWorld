package gui.fileTable.FTP;
import java.awt.Dimension;
import java.io.File;
import java.util.Comparator;

import javax.swing.JTable;
import javax.swing.table.TableModel;


public class FileTable extends JTable {
	public FileTable(){
		//����Ⱦ��
        this.setDefaultRenderer(Object.class, new FileTableCellRenderer());
        //����
        this.setAutoCreateRowSorter(true);
        //��ͷ
        this.getTableHeader().setReorderingAllowed(false);
        //ȥ��������������
        this.setShowHorizontalLines(true);
        this.setShowVerticalLines(true);
        setIntercellSpacing(new Dimension(0,0)); //�޸ĵ�Ԫ���������Ҳ��Ӱ�������ߵĴ�ϸ��
        setRowMargin(0);//�����������е�Ԫ��ľ���
    }

    @Override
    public void setModel(TableModel dataModel) {
        super.setModel(dataModel);
    }
}