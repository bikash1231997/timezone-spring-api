package com.spring.timezone.TimeZone.Config;

import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class TimeZoneConfig {
	
	@Value("${timeZone}")
	private String timeZone;

	@PostConstruct
	public void setDefaultTimeZone() {
		TimeZone.setDefault(TimeZone.getTimeZone(timeZone != null ? timeZone:"Asia/Kolkata"));
	}
}
