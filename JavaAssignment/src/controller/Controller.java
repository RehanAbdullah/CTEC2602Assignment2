package controller;


import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import view.CreateProfilePanel;
import view.Frame;
import view.MyMenuBar;
import view.OverviewResultsPanel;
import view.SelectModules;
import model.Course;
import model.Module;
import model.StudentProfile;

public class Controller {

	private CreateProfilePanel profilePnl;
	private MenuBar menuBar;
	private OverviewResultsPanel overviewPnl;
	private SelectModules selectMod;
	private StudentProfile model;
	private Frame view;
	int credit = 0;

	public Controller(Frame view, StudentProfile model) {
		this.view = view;
		this.model = model;

		profilePnl = view.getCreateProfilePanel();
		menuBar = view.getMenuBar();
		selectMod = view.getSelectModules();
		overviewPnl = view.getOverviewResultsPanel();
		model = view.getStudentProfile();
		view = view.getFrame();

		profilePnl.populateComboBox(setupAndGetCourses());

		//		profilePnl.addCourseListener(new CourseHandler());
		profilePnl.addCreateProfileListener(new createButtonHandler());


		//add listeners to the view
		selectMod.addAddListener(new AddButtonHandler());
		selectMod.addRemoveListener(new RemoveButtonHandler());
		selectMod.addSubmitListener(new subButtonHandler() );
		selectMod.addResetListener(new ResetButtonHandler() );
		// profilePnl.populateComboBox(setupCreateProfile());	

		//Save overview Handler
		overviewPnl.addSaveListener(new SaveButtonHandler());
		
		//credit Handler
	//	selectMod.addCreditListener(new CreditListener());
		

	}
	private Course[] setupAndGetCourses() {

		Module ctec3903 = new Module("CTEC3903", "Software Development Methods", 15, true); 
		Module imat3451 = new Module("IMAT3451", "Computing Project", 30, true);
		Module ctec3902_SoftEng = new Module("CTEC3902", "Rigerous Systems", 15, true); 
		Module ctec3902_CompSci = new Module("CTEC3902", "Rigerous Systems", 15, false); 
		Module ctec3110 = new Module("CTEC3110", "Secure Web Application Development", 15,false);

		Module ctec3426 = new Module("CTEC3426", "Telematics", 15, false);
		Module ctec3604 = new Module("CTEC3604", "Multi-service Networks", 30, false); 
		Module imat3404 = new Module("IMAT3404", "Mobile Robotics", 15, false);
		Module imat3406 = new Module("IMAT3406", "Fuzzy Logic and Knowledge Based systems",15, false);

		Module imat3429 = new Module("IMAT3429", "Privacy and Data Protection", 15, false);
		Module imat3608 = new Module("IMAT3608", "Mobile Games Development", 30, false); 
		Module imat3426_CompSci = new Module("IMAT3426","Information Systems Strategy and Services", 30, false);

		Course compSci = new Course("Computer Science");
		compSci.addModule(ctec3903); 
		compSci.addModule(imat3451); 
		compSci.addModule(ctec3902_CompSci); 
		compSci.addModule(ctec3110); 
		compSci.addModule(ctec3426); 
		compSci.addModule(ctec3604); 
		compSci.addModule(imat3404); 
		compSci.addModule(imat3406); 
		compSci.addModule(imat3429); 
		compSci.addModule(imat3608);
		compSci.addModule(imat3426_CompSci);

		Course softEng = new Course("Software Engineering"); 
		softEng.addModule(ctec3903); 
		softEng.addModule(imat3451); 
		softEng.addModule(ctec3902_SoftEng);
		softEng.addModule(ctec3110); 
		softEng.addModule(ctec3426); 
		softEng.addModule(ctec3604); 
		softEng.addModule(imat3404); 
		softEng.addModule(imat3406); 
		softEng.addModule(imat3429); 
		softEng.addModule(imat3608);

		Course[] courses = new Course[2]; 
		courses[0] = compSci;
		courses[1] = softEng;

		return courses;
	}

	private class createButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("create profile");
			view.changeTab(1);
			selectMod.setListModel(setUp());
			
			



			String fN = profilePnl.getFNameInput();
			String lN = profilePnl.getLNameInput();
			String pNo =profilePnl.gettxtPNo();
			
			Course course = profilePnl.getSelectedCourse();
			LoadModules(course.getModulesOnCourse());
			
//			for (Module m: course.getModulesOnCourse()) {
//				if (m.isMandatory())
//					selectMod.addModule2_selected(m);
//				else selectMod.addModule(m);
//				
//					
//			}
			
			
		}
	} 

	public DefaultListModel<Module> setUp(){
		selectMod.getListModel1().removeAllElements();
		DefaultListModel<Module> list = new DefaultListModel<Module>();

		Course y = profilePnl.getSelectedCourse();

		for(Module s : y.getModulesOnCourse()){
			list.addElement(s);
		}

		return list;
	}

	private class AddButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//retrieves name from view


			System.out.println("ADD button");

			if(selectMod.isItemSelected_unselectedlist()){
				selectMod.addModule2_selected(selectMod.getSelectedItem());

				credit += selectMod.getSelectedItem().getCredits();
				selectMod.setTotalCredit(Integer.toString(credit));
			}
		}
	}

	private class RemoveButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			System.out.println("remove button");

			if(selectMod.isItemSelected_selectedlist()){
				selectMod.removemod2(selectMod.getItemSelectedItem());
				selectMod.addModule(selectMod.getItemSelectedItem());
				
				
//		//		credit -= selectMod.getItemSelectedItem().getCredits();
//				selectMod.setTotalCredit(Integer.toString(credit));
				
				

			}
		}

	}

	private class subButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			System.out.println("submit button");

			String name = profilePnl.getFNameInput()+ "\n" + profilePnl.getLNameInput();
			String pNum = profilePnl.gettxtPNo() + "\n";
			String course = profilePnl.getSelectedCourse().toString();
			String module = "\n\nSelected Modules: \n\n";

			for(int i = 0; i < selectMod.getListModel2().getSize(); i++) {
				Module a = selectMod.getListModel2().getElementAt(i);
				module = module + a.toString() + "\n";
			}

			view.changeTab(2);

			overviewPnl.setOverview(null);
			overviewPnl.getOverview().setText(name + "\n" + pNum + "\n" + course + "\n" + module + "\n");


		}
	}

	private class ResetButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			System.out.println("reset button");
			
//			selectMod.ClearSelectModules();
//			selectMod.ClearUnSelectedModules();
//			LoadModules(model.getCourse().getModulesOnCourse());
//			model.clearSelectedModules();

			
			selectMod.getListModel1().removeAllElements();

			selectMod.getListModel2().removeAllElements();
			selectMod.setListModel(setUp());
			
			

		}
	}

	private class SaveButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			//trial
			System.out.println("File is saved!");


			//save the data model
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("journeyObj.dat"));) {

				oos.writeObject(model);
				oos.flush();
			}
			catch (IOException ioExcep){
				System.out.println("Error saving");
			}
		}
	}
	

public void LoadModules(Collection<Module> modules) {
	

	for (Module m: modules) 
		if (m.isMandatory())
			selectMod.addModule2_selected(m);
		else selectMod.addModule(m);
		
	
}


}













