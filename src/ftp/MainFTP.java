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
	//��ʼ��
	private void init() {
		try {
			ftpClient.connect(thisLink.getUrl());
			System.out.println("connect to server");
			int reply=ftpClient.getReplyCode();
			System.out.println(reply);
		} catch (SocketException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	//��½����
	public String logIn() throws IOException {
		boolean login=ftpClient.login(thisLink.getUserName(), thisLink.getPasswd());
		if(login) {
			return "��½�ɹ�";
		}else {
			return "��¼ʧ��";
		}
	}
	//ע������
	public void logOut() {
		if (ftpClient.isConnected()) {  
			 try {  
				ftpClient.disconnect();  
			 } catch (IOException e) {  
			 	e.printStackTrace();  
			 }  
		 }
	}
	//�г���ǰ����·�����ļ��б�
	public FTPFile[] getList() throws IOException {
		ftpList=ftpClient.listFiles();
		return ftpList;
	}
	//���ù���·��
	public FileError setPath(FTPFile workPath) throws IOException {
		if(workPath.isDirectory()){
			ftpClient.changeWorkingDirectory(workPath.getName());
			ftpList=ftpClient.listFiles();
			System.out.println(ftpClient.printWorkingDirectory());
			return null;
		}else {
			return new FileError(workPath,"�����ļ���");
		}
	}
	//�ϴ��ļ�����ǰ·��
	public FileError sentFile(File file){
		/*if(fileCheck(file)) {
			return new FileError(file,"�ڷ��������Ѵ��ڣ�");
		}*/
		try(
				FileInputStream fis=new FileInputStream(file);
			){
			ftpClient.storeFile(file.getName(), fis);
			System.out.println(ftpClient.getReplyCode());
			
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			
		}
		if(ftpClient.getReplyCode()==226) {
			return new FileError(file,"����ɹ���");
		}else {
			return new FileError(file,"����ʧ�ܣ�");
		}
	}
	//�����ļ���ָ��·��
	public FileError recieveFile(File file,FTPFile ftpFile){
		try(
				FileOutputStream fos=new FileOutputStream(file);
			){
			ftpClient.retrieveFile(ftpFile.getName(), fos);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
		}
		if(ftpClient.getReplyCode()==226) {
			return new FileError(file,"����ɹ���");
		}else {
			return new FileError(file,"����ʧ�ܣ�");
		}
	}
	//�ļ�����
	public boolean fileCheck(File file) {
		for(FTPFile ftpFile:ftpList) {
			if(ftpFile.getName().equals(file.getName())) {
				return true;
			}
		}
		return false;
	}
	//ȡ��������Ϣ
	public Link getThisLink() {
		return thisLink;
	}
	//����������Ϣ
	public void setThisLink(Link thisLink) {
		this.thisLink = thisLink;
	}
	public FTPClient getFTPClient() {
		return ftpClient;
	}
	
}
