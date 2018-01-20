package gui.panel;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class LayoutPanel extends JPanel{
	public JTextArea layoutArea;
	public JScrollPane jScrollPane;
	public JLabel collectLabel;
	public LayoutPanel() {
		layoutArea=new JTextArea();
		collectLabel=new JLabel("Êä³öÁÐ±í");
		jScrollPane=new JScrollPane(layoutArea);
		init();
	}
	public void init() {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.add(collectLabel);
		this.add(jScrollPane);
		jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		layoutArea.setRows(8);
		collectLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}
	public void append(String msg) {
		layoutArea.append(msg+"\n");
	}
}
