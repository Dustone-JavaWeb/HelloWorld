package gui.panel;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class ConsolePanel extends JPanel{
	public JTextArea infoArea;
	public JLabel collectLabel;
	public JScrollPane jScrollPane;
	public ConsolePanel() {
		infoArea=new JTextArea();
		collectLabel=new JLabel("´«ÊäÁÐ±í");
		jScrollPane=new JScrollPane(infoArea);
		init();
	}
	public void init() {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.add(collectLabel);
		this.add(jScrollPane);
		
		jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		infoArea.setRows(8);
		collectLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}
}
