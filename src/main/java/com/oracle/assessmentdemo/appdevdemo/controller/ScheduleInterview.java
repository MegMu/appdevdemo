package com.oracle.assessmentdemo.appdevdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.assessmentdemo.appdevdemo.model.InterviewSchedule;
import com.oracle.assessmentdemo.appdevdemo.service.ScheduleService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/interview/v1/scheduleInterview/")
@CrossOrigin
public class ScheduleInterview {

	private final ScheduleService scheduleService;

	@Autowired
	public ScheduleInterview(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}

	@GetMapping(path = "{_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<InterviewSchedule> getInterviewScheduleById(@PathVariable String _id) {

		return scheduleService.getInterviewSchedule(_id);

	}

	@RequestMapping(path = "/all", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public Flux<InterviewSchedule> getAll() {

		return scheduleService.getAllData();

	}

	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<InterviewSchedule> createSchedule(@RequestBody Mono<InterviewSchedule> interviewSchedule) {

		return scheduleService.createInterviewSchedule(interviewSchedule);

	}

	@PutMapping(path = "{_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<InterviewSchedule> updateSchedule(@PathVariable String _id,
			@RequestBody Mono<InterviewSchedule> interviewSchedule) {

		return scheduleService.updateInterviewSchedule(_id, interviewSchedule);

	}

	@DeleteMapping(path = "{_id}")
	public Mono<Boolean> deleteSchedule(@PathVariable String _id) {

		return scheduleService.deleteInterviewSchedule(_id);

	}

}
