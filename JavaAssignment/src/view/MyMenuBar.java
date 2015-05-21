package view;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

import model.StudentProfile;

//note extending JMenuBar
public class MyMenuBar extends JMenuBar {

	private JMenuItem menuItem, exitItem,saveItem, loadItem, aboutItem;
	private StudentProfile model;
	private Frame view;

	public MyMenuBar() {  



		//		menuBar.addLoadListener(new LoadMenuHandler());
		//		menuBar.addSaveListener(new SaveMenuHandler());

		//temp vars for menus and menu items within this JMenuBar
		JMenu menu;


		//----------Build the first menu on the menu bar.--------------------
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);

		//define and add the 'Load' menu item
		loadItem = new JMenuItem("Load the data for the students");
		                                              loadItem.addActionListener(new LoadMenuHandler());

		loadItem.setMnemonic(KeyEvent.VK_L);
		loadItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		menu.add(loadItem);

		//create a group of JMenuItems
		//define and add the 'Open' menu item
//		menuItem = new JMenuItem("Open");
//		menu.add(menuItem);

		//'Save' menu item
		menuItem = new JMenuItem("Save Student Data");
		menu.add(menuItem);

		//...add a separator
		menu.addSeparator();

		//... add an 'Exit' item
		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(e -> System.exit(0));

		exitItem.setMnemonic(KeyEvent.VK_E);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		menu.add(exitItem);
		this.add(menu); //add the menu to this menubar;



//		//-------- Build the second menu--------------------------------------
//		//This shows that you can do this in a separate class.
//		menu = new JMenu("Name processing");
//
//		this.add(menu); //add the menu to this menu bar
//
//
//		saveItem = new JMenuItem("Save");
//	                              	saveItem.addActionListener(new SaveMenuHandler());   
//		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
//		saveItem.setMnemonic(KeyEvent.VK_S);
//		menu.add(saveItem);

		//----------Build the second menu on the menu bar.--------------------
		menu = new JMenu("Help");

		//'About' menu item
		aboutItem = new JMenuItem("About");
		aboutItem.setMnemonic(KeyEvent.VK_A);
		aboutItem.addActionListener((ActionEvent e) -> JOptionPane.showMessageDialog(null, "Journey App - Ver 1.1"));

		aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		menu.add(aboutItem);;

		this.add(menu); //add the menu to this menubar


		/* ADD FORTH MENU HERE */
		
		
		

	}

	/** void addAboutListener, add an action listener to the control.
	 * @param al, the action listener handler. */
	public void addExitListener(ActionListener al) {
		exitItem.addActionListener(al);
	}

	/** void addAboutListener, add an action listener to the control.
	 * @param al, the action listener handler. */
	public void addSaveListener(ActionListener al) {
		saveItem.addActionListener(al);
	}

	/** void addAboutListener, add an action listener to the control.
	 * @param al, the action listener handler. */
	public void addLoadListener(ActionListener al) {
		loadItem.addActionListener(al);
	}

	/** void addAboutListener, add an action listener to the control.
	 * @param al, the action listener handler. */
	public void addAboutListener(ActionListener al) {
		aboutItem.addActionListener(al);
	}


	//these named inner-class event handlers use the model and view references
	private class LoadMenuHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//load in the data model
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("journeyObj.dat"));) {

				model = (StudentProfile) ois.readObject();
			}
			catch (IOException ioExcep){
				System.out.println("Error loading");
			}
			catch (ClassNotFoundException c) {
				System.out.println("Class Not found");
			}


		}
	}

	private class SaveMenuHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {          
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



}
