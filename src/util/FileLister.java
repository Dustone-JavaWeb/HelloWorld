package util;

import java.io.File;

public class FileLister {
	private Object[][] data;
	private File[] fileList;
	public Object[][] makeTableData(File file){
		fileList=file.listFiles();
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
