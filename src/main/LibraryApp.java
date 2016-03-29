package main;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.Record;
import model.Register;
import model.XmlDatabase;
import service.XmlDAO;

public class LibraryApp {

	private static final String FILE = "./database.xml";

	public static void main(String[] args) {

		// INSTANTIATE OBJECTS

		File file = new File(FILE);

		XmlDatabase xmlDatabase = new XmlDatabase();

		XmlDAO dao = new XmlDAO();

		Record record = new Record();
		Register register = new Register();
		List<Record> records = new LinkedList<Record>();
		List<Register> registers = new LinkedList<Register>();

		// initial code to add to DB
		/*
		 * register.setRollNo(1); register.setFirstName("gmail");
		 * register.setLastName("dsouza"); register.setEmail("dude@gmail.com");
		 * 
		 * XmlDAO dao = new XmlDAO(); if(dao.addRegister(registers, register,
		 * xmlDatabase)){
		 * 
		 * 
		 * } else{ System.out.println("ERROR IN ADD REGISTER"); }
		 * 
		 * record.setBookId(200); record.setBookName("HARRY POTTER");
		 * 
		 * SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy"); String
		 * issue = "31-08-2015"; String ret = "30-09-2015"; try { Date idate =
		 * sdf.parse(issue); Date rdate = sdf.parse(ret);
		 * record.setIssueDate(idate); record.setReturnDate(rdate);
		 * 
		 * } catch (ParseException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 * 
		 * 
		 * if(dao.addRecord(records, record, xmlDatabase)){
		 * 
		 * 
		 * } else{ System.out.println("ERROR IN ADD REGISTER"); }
		 * 
		 * 
		 */
		// UNMARSHALL XML TO OBJECT - GET DATA FROM DB
		
		//JAXBContext context;
		//try {
			// context = JAXBContext.newInstance(XmlDatabase.class);

			// Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();

			// xmlDatabase = (XmlDatabase) jaxbUnmarshaller.unmarshal(file);

			xmlDatabase = dao.getXmlDatabase(xmlDatabase, file);
			dao.displayXmlDatabaseInConsole(xmlDatabase, file);
			
			
			records = xmlDatabase.getRecords();

			registers = xmlDatabase.getRegisters();

			Iterator<Record> i = records.iterator();
			while (i.hasNext()) {
				Record r = i.next();
				System.out.println("id:" + r.getBookId() + "\tname:" + r.getBookName() + "\tIssued:" + r.getIssueDate()
						+ "\treturn:" + r.getReturnDate() + "\trollNo:" + r.getRollNo());

			}

			Iterator<Register> j = registers.iterator();
			while (j.hasNext()) {
				Register r = j.next();
				System.out.println("Firstname:" + r.getFirstName() + "\tLastname:" + r.getLastName() + "\tRollNo:"
						+ r.getRollNo() + "\tEmail:" + r.getEmail());

			}

			// THIS SNIPPET WILL COME IN CONTROLLER
			/*
			 * register.setRollNo(1); register.setFirstName("gmail");
			 * register.setLastName("dsouza");
			 * register.setEmail("dude@gmail.com");
			 * 
			 * 
			 * XmlDAO dao = new XmlDAO(); if(dao.addRegister(registers,
			 * register, xmlDatabase)){
			 * 
			 * 
			 * } else{ System.out.println("ERROR IN ADD REGISTER"); }
			 * 
			 * 
			 * 
			 * 
			 * 
			 * record.setBookId(200); record.setBookName("HARRY POTTER");
			 * 
			 * SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy"); String
			 * issue = "31-08-2015"; String ret = "30-09-2015"; try { Date idate =
			 * sdf.parse(issue); Date rdate = sdf.parse(ret);
			 * record.setIssueDate(idate); record.setReturnDate(rdate);
			 * 
			 * } catch (ParseException e1) { // TODO Auto-generated catch block
			 * e1.printStackTrace(); }
			 * 
			 * 
			 * if(dao.addRecord(records, record, xmlDatabase)){
			 * 
			 * 
			 * } else{ System.out.println("ERROR IN ADD REGISTER"); }
			 *
			 * 
			 * 
			 */
			
			

		//} catch (JAXBException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}

	}

}
