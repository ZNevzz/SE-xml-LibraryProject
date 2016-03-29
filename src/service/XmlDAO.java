package service;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.*;


public class XmlDAO {
	
	private static final String FILE = "./database.xml";
	JAXBContext context;
	
	public boolean addRegister(List<Register> registers,Register register,XmlDatabase xmlDatabase){
		
		boolean success=false;
		
		registers.add(register);
		xmlDatabase.setRegisters(registers);
		
		try{
			context = JAXBContext.newInstance(XmlDatabase.class);
			Marshaller m= context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
			m.marshal(xmlDatabase,System.out);
			m.marshal(xmlDatabase,new File(FILE));
			
			success=true;
		}
		catch(JAXBException e){
			
			
		}
		
		return success;
	}

	public boolean addRecord(List<Record> records,Record record,XmlDatabase xmlDatabase){
		
		boolean success=false;
		
		records.add(record);
		xmlDatabase.setRecords(records);
		
		try{
			context = JAXBContext.newInstance(XmlDatabase.class);
			Marshaller m= context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
			m.marshal(xmlDatabase,System.out);
			m.marshal(xmlDatabase,new File(FILE));
						
		}
		catch(JAXBException e){
			
			
		}
		
		return success;
	}
	
	
	public XmlDatabase getXmlDatabase(XmlDatabase xmlDatabase,File file){
		

		Record record = new Record();
		Register register = new Register();
		List<Record> records=new LinkedList<Record>();
		List<Register> registers=new LinkedList<Register>();
		
		try {
			context = JAXBContext.newInstance(XmlDatabase.class);

			Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();

			xmlDatabase = (XmlDatabase) jaxbUnmarshaller.unmarshal(file);
						
		}
		catch(JAXBException e){
			
			
		}

		return xmlDatabase;
	}
	
	public void displayXmlDatabaseInConsole(XmlDatabase xmlDatabase,File file){
		
		xmlDatabase=getXmlDatabase(xmlDatabase,file);
		try{
			context = JAXBContext.newInstance(XmlDatabase.class);
			Marshaller m= context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
			m.marshal(xmlDatabase,System.out);			
						
		}
		catch(JAXBException e){
			
			
		}
	}
}
