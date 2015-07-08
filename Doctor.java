package cs157b_hw1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * 
 * @author davidhurng
 * 
 * Doctor Class
 * Shows doctor name and their speciality 
 */

@Entity
public class Doctor extends Person {
	//@Id 
	@GeneratedValue
	@Column (name = "DOCTOR_ID")
	private int docID;  
	@Column (name = "DOCTOR_NAME")
	private String name;
	@Column (name = "SPECIALITY")
	private String speciality;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "join_table",
				joinColumns = {@JoinColumn(name = "doctor_id")},
				inverseJoinColumns = {@JoinColumn(name = "patient_id")}
	)
	private List<Patient> patients;

	public Doctor() 
	{
		patients = new ArrayList<Patient>();
	}
	
	public int getDocID() {
		return docID;
	}

	public void setDocID(int docID) {
		this.docID = docID;
	}

	public String getName() {
		return "Dr. " + name;
	}

	public void setName(String name) {
		this.name = "Dr. " + name;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(Patient patients) {
		this.patients.add(patients);
	}
}
