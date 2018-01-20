package gui.panel;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import gui.listener.ToolBarListener;
import util.GUIUtil;

public class ToolPanel extends JPanel{
	public JToolBar tb = new JToolBar();
	public JButton bBack = new JButton();
    public JButton bUpload = new JButton();
    public JButton bDownload = new JButton();
    public JButton bLogin = new JButton();
    public JButton bLogout = new JButton();
    public JButton bPackage = new JButton();
    public JButton bRename = new JButton();
    public JButton bDelete = new JButton();
    public JButton bClearList = new JButton();
    public ToolPanel() {
    	GUIUtil.setImageIcon(bBack, "back.png", "��һ��");
    	GUIUtil.setImageIcon(bLogin, "login.png", "��½");
        GUIUtil.setImageIcon(bLogout, "logout.png", "�ǳ�");
        GUIUtil.setImageIcon(bUpload, "up.png", "�ϴ�");
        GUIUtil.setImageIcon(bDownload, "down.png", "����");
        GUIUtil.setImageIcon(bDelete, "delete.png", "ɾ��");
        
        tb.add(bBack);
        tb.add(bLogin);
        tb.add(bLogout);
        tb.add(bUpload);
        tb.add(bDownload);
        tb.add(bDelete);
        tb.setFloatable(false);
        this.add(tb);
        addListener(this);
    }
    private void addListener(ToolPanel tp) {
    	ToolBarListener listener = new ToolBarListener(this);
    	bBack.addActionListener(listener);
    	bLogout.addActionListener(listener);
    	bLogin.addActionListener(listener);
    	bDownload.addActionListener(listener);
    	bUpload.addActionListener(listener);
    	bDelete.addActionListener(listener);
    }
}
