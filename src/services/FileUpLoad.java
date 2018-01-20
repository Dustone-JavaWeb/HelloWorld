package services;

import java.io.File;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPFile;

import ftp.MainFTP;

public class FileUpLoad {
	public FileUpLoad(File[] files,MainFTP mainFTP,MainController mc,int mark) throws IOException {
		for(File file:files) {
			if(file.isDirectory()) {
				/*if(file.getName().equals(".")||file.getName().equals("..")) {
					continue;
				}*/
				mainFTP.getFTPClient().makeDirectory(file.getName());
				mainFTP.getFTPClient().changeWorkingDirectory(file.getName());
				mc.setFTPView();
				mc.setLocalView(file);
				new FileUpLoad(file.listFiles(),mainFTP,mc,1);
			}else if(file.isFile()){
				mainFTP.sentFile(file);
			}
		}
		if(mark==1) {
			mainFTP.getFTPClient().changeToParentDirectory();
		}
	}
}

