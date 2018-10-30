package com.smarthome.flat.svc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import com.smarthome.flat.svc.db.DBSupport;
import com.smarthome.flat.svc.model.Sensors;

@Controller
public class ApplicationController {
	
	private static final Logger log = LoggerFactory.getLogger(ApplicationController.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private DBSupport dbSupport;

	private DBSupport getDbSupport() {
		if (dbSupport == null) {
			dbSupport = new DBSupport(jdbcTemplate);
			log.info("ApplicationController:: dbSupport created " + dbSupport);
		}
		return dbSupport;
	}

	
	public void insertMeasuredData(Sensors sensor) {
		getDbSupport().insertSensorsData(sensor);
	}
	
	public void findAllSensorsData() {
		getDbSupport().findAllSensorsData();
	}
	
	public String findAllData() {
		return getDbSupport().findAllSensorsData().toString();
	}

}
