package com.smarthome.flat.svc.vaadin.menu;

import com.example.samples.gpio.ControlGpioExample;
import com.smarthome.flat.svc.vaadin.menu.utils.MenuBars;
import com.vaadin.navigator.View;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Label;

/**
 * @author Jan Pojezdala
 */
public class ScenesView extends Composite implements View {

	ControlGpioExample controlGpioExample = new ControlGpioExample();
	
    public ScenesView() {
        setCompositionRoot(new Label("This is view Scenes"));
        try {
        	controlGpioExample.main();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
