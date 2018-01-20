package Main;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ftp.MainFTP;
import gui.frame.MainFrame;
import gui.panel.FTPFilePanel;
import gui.panel.LocalFilePanel;
import services.FTPFileListController;
import services.FileListController;
import services.MainController;
import util.Link;

public class main {
	public static void main(String[] args) throws IOException {
		Link myLink=new Link("172.16.3.240","kjdown","kjdown","240¿Î¼þ·þÎñÆ÷","240");
		MainController mc=MainController.getInstance();
		mc.login(myLink);
	}
}
