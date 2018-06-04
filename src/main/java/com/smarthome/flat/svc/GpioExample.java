package com.smarthome.flat.svc;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;


@SuppressWarnings("serial")
public class GpioExample extends UI {
	@Override
	public void init(VaadinRequest request) {
		
	/*	//Get the Pi4J GPIO controller instance
		GpioController gpioController = GpioFactory.getInstance();
		//Initialize the GPIO pin
		final GpioPinDigitalOutput pin = 
		gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_00, "MyLED", PinState.LOW);
		
		Button buttonOnOff = new Button("On/Off", new Button.ClickListener () {
			
			//Handle the button click event
			public void buttonClick(Button.ClickEvent event)
			{				
				//Turn the LED ON/OFF
				pin.toggle();
			}	
		});
		
		//Add the button to the UI
		setContent(buttonOnOff);*/
	}
}