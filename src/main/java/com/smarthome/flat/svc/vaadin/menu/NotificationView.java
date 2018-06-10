package com.smarthome.flat.svc.vaadin.menu;

import com.smarthome.flat.svc.sensors.TemperatureHumidity;
import com.vaadin.navigator.View;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Label;

/**
 * @author Jan Pojezdala
 */
public class NotificationView extends Composite implements View {

	TemperatureHumidity temperatureHumidity = new TemperatureHumidity();
    public NotificationView() {
        setCompositionRoot(new Label("This is view NOTIFICATIONS"));
        try {
			temperatureHumidity.main();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
