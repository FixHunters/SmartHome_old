package com.smarthome.flat.svc.db;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.smarthome.flat.svc.controller.ApplicationController;
import com.smarthome.flat.svc.model.Sensors;

/** database tools for working with the sensors store database */
public class DBSupport {
	
	private static final Logger log = LoggerFactory.getLogger(DBSupport.class);

	/** shared instance for working with DB */
	private JdbcTemplate jdbcTemplate;

	/**
	 * constructor
	 *
	 * @param jdbcTemplate
	 */
	public DBSupport(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * method for inserData the DB
	 */

	public void insertSensorsData(Sensors sensor) {
		String sql = "INSERT INTO sensors(id, temperature, humidity, soil_moisture) VALUES(?,?,?,?)";
		jdbcTemplate.update(sql, sensor.getId(), sensor.getTemperature(), sensor.getHumidity(),
				sensor.getSoil_moisture());
		log.info("DBSupport:: Sensor data inserted: " 
				+ "id: " + sensor.getId() 
				+ " Temperature: " + sensor.getTemperature() 
				+ " Humidity: " + sensor.getHumidity() 
				+ " Soil: " + sensor.getSoil_moisture());
	}

	public List<Sensors> findAllSensorsData() {
		String sql = "SELECT * FROM Sensors ";
		List<Sensors> sensors = (List<Sensors>) jdbcTemplate.query(sql, new SensorsRowMapper());
		log.info("DBSupport:: All sensor data selected: " + sensors.toString());
		return sensors;
	}

}
