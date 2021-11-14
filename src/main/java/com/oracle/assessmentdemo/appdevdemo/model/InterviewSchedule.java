package com.oracle.assessmentdemo.appdevdemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class InterviewSchedule {

	private String candidateID;
	private String startTime;
	private String endTime;
	private String profile;

	@Id
	private String _id;

	public InterviewSchedule() {

	}

	public InterviewSchedule(String candidateID, String startTime, String endTime, String profile) {
		super();
		this.candidateID = candidateID;
		this.startTime = startTime;
		this.endTime = endTime;
		this.profile = profile;
	}

	public String getCandidateID() {
		return candidateID;
	}

	public void setCandidateID(String candidateID) {
		this.candidateID = candidateID;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getId() {
		return _id;
	}

}
