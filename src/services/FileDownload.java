package services;

import java.io.File;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPFile;

import ftp.MainFTP;

public class FileDownload {
	public FileDownload(FTPFile[] files,MainFTP mainFTP,MainController mc,int mark) throws IOException {
		int k=0;
		for(FTPFile file:files) {
			if(file.isDirectory()) {
				if(file.getName().equals(".")||file.getName().equals("..")) {
					continue;
				}
				mainFTP.setPath(file);
				mc.setFTPView();
				File localFile=new File(mc.getLocalPath().getAbsolutePath()+"/"+file.getName());
				localFile.mkdir();
				mc.setLocalView(localFile);
				new FileDownload(mainFTP.getList(),mainFTP,mc,1);
			}else if(file.isFile()){
				File localFile=new File(mc.getLocalPath().getAbsolutePath()+"/"+file.getName());
				mainFTP.recieveFile(localFile, file);
			}
		}
		if(mark==1) {
			mc.setLocalView(new File(mc.getLocalPath().getAbsolutePath()).getParentFile());
			mainFTP.getFTPClient().changeToParentDirectory();
		}else {
			mc.setFTPView();
		}
	}
}
