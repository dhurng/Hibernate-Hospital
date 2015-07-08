package cs157b_hw1;


import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author davidhurng
 * Tester class
 */
public class Tester {
	private static SessionFactory sessionFactory;
	
	public static void main(String[] args) {
	
		sessionFactory = HibernateUtil.getSessionFactory();
		//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		/*----------------------------------------------*/
		
		Person person = new Person();
		
		Doctor doctor = new Doctor();
		Doctor doctor2 = new Doctor();
		Doctor doctor3 = new Doctor();
		Patient patient = new Patient();
		Patient patient2 = new Patient();
		Patient patient3 = new Patient();
		Patient patient4 = new Patient();

		Appointment appointment = new Appointment();
		Appointment appointment2 = new Appointment();
		Appointment appointment3 = new Appointment();
		Appointment appointment4 = new Appointment();
		Appointment appointment5 = new Appointment();
		Appointment appointment6 = new Appointment();

		Prescription prescription = new Prescription();
		Prescription prescription2 = new Prescription();
		Prescription prescription3 = new Prescription();
		Prescription prescription4 = new Prescription();
		Prescription prescription5 = new Prescription();
		Prescription prescription6 = new Prescription();

		
		/*----------------------------------------------*/
		
		doctor.setName("David");
		doctor.setSpeciality("Surgeon");
		doctor2.setName("Jonathan");
		doctor2.setSpeciality("Dentist");		
		doctor3.setName("Christopher");
		doctor3.setSpeciality("Brain Surgeon");
		
		patient.setName("Michelle");
		patient.setBirthDate("1996/02/04");
		patient2.setName("Esther");
		patient2.setBirthDate("1992/12/02");
		patient3.setName("Lenee");
		patient3.setBirthDate("2001/06/27");
		patient4.setName("Crystal");
		patient4.setBirthDate("1982/07/27");
		
		appointment.setAppDate(new Date());
		appointment.setPatient(patient);
		appointment2.setAppDate(new Date());
		appointment2.setPatient(patient2);
		appointment3.setAppDate(new Date());
		appointment3.setPatient(patient3);
		appointment4.setAppDate(new Date());
		appointment4.setPatient(patient3);
		appointment5.setAppDate(new Date());
		appointment5.setPatient(patient4);
		appointment6.setAppDate(new Date());
		appointment6.setPatient(patient4);
		
		prescription.setPrescName("Viagra");
		prescription.setPatient(patient);
		prescription2.setPrescName("Smart Pills");
		prescription2.setPatient(patient2);
		prescription3.setPrescName("Dumb Medication");
		prescription3.setPatient(patient3);
		prescription4.setPrescName("Methodine");
		prescription4.setPatient(patient3);
		prescription5.setPrescName("Gabbro");
		prescription5.setPatient(patient4);
		prescription6.setPrescName("Plintocost");
		prescription6.setPatient(patient4);

		
		doctor.setPatients(patient);
		doctor.setPatients(patient2);
		doctor.setPatients(patient3);
		
		doctor2.setPatients(patient2);
		doctor2.setPatients(patient3);
		
		doctor3.setPatients(patient);
		doctor3.setPatients(patient3);
		doctor3.setPatients(patient4);
		
		/*------------------------------------------*/
		session.save(person);

		session.save(doctor);
		session.save(doctor2);
		session.save(doctor3);
		
		session.save(patient);
		session.save(patient2);
		session.save(patient3);
		session.save(patient4);
		
		session.save(appointment);
		session.save(appointment2);
		session.save(appointment3);
		session.save(appointment4);
		session.save(appointment5);
		session.save(appointment6);

		session.save(prescription);
		session.save(prescription2);
		session.save(prescription3);
		session.save(prescription4);
		session.save(prescription5);
		session.save(prescription6);

		
		//System.out.println("HHELLLLOOOOO");
		//System.out.println(doctor3.getPatients());
		
		/*-----------------------------------------*/
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();	
	}
}