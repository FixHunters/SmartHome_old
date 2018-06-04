package com.smarthome.flat.svc.vaadin.menu;

import com.vaadin.navigator.View;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Label;

/**
 * @author Jan Pojezdala
 */
public class NotificationView extends Composite implements View {

    public NotificationView() {
        setCompositionRoot(new Label("This is view NOTIFICATIONS"));
    }
}
