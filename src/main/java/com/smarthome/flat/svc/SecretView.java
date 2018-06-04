package com.smarthome.flat.svc;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class SecretView extends VerticalLayout implements View {
	protected void init(VaadinRequest request) {
		
		VerticalLayout content = new VerticalLayout();
		
		Panel panel = new Panel("This is a Panel");
		VerticalLayout panelContent = new VerticalLayout();
		panelContent.addComponent(new Label("Hello!"));
		panel.setContent(panelContent);
		content.addComponent(panel);
		
	}

	@Override
	public void enter(ViewChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
