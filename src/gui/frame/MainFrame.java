package gui.frame;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import gui.panel.AddPanel;
import gui.panel.ConsolePanel;
import gui.panel.FTPFilePanel;
import gui.panel.LayoutPanel;
import gui.panel.LinkChoosePanel;
import gui.panel.LocalFilePanel;
import gui.panel.ToolPanel;

public class MainFrame extends JFrame{
	public FTPFilePanel ftpFilePanel;
	public LocalFilePanel localFilePanel;
	public ToolPanel toolPanel;
	public LayoutPanel layoutPanel;
	public ConsolePanel consolePanel;
	public JPanel topPanel;
	public JPanel midPanel;
	public JPanel downPanel;
	public JFrame chooseFrame;
	public JFrame addFrame;
	public LinkChoosePanel choosePanel;
	public AddPanel addPanel;
	public Dimension frameSize=new Dimension(800,600);
	public MainFrame() {
		super("MyFTP");
		topPanel=new JPanel();
		midPanel=new JPanel();
		downPanel=new JPanel();
		
		toolPanel=new ToolPanel();
		consolePanel=new ConsolePanel();
		layoutPanel=new LayoutPanel();
		ftpFilePanel=new FTPFilePanel();
		localFilePanel=new LocalFilePanel();
		
		chooseFrame=new JFrame("连接选择");
		choosePanel=new LinkChoosePanel();
		
		addFrame=new JFrame("增加连接");
		addPanel=new AddPanel();
		init();
	}
	public void init() {
		//主窗体配置
		Container container=this.getContentPane();
		this.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
		this.setSize(frameSize);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(this);
		topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.X_AXIS));
		midPanel.setLayout(new BoxLayout(midPanel,BoxLayout.X_AXIS));
		downPanel.setLayout(new BoxLayout(downPanel,BoxLayout.X_AXIS));
		container.add(topPanel);
		container.add(midPanel);
		container.add(downPanel);
		
		//窗体部件配置
		topPanel.add(toolPanel);
		midPanel.add(localFilePanel);
		midPanel.add(ftpFilePanel);
		downPanel.add(consolePanel);
		downPanel.add(layoutPanel);
		
		//弹出窗体配置
		SwingUtilities.updateComponentTreeUI(chooseFrame);
		chooseFrame.setSize(300, 120);
		chooseFrame.setVisible(false);
		chooseFrame.setResizable(false);
		chooseFrame.add(choosePanel);
		
		//连接增加窗体配置
		SwingUtilities.updateComponentTreeUI(addFrame);
		addFrame.setSize(300, 120);
		addFrame.setVisible(false);
		addFrame.setResizable(false);
		addFrame.add(addPanel);
	}
}
