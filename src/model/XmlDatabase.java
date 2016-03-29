package model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "model")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlDatabase {
	
	@XmlElementWrapper
	@XmlElement(name="Record")
	private List<Record> records;
	
	@XmlElementWrapper
	@XmlElement(name="Register")
	private List<Register> registers;

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

	public List<Register> getRegisters() {
		return registers;
	}

	public void setRegisters(List<Register> registers) {
		this.registers = registers;
	}
	
	
}
