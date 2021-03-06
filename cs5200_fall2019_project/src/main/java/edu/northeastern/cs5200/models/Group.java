package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Group")
@Table(name = "_group_")
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int activePoint;
	

	
	//TODO: uncomment when student are added
	//TODO: add getters and setters for it
	@ManyToMany(mappedBy = "enrolledGroups")
	private List<Student> enrolledStudents;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public void enrolledStudents(Student student){
		this.enrolledStudents.add(student);
		if (!student.getEnrolledGroups().contains(this)) {
			student.getEnrolledGroups().add(this);
		}
	}

	public void removeEnrolledStudent(Student student){
		this.enrolledStudents.remove(student);
		if (student.getEnrolledGroups().contains(this)) {
			student.getEnrolledGroups().remove(this);
		}
	}

	public List<Student> getEnrolledStudents(){
		return enrolledStudents;
	}
	
	public void setEnrolledStudents(List<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}	

	public Group() {
	}
	
	public Group(String name, int activePoint) {
		this.name = name;
		this.activePoint = activePoint;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getActivePoint() {
		return activePoint;
	}
	public void setActivePoint(int activePoint) {
		this.activePoint = activePoint;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
	    this.id = id;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
