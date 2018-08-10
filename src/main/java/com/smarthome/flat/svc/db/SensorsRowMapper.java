package com.smarthome.flat.svc.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smarthome.flat.svc.model.Sensors;

public class SensorsRowMapper implements RowMapper<Sensors> {

	@Override
	public Sensors mapRow(ResultSet rs, int rowNum) throws SQLException {
		Sensors res = new Sensors();
		res.id(rs.getInt("ID"))
			.temperature(rs.getString("TEMPERATURE"))
			.humidity(rs.getString("HUMIDITY"))
			.soil_moisture(rs.getString("SOIL_MOISTURE"));
		return res;
	}
}
