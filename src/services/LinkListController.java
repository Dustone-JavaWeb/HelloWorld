package services;

import dao.LinkStack;
import gui.panel.LinkChoosePanel;
import util.Link;

public class LinkListController {
	public LinkChoosePanel lcp;
	public LinkStack lst;
	public LinkListController(LinkChoosePanel lcp) {
		lst=new LinkStack();
		lst.init();
		this.lcp=lcp;
		init();
	}
	public void refresh() {
		lst.init();
		init();
	}
	public void init() {
		lcp.jComboBox.removeAllItems();
		Link[] item=lst.getArr();
		for(Link link:item) {
			lcp.jComboBox.addItem(link.getTeacherName());
		}
	}
	public Link getLink(int i) {
		Link[] item=lst.getArr();
		return item[i];
	}
	public void delete(String id) {
		lst.delete(id);
		refresh();
	}
	public void add(Link link) {
		lst.add(link);
		refresh();
	}
}
