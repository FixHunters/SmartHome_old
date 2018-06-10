package com.smarthome.flat.svc.sensors;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.system.SystemInfo;
import com.smarthome.flat.svc.controller.BMP180;
import com.smarthome.flat.svc.controller.TppsApiController;

/**
 * This example code demonstrates how to perform simple state
 * control of a GPIO pin on the Raspberry Pi.
 *
 * @author Jan Pojezdala
 */
public class SoilHumidity {
	
	private static final Logger log = LoggerFactory.getLogger(SoilHumidity.class);

	 public static void main() throws InterruptedException {
	        System.out.println("<--Pi4J--> GPIO Listen Example ... started.");

	        // create gpio controller
	        final GpioController gpio = GpioFactory.getInstance();

	        // provision gpio pin #02 as an input pin with its internal pull down resistor enabled
	        final GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.PULL_DOWN);

	        // set shutdown state for this input pin
	        myButton.setShutdownOptions(true);

	        // create and register gpio pin listener
	        myButton.addListener(new GpioPinListenerDigital() {
	            @Override
	            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
	                // display pin state on console
	                System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState());
	            }

	        });

	        System.out.println(" ... complete the GPIO #02 circuit and see the listener feedback here in the console.");

	        // keep program running until user aborts (CTRL-C)
	        while(true) {
	            Thread.sleep(500);
	        }

	        // stop all GPIO activity/threads by shutting down the GPIO controller
	        // (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)
	        // gpio.shutdown();   <--- implement this method call if you wish to terminate the Pi4J GPIO controller
	    }
}