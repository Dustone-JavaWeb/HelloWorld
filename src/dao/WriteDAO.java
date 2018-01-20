package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.Link;

public class WriteDAO {
	public static String CONNECTION=
			"jdbc:mysql://127.0.0.1:3306/myftp?characterEncoding=UTF-8";
	public static String USERNAME="root";
	public static String PASSWD="chenyan970706";
	public void delete(String id) {
		// TODO 自动生成的方法存根
		try(
				Connection c = DriverManager.getConnection(CONNECTION,USERNAME,PASSWD);
				Statement s = c.createStatement();
			){
			String sql = "delete from teacherinfo where teacherID="+"'"+id+"'";
			s.execute(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void add(Link link) {
		try(
				Connection c = DriverManager.getConnection(CONNECTION,USERNAME,PASSWD);
				Statement s = c.createStatement();
			){
			System.out.println(link.getUrl());
			String sql2="insert into teacherinfo values(null,'172.16.3.241','upload_0351','upload_0351','chenyan','0351')";
			/*String sql = "insert into teacherinfo values(null,'"+link.getUrl()+"',"
														+link.getUserName()+"','"
														+link.getPasswd()+"','"
														+link.getTeacherName()+"','"
														+link.getTeacherID()+"')";*/
			String sql = "insert into teacherinfo values"+
					  "("
					   + "null"
					   + ","+"'"+link.getUrl()+			"'"
					   + ","+"'"+link.getUserName()+	"'"
					   + ","+"'"+link.getPasswd()+		"'"
					   + ","+"'"+link.getTeacherName()+	"'"
					   + ","+"'"+link.getTeacherID()+	"'"
					   +")";
			s.execute(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
