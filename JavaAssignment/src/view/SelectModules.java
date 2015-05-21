package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import model.Course;
import model.Module;
import model.Name;

/* This panel is part of the View and displays the name panel form.*/
public class SelectModules extends JPanel {

	//declare components as fields so they can be accessed throughout the class
	private JComboBox<String> cboTitle;
	private JTextField txtSurname, txtFirstName, credBox;
	private JList<Module> list, list1;
	
	private DefaultListModel<Module> listModel;
	private DefaultListModel<Module> listModel1;
	
	


	//declared for access throughout class
	private JButton addBtn, resBtn, remBtn, subBtn;

	public SelectModules() {
		//create a combound border, a titled border, which then has an empty border for padding
		this.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new TitledBorder("Selected Modules")));

		//set the layout manager for this panel to be grid layout
		this.setLayout(new GridLayout(3,2));

		this.setLayout(new BorderLayout());



		//========================================================================================================================

		/* Use a tabbed pane, so components can be placed on tabs*/
		JTabbedPane tabPane = new JTabbedPane(JTabbedPane.TOP);
		tabPane.setPreferredSize(new Dimension(400, 220));
		this.add(tabPane); //add tab pane to the frame's content.

		list = new JList<Module>();
		listModel = new DefaultListModel<Module>();
		list.setModel(listModel);
		list.setVisibleRowCount(5);	



		//decorate with a scroll pane - list is added to the scroll pane, not other way round
		JScrollPane scrollPane = new JScrollPane(list);

		//Example use of box layout, vertical orientation
		Box layout = Box.createVerticalBox();
		//creates space
		layout.add(Box.createVerticalStrut(40)); 
		//this will add the list, contained within the scroll pane
		layout.add(scrollPane);
		//different way of creating space for both x,y coords
		layout.add(Box.createRigidArea(new Dimension(60,60))); 
		//  layout11.add(btnRemove11);      

		//container for holding the box            
		JPanel listPanel = new JPanel();
		listPanel.add(layout);

		//create a new tab and add the list panel
		tabPane.addTab("Unselected Modules", listPanel);


		//========================================================================================================================

		/* Use a tabbed pane, so components can be placed on tabs*/
		JTabbedPane tabPane1 = new JTabbedPane(JTabbedPane.TOP);
		tabPane1.setPreferredSize(new Dimension(400, 220));
		this.add(tabPane1); //add tab pane to the frame's content.

		list1 = new JList<Module>();
		listModel1 = new DefaultListModel<Module>();
		list1.setModel(listModel1);    
		list1.setVisibleRowCount(5);	

		//decorate with a scroll pane - list is added to the scroll pane, not other way round
		JScrollPane scrollPane1 = new JScrollPane(list1);

		//Example use of box layout, vertical orientation
		Box layout1 = Box.createVerticalBox();
		//creates space
		layout1.add(Box.createVerticalStrut(40)); 
		//this will add the list, contained within the scroll pane
		layout1.add(scrollPane1);
		//different way of creating space for both x,y coords
		layout1.add(Box.createRigidArea(new Dimension(60,60))); 
		//  layout11.add(btnRemove11);      

		//container for holding the box            
		JPanel listPanel1 = new JPanel();
		listPanel1.add(layout1);

		//create a new tab and add the list panel
		tabPane1.addTab("Selected Modules", listPanel1);

		//========================================================================================================================

		//sets layout, ensures buttons are aligned centrally
		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		//this.setBorder(new EmptyBorder(25,10,10,10));

		//ADD BUTTON
		addBtn = new JButton("Add");		

		//CLEAR BUTTON
		resBtn = new JButton("Reset");		

		//FIND BUTTON
		remBtn  = new JButton("Remove");

		//SUBMIT BUTTON
		subBtn  = new JButton("Submit");	

		//declares temporary panel
		JPanel p; 

		//add each button to temporary panel (providing a little padding) then add that to the overall ButtonPanel
		p = new JPanel();
		p.add(addBtn);
		this.add(p);

		p = new JPanel();
		p.add(resBtn);
		this.add(p);

		p = new JPanel();
		p.add(remBtn);
		this.add(p);

		p = new JPanel();
		p.add(subBtn);
		this.add(p);
		
		
	//    JLabel lblFirName = new JLabel("Credit Box: ");
		credBox= new JTextField(12);
		credBox.setEditable(false);

	//	credBox.setBorder(new EmptyBorder(10,10,10,10));
		
		p = new JPanel();
		p.add(credBox);
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(p);
		
		
		

	}
	

	public void setListModel(DefaultListModel<Module> listModel){
		this.listModel = listModel;
		list.setModel(listModel);
	}


	public DefaultListModel<Module> getListModel1() {
		return listModel;
	}
	
	public DefaultListModel<Module> getListModel2() {
		return listModel1;
	}
	 

	public void addModule(Module a) {
		listModel.addElement(a);
		
		list.setModel(listModel);
	}
	
	public void removemod1(Module a){
		listModel.removeElement(a);
		
		list.setModel(listModel);
	}
	
	public void removemod2(Module a){
		listModel1.removeElement(a);
		
		list1.setModel(listModel1);
	}

	public void addModule2_selected(Module a) {
	
		listModel1.addElement(a);
		
		list1.setModel(listModel1);
	}
	



	public boolean isItemSelected_unselectedlist() {

		return list.getSelectedIndex() != -1;
	}

	public boolean isItemSelected_selectedlist() {
	
		return list1.getSelectedIndex() != -1;
	}

	public Module getSelectedItem() {
		return list.getSelectedValue();
	}

	public Module getItemSelectedItem() {
		return list1.getSelectedValue();
	}


	public int getTotalCredit() {
		int creditTotal = 0;
	//	String tCredit = a;
		
		for(int i=0; i < listModel1.getSize(); i++) {
			
			creditTotal = creditTotal + listModel1.getElementAt(i).getCredits();
			}
			return creditTotal;
		}
		
	
	public void setTotalCredit(String a) {
		credBox.setText(a);
	}
		
		
		
	
	
	//clears all elements from the defaultlistmodel
	public void clearList() {
		listModel.clear();
	}
	
	public void ClearSelectModules() {
		listModel.clear();
	}
	
	public void ClearUnSelectedModules() {
		listModel1.clear();
	}

	//these methods allow listeners to be externally attached to this view
	public void addAddListener(ActionListener al) {
		addBtn.addActionListener(al);
	}

	public void addResetListener(ActionListener al) {
		resBtn.addActionListener(al);
	}

	public void addRemoveListener(ActionListener al) {
		remBtn.addActionListener(al);
	}

	public void addSubmitListener(ActionListener al) {
		subBtn.addActionListener(al);
	}

//	public void addCreditListener(ActionListener al) {
//		credBox.addActionListener(al);
//	}

}

