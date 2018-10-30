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

	public ScenesView() {
		setCompositionRoot(new Label("This is view Scenes"));
	}
}
