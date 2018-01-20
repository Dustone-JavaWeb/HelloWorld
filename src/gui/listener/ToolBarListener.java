package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import gui.panel.ToolPanel;
import services.MainController;
import util.Link;

public class ToolBarListener implements ActionListener{
	ToolPanel toolPanel;
	MainController mainController;
	public ToolBarListener(ToolPanel tp) {
		toolPanel=tp;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		mainController=MainController.getInstance();
		// TODO 自动生成的方法存根
		JButton b = (JButton) e.getSource();
        if (b == toolPanel.bBack) {
        	mainController.changeToParent();
        }
        if(b==toolPanel.bLogout) {
        	mainController.logOut();
        }
        if(b==toolPanel.bLogin) {
        	mainController.showChooseFrame();
        }
        if(b==toolPanel.bDownload) {
        	mainController.DownloadFile();
        }
        if(b==toolPanel.bUpload) {
        	mainController.UploadFile();
        }
        if(b==toolPanel.bDelete) {
        	mainController.deleteLocalFile();
        }
	}
	
}
