package services;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTPFile;

import ftp.MainFTP;
import gui.frame.MainFrame;
import gui.panel.LayoutPanel;
import util.Link;

public class MainController {
	private FileListController flc;
	private FTPFileListController ftpc;
	private LinkListController llc;
	private FileDownload fileDown;
	private FileUpLoad fileUp;
	private MainFTP mainFTP;
	private MainFrame mainFrame;
	private LayoutPanel layoutPanel;
	private static MainController mc=new MainController();  
    //静态工厂方法   
    public static MainController getInstance() {  
        return mc;  
    }  
	private MainController() {
		mainFrame=new MainFrame();
		layoutPanel=mainFrame.layoutPanel;
		init();
	}
	private void init() {
		flc=new FileListController(mainFrame.localFilePanel);
		File file=new File("F:/课件");
		setLocalView(file);
		llc=new LinkListController(mainFrame.choosePanel);
	}
	//FTP客户端
	public void login(Link link) throws IOException {
		mainFTP=new MainFTP(link);
		mainFTP.logIn();
		layoutPanel.append(mainFTP.getThisLink().getUrl()+":Log in");
		ftpc=new FTPFileListController(mainFrame.ftpFilePanel,mainFTP.getFTPClient());
		mainFrame.ftpFilePanel.showTable();
		setFTPView();
	}
	public void logOut() {
		mainFTP.logOut();
		layoutPanel.append(mainFTP.getThisLink().getUrl()+":Log out");
		mainFrame.ftpFilePanel.hideTable();
	}
	//视图管理
	public void setFTPView() throws IOException {
		ftpc.setView(mainFTP.getFTPClient());
	}
	public void setLocalView(File file) {
		flc.setView(file);
	}
	//本地转到父文件夹
	public void changeToParent() {
		File f=flc.workingFile.getParentFile();
		flc.setView(f);
	}
	//下载文件
	public void DownloadFile() {
		FTPFile[] files=ftpc.getSelectedFiles();
		File basePath=flc.workingFile;
		try {
			fileDown=new FileDownload(files, mainFTP, this,0);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		flc.setView(basePath);
		try {
			ftpc.setView(mainFTP.getFTPClient());
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		flc.refresh();
	}
	//上传文件
	public void UploadFile() {
		File files[]=flc.getSelectedFiles();
		File basePath=flc.workingFile;
		try {
			fileUp=new FileUpLoad(files, mainFTP, this,0);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		flc.setView(basePath);
		try {
			ftpc.setView(mainFTP.getFTPClient());
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		flc.refresh();
	}
	//删除本地文件
	public void deleteLocalFile() {
		Object[] options = { "确定", "取消" }; 
		int i=JOptionPane.showOptionDialog(null, "确认删除？", "警告", 
		JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
		null, options, options[0]); 
		if(i==0) {
			File basePath=flc.workingFile;
			File files[]=flc.getSelectedFiles();
			for(File file:files) {
				file.delete();
			}
			flc.setView(basePath);
		}
	}
	public File getLocalPath() {
		return flc.workingFile;
	}
	public void LinkChoose(int point) throws IOException {
		Link link=llc.getLink(point);
		login(link);
	}
	public void deleteLink(int point) {
		Link link=llc.getLink(point);
		llc.delete(link.getTeacherID());
	}
	public void addLink(Link link) {
		llc.add(link);
	}
	public void hideChooseFrame() {
		mainFrame.chooseFrame.setVisible(false);
	}
	public void showChooseFrame() {
		mainFrame.chooseFrame.setVisible(true);
	}
	public void hideAddFrame() {
		mainFrame.addFrame.setVisible(false);
	}
	public void showAddFrame() {
		mainFrame.addFrame.setVisible(true);
	}
}
