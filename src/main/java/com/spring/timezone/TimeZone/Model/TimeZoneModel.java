package com.spring.timezone.TimeZone.Model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZonedDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TimeZoneModel {

	private Instant instant;

	private LocalDate localDate;

	private LocalDateTime localDateTime;

	private OffsetDateTime offsetDateTime;

	private OffsetTime offsetTime;

	private ZonedDateTime zonedDateTime;
	
	private LocalTime localTime;

}
