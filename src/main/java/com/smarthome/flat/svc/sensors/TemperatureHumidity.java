package com.smarthome.flat.svc.sensors;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pi4j.system.SystemInfo;
import com.smarthome.flat.svc.controller.BMP180;

/**
 * This example code demonstrates how to perform sensor state
 * control of a GPIO pin on the Raspberry Pi.
 *
 * @author Jan Pojezdala
 */
public class TemperatureHumidity {
	
	private static final Logger log = LoggerFactory.getLogger(TemperatureHumidity.class);
	
    public void main() throws Exception {

        final NumberFormat NF = new DecimalFormat("##00.00");
		BMP180 sensor = new BMP180();
		float press = 0;
		float temp = 0;
		double alt = 0;

		try {
			press = sensor.readPressure();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
		}
		sensor.setStandardSeaLevelPressure((int) press); // As we ARE at the sea level (in San Francisco).
		try {
			alt = sensor.readAltitude();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
		}
		try {
			temp = sensor.readTemperature();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
		}

		System.out.println("Temperature: " + NF.format(temp) + " C");
		System.out.println("Pressure   : " + NF.format(press / 100) + " hPa");
		System.out.println("Altitude   : " + NF.format(alt) + " m");
	    log.debug("Temperature: " + NF.format(temp) + " C");
	    log.debug("Pressure   : " + NF.format(press / 100) + " hPa");
	    log.debug("Altitude   : " + NF.format(alt) + " m");
		// Bonus : CPU Temperature
		try {
			System.out.println("CPU Temperature   :  " + SystemInfo.getCpuTemperature());
			System.out.println("CPU Core Voltage  :  " + SystemInfo.getCpuVoltage());
		    log.debug("CPU Temperature   :  " + SystemInfo.getCpuTemperature());
		    log.debug("CPU Core Voltage  :  " + SystemInfo.getCpuVoltage());
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
    }
}