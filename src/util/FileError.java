package util;

import java.io.File;

import org.apache.commons.net.ftp.FTPFile;

public class FileError {
	private FTPFile ftpFile;
	private File file;
	private String info;
	public FileError(FTPFile ftpFile,String info) {
		this.ftpFile=ftpFile;
		this.info=info;
	}
	public FileError(File File,String info) {
		this.file=File;
		this.info=info;
	}
	public FTPFile getFtpFile() {
		return ftpFile;
	}
	public void setFtpFile(FTPFile ftpFile) {
		this.ftpFile = ftpFile;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
