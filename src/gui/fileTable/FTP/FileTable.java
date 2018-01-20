package gui.fileTable.FTP;
import java.awt.Dimension;
import java.io.File;
import java.util.Comparator;

import javax.swing.JTable;
import javax.swing.table.TableModel;


public class FileTable extends JTable {
	public FileTable(){
		//项渲染器
        this.setDefaultRenderer(Object.class, new FileTableCellRenderer());
        //排序
        this.setAutoCreateRowSorter(true);
        //表头
        this.getTableHeader().setReorderingAllowed(false);
        //去掉横向纵向线条
        this.setShowHorizontalLines(true);
        this.setShowVerticalLines(true);
        setIntercellSpacing(new Dimension(0,0)); //修改单元格间隔，因此也将影响网格线的粗细。
        setRowMargin(0);//设置相邻两行单元格的距离
    }

    @Override
    public void setModel(TableModel dataModel) {
        super.setModel(dataModel);
    }
}