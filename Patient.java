package cs157b_hw1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
/**
 * 
 * @author davidhurng
 * 
 * Patient Class
 * Shows patient name, Date of Birth, scheduled appointments, and prescriptions
 */
@Entity
public class Patient extends Person{
	//@Id 
	@GeneratedValue
	@Column (name = "PATIENT_ID")
	private int patID;
	@Column (name = "PATIENT_NAME")
	private String name;
	@Column (name = "DATE_OF_BIRTH")
	private String BirthDate;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "join_table",
			 	joinColumns = {@JoinColumn(name="patient_id")},
			 	inverseJoinColumns = {@JoinColumn(name = "doctor_id")}
	)
	private List<Doctor> doctors;
	
	public Patient() 
	{
		doctors = new ArrayList<Doctor>();
	}

	public int getPatID() {
		return patID;
	}

	public void setPatID(int patID) {
		this.patID = patID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}

	public void setDoctors(Doctor doctors) {
		this.doctors.add(doctors);
	}
}
