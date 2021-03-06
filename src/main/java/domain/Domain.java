package domain;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import bl.HibernateUtil;
import entity.Address;
import entity.Employee;
import entity.Project;

public class Domain {

	public static void main (String... args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		Address address = new Address();
		address.setCountry("DC");
		address.setCity("Gotham City");
		address.setStreet("Arkham street 1");
		address.setPostCode("0981");

		Employee employee = new Employee();
		employee.setFirstName("James");
		employee.setLastName("Gordon");
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(1939,Calendar.MAY, 1);
		
		employee.setBirthday(new Date(calendar.getTime().getTime()));
		employee.setAddress(address);
		
		Project project = new Project();
		project.setTitle("5678");
		
		Set<Project> projects = new HashSet<>();
		projects.add(project);
		employee.setProjects(projects);
		
		session.save(address);
		session.save(employee);
		session.save(project);
		
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		

	}

}
