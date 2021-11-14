package com.oracle.assessmentdemo.appdevdemo.service;

import java.util.List;

import com.oracle.assessmentdemo.appdevdemo.model.InterviewSchedule;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ScheduleService {
	
	Mono<InterviewSchedule> getInterviewSchedule(String _id);
	
	Mono<InterviewSchedule> createInterviewSchedule(Mono<InterviewSchedule> schedule);
	
	Mono<InterviewSchedule> updateInterviewSchedule(String _id, Mono<InterviewSchedule> schedule);
	
	Mono<Boolean> deleteInterviewSchedule(String _id);
	
	Flux<InterviewSchedule> getAllData();
	

}
