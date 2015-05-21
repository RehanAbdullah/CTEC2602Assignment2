package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import model.Course;
import model.Module;
import model.Name;

public class CreateProfilePanel extends JPanel {
	
	private JComboBox<Course> comboCourse;
	private JTextField txtFirName, txtSeconName, txtPNo;
	private JButton btnCreProfile;
	private DefaultListModel<Module> listModel;
	
	public CreateProfilePanel() {
		
		//create a combound border, a titled border, which then has an empty border for padding
				this.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new TitledBorder("Create Profile")));

				//set the layout manager for this panel to be grid layout
				this.setLayout(new GridLayout(3,2));
				
		this.setLayout(new GridLayout(5,2));
		//this.setBorder(new EmptyBorder(25,10,10,10));
		
		JPanel p;
		
		JLabel lblCourse = new JLabel("Select course: ");		
		comboCourse = new JComboBox<Course>();
		
		
		JLabel lblFirName = new JLabel("Input first name: ");
		txtFirName= new JTextField(12);
		
		JLabel lblSeconName = new JLabel("Input last name: ");
		txtSeconName = new JTextField(12);
		
		JLabel lblPno = new JLabel("Input P Number: ");
		txtPNo = new JTextField(12);
		
		btnCreProfile = new JButton("Create Profile");
		
		
		
		p = new JPanel();
		p.add(lblCourse);
		p.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(p);
		
		p = new JPanel();
		p.add(comboCourse);
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p);
		
		p = new JPanel();
		p.add(lblFirName);
		p.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(p);
		
		p = new JPanel();
		p.add(txtFirName);
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p);
		
		
		
		p = new JPanel();
		p.add(lblSeconName);
		p.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(p);
		
		p = new JPanel();
		p.add(txtSeconName);
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p);
	
		
		p = new JPanel();
		p.add(lblPno);
		p.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(p);
		
		p = new JPanel();
		p.add(txtPNo);
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p);
		
		this.add(new JPanel());
		p = new JPanel();
		p.add(btnCreProfile);
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p);
		
	}
	
	public void populateComboBox(Course[] courses) {
		for (Course a : courses) {
			comboCourse.addItem(a);
		}
	}
	public void addModule(Module a) {
		listModel.addElement(a);
	}
	
	public Course getSelectedCourse() {
		return (Course) comboCourse.getSelectedItem();
	}
	
	public String getFNameInput() {
		return txtFirName.getText();
	}
	
	public String getLNameInput() {
		return txtSeconName.getText();
	}
	
	public String gettxtPNo() {
		return txtPNo.getText();
	}
	
	public void addCourseListener(ActionListener al) {
		btnCreProfile.addActionListener(al);
	}
	
	//listeners
	public void addCreateProfileListener(ActionListener al) {
		btnCreProfile.addActionListener(al);
	}

	public void reset() {
		//comboCourse
		txtFirName.setText("");
		txtSeconName.setText("");
		txtPNo.setText("");
		
	}
}
