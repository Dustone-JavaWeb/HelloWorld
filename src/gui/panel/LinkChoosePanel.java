package gui.panel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.listener.LinkChooseListener;
import gui.listener.ToolBarListener;

public class LinkChoosePanel extends JPanel{
	public JComboBox jComboBox;
	public JButton bChoose;
	public JButton bDelete;
	public JButton bAdd;
	public JPanel leftPanel;
	public JPanel rightPanel;
	public JLabel jLabel;
	
	public LinkChoosePanel() {
		bChoose=new JButton("连接");
		bDelete=new JButton("删除这条记录");
		bAdd=new JButton("增加一条记录");
		jLabel=new JLabel("请选择连接:");
		leftPanel=new JPanel();
		rightPanel=new JPanel();
		jComboBox=new JComboBox();
		init();
	}
	public void init() {
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		jLabel.setSize(200, 100);
		leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));
		leftPanel.add(jLabel);
		leftPanel.add(jComboBox);
		rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));
		rightPanel.add(bAdd);
		rightPanel.add(bDelete);
		rightPanel.add(bChoose);
		this.add(leftPanel);
		this.add(rightPanel);
		addListener(this);
	}
	private void addListener(LinkChoosePanel lp) {
    	LinkChooseListener listener = new LinkChooseListener(this);
    	bChoose.addActionListener(listener);
    	bDelete.addActionListener(listener);
    	bAdd.addActionListener(listener);
    }
	
}
