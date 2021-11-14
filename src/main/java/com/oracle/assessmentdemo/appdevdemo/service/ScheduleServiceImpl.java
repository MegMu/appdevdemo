package com.oracle.assessmentdemo.appdevdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.oracle.assessmentdemo.appdevdemo.model.InterviewSchedule;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ScheduleServiceImpl implements ScheduleService{
	
	private final ReactiveMongoOperations reactiveMongoOperations;
	
	@Autowired
	public ScheduleServiceImpl(ReactiveMongoOperations reactiveMongoOperations) {
		this.reactiveMongoOperations = reactiveMongoOperations;
	}

	@Override
	public Mono<InterviewSchedule> getInterviewSchedule(String _id) {
		return reactiveMongoOperations.findById(_id, InterviewSchedule.class);
	}

	@Override
	public Mono<InterviewSchedule> createInterviewSchedule(Mono<InterviewSchedule> schedule) {
		return reactiveMongoOperations.save(schedule);
	}

	@Override
	public Mono<InterviewSchedule> updateInterviewSchedule(String _id, Mono<InterviewSchedule> schedule) {
		return reactiveMongoOperations.save(schedule);
	}

	@Override
	public Mono<Boolean> deleteInterviewSchedule(String _id) {
		return reactiveMongoOperations.remove(Query.query(Criteria.where("_id").is(_id)), InterviewSchedule.class)
				.flatMap(deleteResult -> Mono.just(deleteResult.wasAcknowledged()));
	}

	@Override
	public Flux<InterviewSchedule> getAllData() {
		Flux<InterviewSchedule> listUser = reactiveMongoOperations.findAll(InterviewSchedule.class);
		return listUser;
	}


}
