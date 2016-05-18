package com.johndeere.domain;

import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.johndeere.domain.file.CsvFile;
import com.johndeere.domain.file.TxtFile;
import com.johndeere.domain.logger.Logger;
import com.johndeere.domain.objects.Account;
import com.johndeere.domain.objects.Contact;
import com.johndeere.domain.objects.Dealer;
import com.johndeere.domain.objects.DealerPreOffer;
import com.johndeere.domain.objects.Group;
import com.johndeere.domain.objects.GrowerDealerAssociation;
import com.johndeere.domain.objects.PreOffer;
import com.johndeere.domain.objects.SellingTermToOffer;
import com.johndeere.domain.objects.StaffPermission;
import com.johndeere.domain.objects.Tax;
import com.johndeere.domain.objects.UserToGroup;
import com.johndeere.tests.CompleteDealerAccountSetupWorkflowTest;
import com.johndeere.tests.CreateAccountTest;
import com.johndeere.tests.CreateContactTest;
import com.johndeere.tests.CreateGroupTest;
import com.johndeere.tests.CreateGrowerDealerAssociationTest;
import com.johndeere.tests.CreatePreOfferTest;
import com.johndeere.tests.CreateSellingTermToOfferTest;
import com.johndeere.tests.CreateStaffPermissionTest;
import com.johndeere.tests.CreateTaxTest;
import com.johndeere.tests.CreateUserToGroupTest;
import com.johndeere.tests.PublishOfferTest;

public abstract class GeneralRecord {		
	
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	protected CsvFile csvFile = CsvFile.getInstance();	
	protected Logger logger = Logger.getInstance();
	protected TxtFile txtFile = TxtFile.getInstance(); 
	@SuppressWarnings("rawtypes")
	protected ArrayList records = new ArrayList();

	
	//Accounts
	protected Account account = Account.getInstance();
	protected CreateAccountTest cat = CreateAccountTest.getInstance();
	
	//Taxes
	protected Tax tax = Tax.getInstance();
	protected CreateTaxTest ctt = CreateTaxTest.getInstance();
	
	//Contacts
	protected Contact contact = Contact.getInstance();;
	protected CreateContactTest cct = CreateContactTest.getInstance();
	
	//Staff Permission
	protected StaffPermission staffPermission = StaffPermission.getInstance();;
	protected CreateStaffPermissionTest cspt = CreateStaffPermissionTest.getInstance();
	
	//Grower Dealer Association
	protected GrowerDealerAssociation gda = GrowerDealerAssociation.getInstance();
	protected CreateGrowerDealerAssociationTest cgdat = CreateGrowerDealerAssociationTest.getInstance();
	
	//Groups
	protected Group group = Group.getInstance();
	protected CreateGroupTest cgt = CreateGroupTest.getInstance();
	
	//User to Group
	protected UserToGroup userToGroup = UserToGroup.getInstance();
	protected CreateUserToGroupTest cutgt = CreateUserToGroupTest.getInstance();
	
	//Pre Offers
	protected PreOffer preOffer = PreOffer.getInstance();
	protected CreatePreOfferTest cpot = CreatePreOfferTest.getInstance();
	
	//Selling Term to Offer
	protected SellingTermToOffer sellingTermToOffer = SellingTermToOffer.getInstance();
	protected CreateSellingTermToOfferTest csttot = CreateSellingTermToOfferTest.getInstance();
	
	//Dealer
	protected Dealer dealer = Dealer.getInstance();
	protected CompleteDealerAccountSetupWorkflowTest cdaswt = CompleteDealerAccountSetupWorkflowTest.getInstance();
	
	//DealerPreOffer
	protected DealerPreOffer dealerPreOffer = DealerPreOffer.getInstance();
	protected PublishOfferTest pot = PublishOfferTest.getInstance();
			
	//CSV Input File
	protected CsvReader reader;
		
	//Counts
	protected int totalCount = 0;
	protected int passCount = 0;
	protected int failCount = 0;
	
	
	//---------------------------------------------
	//FUNCTIONS
	//---------------------------------------------
	/**
	 * Function to load Records input file 
	 * @param executionType - (String) This is the execution type, example: Test Class, Base execution
	 * @param object - (String) This is the object record that we are creating
	 * @param person - (String) QA that is executing the test data generator
	 * @throws Exception
	 */
	protected void loadInputFile(String executionType, String object, String person) throws Exception{
		
		reader = new CsvReader(csvFile.loadInputFile(executionType, object, person));
		
		//Read header
		reader.readHeaders();
		reader.setDelimiter(';');
		
	}
	
	/**
	 * Function to load class variables
	 * @param object - (String) This is the object record that we are creating
	 * @throws Exception
	 */
	protected void loadRecordVariables(String object) throws Exception{
		
		if(object.equals("Accounts")){
			
			account.loadVariables(reader);
			
		}
		
		if(object.equals("Taxes")){
			
			tax.loadVariables(reader);
			
		}
		
		if(object.equals("Contacts")){
			
			contact.loadVariables(reader);
			
		}
		
		if(object.equals("Staff Permission")){
			
			staffPermission.loadVariables(reader);
			
		}
		
		if(object.equals("Grower Dealer Association")){
			
			gda.loadVariables(reader);
			
		}
		
		if(object.equals("Groups")){
			
			group.loadVariables(reader);
			
		}
		
		if(object.equals("User to Group")){
			
			userToGroup.loadVariables(reader);
			
		}
		
		if(object.equals("Pre Offers")){
			
			preOffer.loadVariables(reader);
			
		}
		
		if(object.equals("Selling Term to Offer")){
			
			sellingTermToOffer.loadVariables(reader);
			
		}
		
		if(object.equals("Complete Dealer Account Setup")){
			
			dealer.loadVariables(reader);
			
		}
		
		if(object.equals("Publish Pre Offers")){
			
			dealerPreOffer.loadVariables(reader);
			
		}
		
	}
		
	/**
	 * Function to create a record
	 * @param object - (String) This is the object record that we are creating
	 */
	protected boolean createRecord(String object) throws Exception{
		
		boolean result = true;
		
		if(object.equals("Accounts")){
			
			//Generate log title
			logger.generateTitle(totalCount, object, account.getAccountName());
			result = cat.createAccount(account, logger);
			
		}
		
		if(object.equals("Taxes")){
			
			//Generate log title
			logger.generateTitle(totalCount, object, tax.getDescription() + " for account " + tax.getDealerAccount());
			result = ctt.createTax(tax, logger);
			
		}
		
		if(object.equals("Contacts")){
			
			//Generate log title
			logger.generateTitle(totalCount, object, contact.getFirstName() + " " + contact.getLastName());
			result = cct.createContact(contact, logger);
			
		}
		
		if(object.equals("Staff Permission")){
			
			//Generate log title
			logger.generateTitle(totalCount, object, staffPermission.getContactName() + " " + staffPermission.getPermissionOnAccount());
			result = cspt.createStaffPermission(staffPermission, logger);
			
		}
		
		if(object.equals("Grower Dealer Association")){
			
			//Generate log title
			logger.generateTitle(totalCount, object, gda.getDealerAccountName() + " - " + gda.getGrowerAccountName());
			result = cgdat.createGrowerDealerAssociation(gda, logger);
			
		}
		
		if(object.equals("Groups")){
			
			//Generate log title
			logger.generateTitle(totalCount, object, group.getGroupLabel());
			result = cgt.createGroup(group, logger);
			
		}
		
		if(object.equals("User to Group")){
			
			//Generate log title
			logger.generateTitle(totalCount, object, userToGroup.getGroupName() + " - " + userToGroup.getUser());
			result = cutgt.createUserToGroup(userToGroup, logger);
			
		}
		
		if(object.equals("Pre Offers")){
			
			//Generate log title
			logger.generateTitle(totalCount, object, preOffer.getPreOfferName());
			result = cpot.createPreOffer(preOffer, logger);
			
		}
		
		if(object.equals("Selling Term to Offer")){
			
			logger.generateTitle(totalCount, object, sellingTermToOffer.getPreOfferName() + " - " + sellingTermToOffer.getSellingTerm());
			result = csttot.createSellingTermToOffer(sellingTermToOffer, logger);
			
		}
		
		if(object.equals("Complete Dealer Account Setup")){
			
			logger.generateTitle(totalCount, object, dealer.getContactName());
			result = cdaswt.completeDealerAccountSetupWorkflow(dealer, logger);
			
		}
		
		if(object.equals("Publish Pre Offers")){
			
			logger.generateTitle(totalCount, object, dealerPreOffer.getContactName() + " - " + dealerPreOffer.getPreOfferName());
			result = pot.publishOffer(dealerPreOffer, logger);
			
		}
		
		return result;
		
	}
	
	/**
	 * Adding failed record to Array that will be converted to the failed scenarios file
	 * @param object - (String) This is the object record that we are creating
	 */
	@SuppressWarnings("unchecked")
	protected void addFailedRecordToArray(String object){
	
		if(object.equals("Accounts")){
			Account accountToSave = new Account(account.getAccountType(), account.getAccountName(), account.getParentAccount(), account.getStreet(), account.getCity(), account.getState(), account.getPostalCode(), account.getRegion(), account.getCountry(), account.getSupportPhone(), account.getSupportEmail(), account.getBillingEmail(), account.getAccountOwner(), account.getEnableAsPartner(), account.getMJDOrgId(), account.getLatitude(), account.getLongitude(), account.getTaxExemptionCertificateId());
			records.add(accountToSave);
			
		}
		
		if(object.equals("Taxes")){
			
			Tax taxToSave = new Tax(tax.getDealerAccount(), tax.getStateProvince(), tax.getPercentToCharge(), tax.getDescription(), tax.getCountry());
			records.add(taxToSave);
			
		}
		
		if(object.equals("Contacts")){
			Contact contactToSave = new Contact(contact.getAccountName(), contact.getContactType(), contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPartnerType(), contact.getUsername(), contact.getNickname(), contact.getUserLicense(), contact.getProfile(), contact.getApptusCpqMarkPermission(), contact.getApttusCpqUserPermission(), contact.getApptusCpqMarkV1Permission());
			records.add(contactToSave);
			
		}
		
		if(object.equals("Staff Permission")){
			
			StaffPermission staffPermissionToSave = new StaffPermission(staffPermission.getContactName(), staffPermission.getPermissionType(), staffPermission.getPermissionOnAccount(), staffPermission.getRole());
			records.add(staffPermissionToSave);
			
		}
		
		if(object.equals("Grower Dealer Association")){
			
			GrowerDealerAssociation gdaToSave = new GrowerDealerAssociation(gda.getAssociationType(), gda.getGrowerAccountName(), gda.getDealerAccountName(), gda.getRelationshipType());
			records.add(gdaToSave);
			
		}
		
		if(object.equals("Groups")){
			
			Group groupToSave = new Group(group.getGroupLabel(), group.getGroupName(), group.getUser(), group.getSynch());
			records.add(groupToSave);
			
		}
		
		if(object.equals("User to Group")){
			
			UserToGroup userToGroupToSave = new UserToGroup(userToGroup.getGroupName(), userToGroup.getUser());
			records.add(userToGroupToSave);
			
		}
		
		if(object.equals("Pre Offers")){
			
			PreOffer preOfferToSave = new PreOffer(preOffer.getPreOfferName(), preOffer.getPreOfferType(), preOffer.getCountry(), preOffer.getRegion(), preOffer.getStartDate(), preOffer.getEndDate(), preOffer.getIconUrl(), preOffer.getScreenshot1(), preOffer.getScreenshot2(), preOffer.getScreenshot3(), preOffer.getProduct(), preOffer.getCost(), preOffer.getFrequency(), preOffer.getSellingTerm(), preOffer.getMdpPrice(), preOffer.getMsrp(), preOffer.getStartOfQuantity(), preOffer.getEndOfQuantity(), preOffer.getGroupName());
			records.add(preOfferToSave);
			
		}
		
		if(object.equals("Selling Term to Offer")){
			
			SellingTermToOffer sellingTermToOfferToSave = new SellingTermToOffer(sellingTermToOffer.getPreOfferName(), sellingTermToOffer.getSellingTerm(), sellingTermToOffer.getMdpPrice(), sellingTermToOffer.getMsrp(), sellingTermToOffer.getStartOfQuantity(), sellingTermToOffer.getEndOfQuantity());
			records.add(sellingTermToOfferToSave);
			
		}
		
		if(object.equals("Complete Dealer Account Setup")){
			
			Dealer dealerToSave = new Dealer(dealer.getContactName());
			records.add(dealerToSave);
			
		}
		
		if(object.equals("Publish Pre Offers")){
			
			DealerPreOffer dealerPreOfferToSave = new DealerPreOffer(dealerPreOffer.getContactName(), dealerPreOffer.getPreOfferName());
			records.add(dealerPreOfferToSave);
			
		}
		
	}
	
	/**
	 * Function to create failed scenarios file
	 * @param object - (String) This is the object record that we are creating
	 */
	protected void createFailedScenariosFile(String object){
		
		if(object.equals("Accounts")){
			
			account.createFailedScenariosFile(records, object);
			
		}
		
		if(object.equals("Taxes")){
			
			tax.createFailedScenariosFile(records, object);
			
		}
		
		if(object.equals("Contacts")){
			
			contact.createFailedScenariosFile(records, object);
			
		}
		
		if(object.equals("Staff Permission")){
			
			staffPermission.createFailedScenariosFile(records, object);
			
		}
		
		if(object.equals("Grower Dealer Association")){
			
			gda.createFailedScenariosFile(records, object);
			
		}
		
		if(object.equals("Groups")){
			
			group.createFailedScenariosFile(records, object);
			
		}
		
		if(object.equals("User to Group")){
			
			userToGroup.createFailedScenariosFile(records, object);
			
		}
		
		if(object.equals("Pre Offers")){
			
			preOffer.createFailedScenariosFile(records, object);
			
		}
		
		if(object.equals("Selling Term to Offer")){
			
			sellingTermToOffer.createFailedScenariosFile(records, object);
			
		}
		
		if(object.equals("Complete Dealer Account Setup")){
			
			dealer.createFailedScenariosFile(records, object);
			
		}
		
		if(object.equals("Publish Pre Offers")){
			
			dealerPreOffer.createFailedScenariosFile(records, object);
			
		}
		
	}
	
	/**
	 * Function to reset variables 
	 */
	protected void resetVariables(String object){
		
		totalCount = 0;
		passCount = 0;
		failCount = 0;
		records.clear();
		
	}
	
	/**
	 * Function to close browser
	 * @param object - (String) This is the object record that we are creating
	 */
	protected void closeBrowser(String object){
	
		if(object.equals("Accounts")){
			
			cat.closeDriver(logger);
			
		}
		
		if(object.equals("Taxes")){
			
			ctt.closeDriver(logger);
			
		}
		
		if(object.equals("Contacts")){
			
			cct.closeDriver(logger);
			
		}
		
		if(object.equals("Staff Permission")){
			
			cspt.closeDriver(logger);
			
		}
		
		if(object.equals("Grower Dealer Association")){
			
			cgdat.closeDriver(logger);
			
		}
		
		if(object.equals("Groups")){
			
			cgt.closeDriver(logger);
			
		}
		
		if(object.equals("User to Group")){
			
			cutgt.closeDriver(logger);
			
		}
		
		if(object.equals("Pre Offers")){
			
			cpot.closeDriver(logger);
			
		}
		
		if(object.equals("Selling Term to Offer")){
			
			csttot.closeDriver(logger);
			
		}
		
		if(object.equals("Complete Dealer Account Setup")){
			
			cdaswt.closeDriver(logger);
			
		}
		
		if(object.equals("Publish Pre Offers")){
			
			pot.closeDriver(logger);
			
		}
		
	}
	
	/**
	 * Function to generate status message
	 * @return - (String) General Status of execution
	 */
	protected String generateMessage(String object){
		
		if(failCount == 0){
			
			return "EXECUTION COMPLETED!!!\n\n All records were created\n";
			
		}else{
			
			return "Execution COMPLETED!!!\n\n" + passCount + " / " + totalCount + " records were created\n\nPlease check log in the following path:\n\nC:\\\\Automation\\Logs\\" + object + "\n";
			
		}
		
	}
	
}