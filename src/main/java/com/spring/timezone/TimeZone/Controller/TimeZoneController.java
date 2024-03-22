package com.spring.timezone.TimeZone.Controller;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.timezone.TimeZone.Model.TimeZoneModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/time-zone")
public class TimeZoneController {

	@GetMapping("/all")
	Flux<TimeZone> getAllTimeZone() {
		return Flux.fromIterable(Arrays.asList(TimeZone.getAvailableIDs())).map(TimeZone::getTimeZone);
	}

	@GetMapping("/default")
	public Mono<TimeZone> getDefault() {
		return Mono.just(TimeZone.getDefault());
	}

	@GetMapping("/current-datetime")
	public Mono<TimeZoneModel> currentDateTime() {
		return Mono.just(TimeZoneModel.builder().instant(Instant.now()).localDate(LocalDate.now())
				.localDateTime(LocalDateTime.now()).offsetDateTime(OffsetDateTime.now()).offsetTime(OffsetTime.now())
				.zonedDateTime(ZonedDateTime.now()).localTime(LocalTime.now()).build());
	}

	@GetMapping("/get-datetime/{timeZone}")
	public Mono<TimeZoneModel> getDateTimeByZone(@PathVariable("timeZone") String timeZone) {
		// http://localhost:8080/time-zone/get-datetime/Asia%2FAden
		return Mono.just(ZoneId.of(timeZone))
				  .map(id -> TimeZoneModel.builder().instant(Instant.now()).localDate(LocalDate.now())
							.localDateTime(LocalDateTime.now()).offsetDateTime(OffsetDateTime.now()).offsetTime(OffsetTime.now())
							.zonedDateTime(ZonedDateTime.now()).build());
	}
	
	@GetMapping("/get-datetime/{timeZone}/time")
	public Mono<TimeZoneModel> getTimeByZone(@PathVariable("timeZone") String timeZone) {
		// http://localhost:8080/time-zone/get-datetime/Asia%2FAden/time
		return Mono.just(ZoneId.of(timeZone))
				  .map(id -> TimeZoneModel.builder().instant(Instant.now()).localTime(LocalTime.now()).build());
	}
	
	@GetMapping("/get-datetime/{timeZone}/date")
	public Mono<TimeZoneModel> getDateByZone(@PathVariable("timeZone") String timeZone) {
		// http://localhost:8080/time-zone/get-datetime/Asia%2FAden/date
		return Mono.just(ZoneId.of(timeZone))
				  .map(id -> TimeZoneModel.builder().instant(Instant.now()).localDate(LocalDate.now()).build());
	}
}
