package ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import util.FileError;
import util.Link;

public class MainFTP {
	private Link thisLink;
	private FTPClient ftpClient;
	private FTPFile[] ftpList;
	public MainFTP(Link thisLink) {
		this.thisLink=thisLink;
		ftpClient=new FTPClient();
		ftpClient.setControlEncoding("GBK");
		init();
	}
	//初始化
	private void init() {
		try {
			ftpClient.connect(thisLink.getUrl());
			System.out.println("connect to server");
			int reply=ftpClient.getReplyCode();
			System.out.println(reply);
		} catch (SocketException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	//登陆方法
	public String logIn() throws IOException {
		boolean login=ftpClient.login(thisLink.getUserName(), thisLink.getPasswd());
		if(login) {
			return "登陆成功";
		}else {
			return "登录失败";
		}
	}
	//注销方法
	public void logOut() {
		if (ftpClient.isConnected()) {  
			 try {  
				ftpClient.disconnect();  
			 } catch (IOException e) {  
			 	e.printStackTrace();  
			 }  
		 }
	}
	//列出当前工作路径的文件列表
	public FTPFile[] getList() throws IOException {
		ftpList=ftpClient.listFiles();
		return ftpList;
	}
	//设置工作路径
	public FileError setPath(FTPFile workPath) throws IOException {
		if(workPath.isDirectory()){
			ftpClient.changeWorkingDirectory(workPath.getName());
			ftpList=ftpClient.listFiles();
			System.out.println(ftpClient.printWorkingDirectory());
			return null;
		}else {
			return new FileError(workPath,"不是文件夹");
		}
	}
	//上传文件到当前路径
	public FileError sentFile(File file){
		/*if(fileCheck(file)) {
			return new FileError(file,"在服务器中已存在！");
		}*/
		try(
				FileInputStream fis=new FileInputStream(file);
			){
			ftpClient.storeFile(file.getName(), fis);
			System.out.println(ftpClient.getReplyCode());
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			
		}
		if(ftpClient.getReplyCode()==226) {
			return new FileError(file,"传输成功！");
		}else {
			return new FileError(file,"传输失败！");
		}
	}
	//下载文件到指定路径
	public FileError recieveFile(File file,FTPFile ftpFile){
		try(
				FileOutputStream fos=new FileOutputStream(file);
			){
			ftpClient.retrieveFile(ftpFile.getName(), fos);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
		}
		if(ftpClient.getReplyCode()==226) {
			return new FileError(file,"传输成功！");
		}else {
			return new FileError(file,"传输失败！");
		}
	}
	//文件查重
	public boolean fileCheck(File file) {
		for(FTPFile ftpFile:ftpList) {
			if(ftpFile.getName().equals(file.getName())) {
				return true;
			}
		}
		return false;
	}
	//取得连接信息
	public Link getThisLink() {
		return thisLink;
	}
	//设置连接信息
	public void setThisLink(Link thisLink) {
		this.thisLink = thisLink;
	}
	public FTPClient getFTPClient() {
		return ftpClient;
	}
	
}
