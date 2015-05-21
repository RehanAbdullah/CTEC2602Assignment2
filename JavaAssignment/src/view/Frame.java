package view;

import java.awt.Dimension;
import java.awt.MenuBar;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import model.StudentProfile;


public class Frame extends JFrame {

	private CreateProfilePanel createPnl;
	private OverviewResultsPanel overviewPnl;
	private SelectModules selectModules;
	private JTabbedPane tabPane;
	private StudentProfile model;
	private Frame view;



	public Frame() {

		this.setTitle("Final Year Module Chooser Tool");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		/* Use a tabbed pane, so components can be placed on tabs*/
		tabPane = new JTabbedPane(JTabbedPane.TOP);
		tabPane.setPreferredSize(new Dimension(880, 380));
		this.add(tabPane);

		//First Tab
		createPnl = new CreateProfilePanel();
		tabPane.addTab("Create Profile", createPnl);
		tabPane.setMnemonicAt(0, KeyEvent.VK_1);

		//Second Tab                                  Select Modules
		selectModules = new SelectModules();
		tabPane.addTab("Select Modules", selectModules);
		tabPane.setMnemonicAt(1, KeyEvent.VK_2);

		//Third Tab 
		overviewPnl = new OverviewResultsPanel();
		tabPane.addTab("Overview Results", overviewPnl);
		tabPane.setMnemonicAt(2, KeyEvent.VK_3);





		this.setJMenuBar(new MyMenuBar());


		this.pack();
		this.setVisible(true);

	}

	public void changeTab(int index) {
		tabPane.setSelectedIndex(index);
	}

	public CreateProfilePanel getCreateProfilePanel() {
		return createPnl;
	}

	public SelectModules getSelectModules() {
		return selectModules;
	}

	public OverviewResultsPanel getOverviewResultsPanel() {
		return overviewPnl;
	}

	public Frame getFrame() {
		return view;
	}

	public StudentProfile getStudentProfile() {
		return model;
	}




}
