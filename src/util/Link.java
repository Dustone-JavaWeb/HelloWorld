package util;

public class Link {
	private String userName;
	private String passwd;
	private String url;
	private String teacherName;
	private String teacherID;
	public Link(String url,String userName,String passwd,String teacherName,String teacherID) {
		this.setUrl(url);
		this.setUserName(userName);
		this.setPasswd(passwd);
		this.setTeacherName(teacherName);
		this.setTeacherID(teacherID);
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}
}
