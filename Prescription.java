package cs157b_hw1;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author davidhurng
 *
 * Prescription Class is value object
 * Show one line of medication name and doctor who prescribed it
 */

@Entity
public class Prescription {

	@Id
	@GeneratedValue
	@Column (name = "PRESCRIPTION_ID")
	private int prescID;
	
	@Column (name = "MEDICATION")
	private String prescName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PATIENT_ID")
	private Patient patient;
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public int getPrescID() {
		return prescID;
	}

	public void setPrescID(int prescID) {
		this.prescID = prescID;
	}

	public String getPrescName() {
		return prescName;
	}

	public void setPrescName(String prescName) {
		this.prescName = prescName;
	}
}
