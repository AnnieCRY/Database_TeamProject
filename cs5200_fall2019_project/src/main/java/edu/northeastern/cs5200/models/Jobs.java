package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Jobs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String descripition;
	private String location;
	private String requirement;
	private String company;
	
	//One To Many for Applications
	@OneToMany (mappedBy = "thisJobApplications")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Applications> applicationsForThisJob;

	public void applicationsForThisJob(Applications app) {
		this.applicationsForThisJob.add(app);
		if (app.getThisJobsApplications() != this)
			app.setThisJobsApplications(this);
	}

	public List<Applications> getApplicationsForThisJob(){
		return applicationsForThisJob;
	}
	
	public void setApplicationsForThisJob(List<Applications> applicationsForThisJob) {
		this.applicationsForThisJob = applicationsForThisJob;
	}
	//

	//Many To One for recruiter
	@ManyToOne
	private Recruiter thisRecruiterJobs;

	public Recruiter getThisRecruiterJobs() {
		return thisRecruiterJobs;
	}
	public void setThisRecruiterJobs(Recruiter thisRecruiterJobs) {
		this.thisRecruiterJobs =  thisRecruiterJobs;
		if (!thisRecruiterJobs.getJobsCreatedByRecruiter().contains(this)) {
			thisRecruiterJobs.getJobsCreatedByRecruiter().add(this);
		}
	}
	//

	public Jobs() {}

	public Jobs(String title, String descripition, String location, String requirement, String company) {
		super();
		this.title = title;
		this.descripition = descripition;
		this.location = location;
		this.requirement = requirement;
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescripition() {
		return descripition;
	}

	public void setDescripition(String descripition) {
		this.descripition = descripition;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRequirment() {
		return requirement;
	}

	public void setRequirment(String requirement) {
		this.requirement = requirement;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
	
