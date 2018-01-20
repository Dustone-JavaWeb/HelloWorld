package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import gui.panel.LinkChoosePanel;
import gui.panel.ToolPanel;
import services.MainController;
import util.Link;

public class LinkChooseListener implements ActionListener{
	LinkChoosePanel linkChoosePanel;
	MainController mainController;
	public LinkChooseListener(LinkChoosePanel lp) {
		linkChoosePanel=lp;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		mainController=MainController.getInstance();
		// TODO 自动生成的方法存根
		JButton b = (JButton) e.getSource();
        if (b == linkChoosePanel.bChoose) {
        	int pointer=linkChoosePanel.jComboBox.getSelectedIndex();
        	try {
				mainController.LinkChoose(pointer);
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
        	mainController.hideChooseFrame();
        }
        if (b == linkChoosePanel.bDelete) {
        	int pointer=linkChoosePanel.jComboBox.getSelectedIndex();
        	mainController.deleteLink(pointer);
        }
        if (b == linkChoosePanel.bAdd) {
        	mainController.showAddFrame();
        }
	}
}
