package main;

//import controller.Controller;
import controller.Controller;

import model.StudentProfile;
import view.Frame;

public class ApplicationLoader {
	
	public static void main(String[] args) {
		
		Frame view = new Frame();
		StudentProfile mod = new StudentProfile();
		
		Controller cont = new Controller(view, mod);
		
	}

}
