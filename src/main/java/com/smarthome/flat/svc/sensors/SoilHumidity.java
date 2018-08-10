package com.smarthome.flat.svc.sensors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

/**
 * This example code demonstrates how to perform sensor state
 * control of a GPIO pin on the Raspberry Pi.
 *
 * @author Jan Pojezdala
 */
public class SoilHumidity {
	
	private static final Logger log = LoggerFactory.getLogger(SoilHumidity.class);

	 public  void main() throws InterruptedException {
	        System.out.println("<--Pi4J--> GPIO Listen Example ... started.");

	        // create gpio controller
	        final GpioController gpio = GpioFactory.getInstance();

	        // provision gpio pin #02 as an input pin with its internal pull down resistor enabled
	        final GpioPinDigitalInput inputPin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_29, PinPullResistance.PULL_DOWN);

	        // set shutdown state for this input pin
	        inputPin.setShutdownOptions(true);

	     // get input state from pin 2
	        boolean input_value = inputPin.isHigh();
	        System.out.println(" --> GPIO INPUT STATE : " + input_value);
	        // create and register gpio pin listener
	        inputPin.addListener(new GpioPinListenerDigital() {
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