package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class FTPFileLister {
	private Object[][] data;
	private FTPFile[] fileList;
	public Object[][] makeTableData(FTPClient ftpClient) throws IOException{
		fileList=ftpClient.listFiles();
		data=new Object[fileList.length][4];
		for(int i=0;i<fileList.length;i++) {
			data[i][0]=fileList[i];
			data[i][1]=fileList[i];
			data[i][2]=fileList[i];
			data[i][3]=fileList[i];
		}
		return data;
	}
}
