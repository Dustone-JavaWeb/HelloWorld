package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.Link;

public class ReadDAO {
	public static String CONNECTION=
			"jdbc:mysql://127.0.0.1:3306/myftp?characterEncoding=UTF-8";
	public static String USERNAME="root";
	public static String PASSWD="chenyan970706";
	public ArrayList<Link> init(){
		ArrayList<Link> teacherStack=new ArrayList<Link>();
		try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		try(
				Connection c = DriverManager.getConnection(CONNECTION,USERNAME,PASSWD);
				Statement s = c.createStatement();
			){
			String sql = "select * from teacherinfo";
			//执行SQL语句 返回所有信息
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				String url=rs.getString("url");
				String userName=rs.getString("userName");
				String passwd=rs.getString("passwd");
				String teacherName=rs.getString("teacherName");
				String teacherID=rs.getString("teacherID");
				Link link=new Link(url,userName,passwd,teacherName,teacherID);
				teacherStack.add(link);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return teacherStack;
	}
}
