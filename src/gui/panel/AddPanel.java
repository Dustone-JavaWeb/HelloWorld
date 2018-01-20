package gui.panel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import services.MainController;
import util.Link;

public class AddPanel extends JPanel{
	public JButton bAdd;
	public JTextField tUrl;
	public JTextField tUserName;
	public JTextField tPasswd;
	public JTextField tTeacherName;
	public JTextField tTeacherID;
	public JLabel lUrl;
	public JLabel lUserName;
	public JLabel lPasswd;
	public JLabel lTeacherName;
	public JLabel lTeacherID;
	public AddPanel() {
		bAdd=new JButton("����");
		
		lUrl=new JLabel("URL");
		lUserName=new JLabel("�û���");
		lPasswd=new JLabel("����");
		lTeacherName=new JLabel("��ʦ����");
		lTeacherID=new JLabel("��ʦ����");
		
		tUrl=new JTextField(5);
		tUserName=new JTextField(5);
		tPasswd=new JTextField(5);
		tTeacherName=new JTextField(5);
		tTeacherID=new JTextField(5);
		init();
	}
	public void init() {
		this.setLayout(new GridLayout(6,2));
		this.add(lUrl);
		this.add(tUrl);
		this.add(lUserName);
		this.add(tUserName);
		this.add(lPasswd);
		this.add(tPasswd);
		this.add(lTeacherName);
		this.add(tTeacherName);
		this.add(lTeacherID);
		this.add(tTeacherID);
		this.add(bAdd);
		bAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				MainController mainController=MainController.getInstance();
				Link link=new Link(
						tUrl.getText(),
						tUserName.getText(),
						tPasswd.getText(),
						tTeacherName.getText(),
						tTeacherID.getText()
						);
				tUrl.setText("");
				tUserName.setText("");
				tPasswd.setText("");
				tTeacherName.setText("");
				tTeacherID.setText("");
				mainController.addLink(link);
				mainController.hideAddFrame();
			}
		});
	}
}
