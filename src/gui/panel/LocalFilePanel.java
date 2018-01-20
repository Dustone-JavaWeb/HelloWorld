package gui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.JTableHeader;

import gui.fileTable.FileTable;
import util.FileLister;

public class LocalFilePanel extends JPanel{
	public FileTable fileTable;
	public LocalFilePanel() {
		super();
		this.setLayout(new BorderLayout());
		fileTable=new FileTable();
		JScrollPane jsp=new JScrollPane(fileTable);
		JTableHeader head=fileTable.getTableHeader();
		this.add(head,BorderLayout.NORTH);
		this.add(jsp,BorderLayout.CENTER);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	}
}
