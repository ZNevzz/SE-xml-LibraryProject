package model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="record")
@XmlAccessorType(XmlAccessType.FIELD)
public class Record {
	
	@XmlElement
	private int rollNo;
	
	@XmlElement
	private String BookName;
	
	@XmlElement
	private Date issueDate;
	
	@XmlElement
	private Date returnDate;
	
	@XmlElement
	private int BookId;

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getBookId() {
		return BookId;
	}

	public void setBookId(int bookId) {
		BookId = bookId;
	}

	
	
	
	
	
}
