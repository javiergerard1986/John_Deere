package com.johndeere.ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import com.johndeere.businesslogic.Facade;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class UInterface {

	//----------------------------------------
	//ATRIBUTES
	//----------------------------------------
	private Facade facade = Facade.getInstance();
	private ArrayList<String> objects = new ArrayList<String>();
	
	private JFrame frmDataGeneratorV;
	private JLabel lblEnvironment;
	private JComboBox<String> cmbEnvironment;
	private JLabel lblBuild;
	private JComboBox<String> cmbBuild;
	private JLabel lblSelectObject;
	private JComboBox<String> cmbSelectObject;
	private JLabel lblExecutionType;
	private JLabel lblSelectPerson;
	private JComboBox<String> cmbPersons;
	private JComboBox<String> cmbExecutionType;
	private JButton btnCreateData;
	
	
	//----------------------------------------
	//CONSTRUCTORS
	//----------------------------------------
	/**
	 * Create the application.
	 */
	public UInterface() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmDataGeneratorV = new JFrame();
		frmDataGeneratorV.getContentPane().setBackground(new Color(152, 251, 152));
		frmDataGeneratorV.getContentPane().setLayout(null);
		
		//Define and load environment
		this.lblEnvironment = new JLabel("Select environment");
		this.lblEnvironment.setFont(new Font("Tahoma", Font.BOLD, 13));
		this.lblEnvironment.setBounds(91, 11, 153, 14);
		frmDataGeneratorV.getContentPane().add(this.lblEnvironment);
		
		this.cmbEnvironment = new JComboBox<String>();
		this.cmbEnvironment.setBounds(91, 33, 153, 20);
		frmDataGeneratorV.getContentPane().add(this.cmbEnvironment);
		
		this.loadEnvironments();
		
		
		//Define and load builds
		this.lblBuild = new JLabel("Select build");
		this.lblBuild.setFont(new Font("Tahoma", Font.BOLD, 13));
		this.lblBuild.setBounds(91, 64, 153, 14);
		frmDataGeneratorV.getContentPane().add(this.lblBuild);

		this.cmbBuild = new JComboBox<String>();
		this.cmbBuild.setBounds(91, 89, 153, 20);
		frmDataGeneratorV.getContentPane().add(this.cmbBuild);
		
		this.loadBuilds();
		
		
		//Define and load objects to create
		this.lblSelectObject = new JLabel("Select object to create");
		this.lblSelectObject.setFont(new Font("Tahoma", Font.BOLD, 13));
		this.lblSelectObject.setBounds(91, 179, 153, 14);
		frmDataGeneratorV.getContentPane().add(this.lblSelectObject);
		
		this.cmbSelectObject = new JComboBox<String>();
		this.cmbSelectObject.setBounds(91, 201, 153, 20);
		frmDataGeneratorV.getContentPane().add(this.cmbSelectObject);
		
		this.loadObjectsToCreate();
		
		this.loadObjectIntoArray();
		
		//Define and load execution type
		this.lblExecutionType = new JLabel("Execution Type");
		this.lblExecutionType.setFont(new Font("Tahoma", Font.BOLD, 13));
		this.lblExecutionType.setBounds(91, 235, 153, 14);
		frmDataGeneratorV.getContentPane().add(this.lblExecutionType);
		
		this.cmbExecutionType = new JComboBox<String>();
		this.cmbExecutionType.setBounds(91, 260, 153, 20);
		frmDataGeneratorV.getContentPane().add(this.cmbExecutionType);
		
		this.loadExecutionTypes();
		
		
		
		//Create data button
		this.btnCreateData = new JButton("Create Data");
		btnCreateData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				createData();
				
			}
		});
		
		this.btnCreateData.setFont(new Font("Tahoma", Font.BOLD, 13));
		this.btnCreateData.setBounds(91, 302, 153, 37);
		frmDataGeneratorV.getContentPane().add(this.btnCreateData);
		
		this.lblSelectPerson = new JLabel("Select Person");
		this.lblSelectPerson.setFont(new Font("Tahoma", Font.BOLD, 13));
		this.lblSelectPerson.setBounds(91, 120, 153, 14);
		frmDataGeneratorV.getContentPane().add(this.lblSelectPerson);
		
		this.cmbPersons = new JComboBox<String>();
		this.cmbPersons.setBounds(91, 145, 153, 20);
		frmDataGeneratorV.getContentPane().add(this.cmbPersons);
		
		this.loadPersons();
		
		
		
		frmDataGeneratorV.setTitle("John Deere - Data Generator");
		frmDataGeneratorV.setBounds(100, 100, 342, 411);
		frmDataGeneratorV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	
	//----------------------------------------
	//FUNCTIONS
	//----------------------------------------
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UInterface window = new UInterface();
					window.frmDataGeneratorV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Function to load environments 
	 */
	public void loadEnvironments(){
		
		this.cmbEnvironment.addItem("QA");
		this.cmbEnvironment.addItem("DEV");
		
	}
	
	/**
	 * Function to load builds 
	 */
	public void loadBuilds(){
		
		this.cmbBuild.addItem("Build 16");
		this.cmbBuild.addItem("Build 15");
		this.cmbBuild.addItem("Build 14");
		
	}
	
	/**
	 * Function to load object 
	 */
	public void loadObjectsToCreate(){
		
		this.cmbSelectObject.addItem("Accounts");
		this.cmbSelectObject.addItem("Taxes");
		this.cmbSelectObject.addItem("Contacts");
		this.cmbSelectObject.addItem("Staff Permission");
		this.cmbSelectObject.addItem("Grower Dealer Association");
		this.cmbSelectObject.addItem("Groups");
		this.cmbSelectObject.addItem("User to Group");
		this.cmbSelectObject.addItem("Pre Offers");
		this.cmbSelectObject.addItem("Selling Term to Offer");
		this.cmbSelectObject.addItem("Complete Dealer Account Setup");
		this.cmbSelectObject.addItem("Publish Pre Offers");
		
	}
	
	/**
	 * Function to load execution types 
	 */
	public void loadExecutionTypes(){
	
		this.cmbExecutionType.addItem("Base Execution");
		this.cmbExecutionType.addItem("Failed Execution");
		this.cmbExecutionType.addItem("Test Class");

	}
	
	/**
	 * Function to load persons
	 */
	public void loadPersons(){
		
		this.cmbPersons.addItem("Javier");
		this.cmbPersons.addItem("Vinod");
		
	}
	
	/**
	 * Function to create data 
	 */
	public void createData(){
			
		//String environment = this.cmbEnvironment.getSelectedItem().toString();
		//String build = this.cmbBuild.getSelectedItem().toString();
		
		String object = this.cmbSelectObject.getSelectedItem().toString();
		String executionType = this.cmbExecutionType.getSelectedItem().toString();
		String person = this.cmbPersons.getSelectedItem().toString();
		
		facade.createPreRequisites(objects);
		
		JOptionPane.showMessageDialog(frmDataGeneratorV, facade.createRecords(executionType, object, person));
		
	}

	/**
	 * Function to load objects to crate into array
	 */
	public void loadObjectIntoArray(){
		
		for(int x = 0; x < this.cmbSelectObject.getItemCount(); x++){
			
			objects.add(this.cmbSelectObject.getItemAt(x).toString());
			
		}

	}
	
}