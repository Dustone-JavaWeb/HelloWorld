package dao;

import java.util.ArrayList;
import java.util.Iterator;

import util.Link;

public class LinkStack {
	public ArrayList<Link> teacherStack;
	public ReadDAO readDAO;
	public WriteDAO writeDAO;
	public LinkStack() {
		readDAO=new ReadDAO();
		writeDAO=new WriteDAO();
		teacherStack=new ArrayList<Link>();
	}
	public void add(Link link) {
		writeDAO.add(link);
		init();
	}
	public void init() {
		teacherStack=readDAO.init();
	}
	public void delete(String id) {
		Iterator<Link> it = teacherStack.iterator();
		while(it.hasNext()) {
			Link link=it.next();
			System.out.println(link.getTeacherID());
			if(link.getTeacherID().equals(id)) {
				writeDAO.delete(id);
				break;
			}
		}
	}
	public Link[] getArr() {
		Link[] linklist=new Link[teacherStack.size()];
		Iterator<Link> it = teacherStack.iterator();
		for(int i=0;i<teacherStack.size();i++){
			linklist[i]=it.next();
		}
		return linklist;
	}
	
}
