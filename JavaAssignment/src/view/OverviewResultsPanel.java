package view;

//import java.awt.Color;


import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class OverviewResultsPanel extends JPanel {

	private JTextArea txtOverview;
	private JTextField txtFirName;
	private JButton saveOverview;


	public OverviewResultsPanel() {
		//create a combound border, a titled border, which then has an empty border for padding
		this.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new TitledBorder("Overview Results")));

		//set the layout manager for this panel to be grid layout
		this.setLayout(new GridLayout(3,2));

		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		txtOverview = new JTextArea("Overview will appear here", 15, 50);
		txtOverview.setEditable(false);
		//this.setBorder(new EmptyBorder(25,10,10,10));

		this.add(txtOverview);

		this.add(txtOverview);

		JPanel p;


		saveOverview = new JButton("Save Overview");

		this.add(new JPanel());
		p = new JPanel();
		p.add(saveOverview);
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p);

	}



	public void setOverview(String overview) {
		txtOverview.setText(overview);
	}

	public JTextArea getOverview() {
		return txtOverview;


	}


	public void addSaveListener(ActionListener al) {
		saveOverview.addActionListener(al);
	}
	
}
