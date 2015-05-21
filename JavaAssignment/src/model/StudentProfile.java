package model;

import java.util.Set;
import java.util.TreeSet;



public class StudentProfile {

	private String pNumber;
	private Name studentName;
	private Course course;
	private Set<Module> selectedModules;
	
	public StudentProfile() {
		pNumber = "";
		studentName = new Name();
		course = null;
		selectedModules = new TreeSet<Module>();
	}
	
	public String getpNumber() {
		return pNumber;
	}
	
	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}
	
	public Name getStudentName() {
		return studentName;
	}
	
	public void setStudentName(Name studentName) {
		this.studentName = studentName;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void Course(Course course) {
		this.course = course;
	}
	
	public boolean addSelectedModule(Module m) {
		return selectedModules.add(m);
	}
	
	public Set<Module> getSelectedModules() {
		return selectedModules;
	}
	
	public void clearSelectedModules() {
		selectedModules.clear();
	}
	
	@Override
	public String toString() {
		return "StudentProfile:[pNumber=" + pNumber + ", studentName="
				+ studentName + ", course=" + course.actualToString() 
				+ ", selectedModules=" + selectedModules + "]";
	}
	
}
