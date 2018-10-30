package com.smarthome.flat.svc.vaadin.menu.utils;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class ViewUtils {

	public VerticalLayout getButtons(){
		Button button1 = new Button("Working room");
    	button1.addClickListener(clickEvent ->
    	    Notification.show("Do not press this button again"));
    	button1.addStyleNames(ValoTheme.BUTTON_PRIMARY);
    	Button button2 = new Button("Bed room");
    	button2.addClickListener(clickEvent ->
    	    Notification.show("Bed room - Do not press this button again "));
    	button2.addStyleNames(ValoTheme.BUTTON_PRIMARY);
    	Button button3 = new Button("Living room");
    	button3.addClickListener(clickEvent ->
    	    Notification.show("Living room - Do not press this button again"));
    	button3.addStyleNames(ValoTheme.BUTTON_PRIMARY);
    	Button button4 = new Button("Bath room");
    	button4.addClickListener(clickEvent ->
    	    Notification.show("Bath room - Do not press this button again"));
    	button4.addStyleNames(ValoTheme.BUTTON_PRIMARY);
    	Button button5 = new Button("Kitchen");
    	button5.addClickListener(clickEvent ->
    	    Notification.show("Kitchen - Do not press this button again"));
    	button5.addStyleNames(ValoTheme.BUTTON_PRIMARY);
    	Button button6 = new Button("Balcony");
    	button6.addClickListener(clickEvent ->
    	    Notification.show("Balcony - Do not press this button again"));
    	button6.addStyleNames(ValoTheme.BUTTON_PRIMARY);
    	Button button7 = new Button("Hall");
    	button7.addClickListener(clickEvent ->
    	    Notification.show("Hall - Do not press this button again"));
    	button7.addStyleNames(ValoTheme.BUTTON_PRIMARY);
    	Button button8 = new Button("Toilet");
    	button8.addClickListener(clickEvent ->
    	    Notification.show("Toilet - Do not press this button again"));
    	button8.addStyleNames(ValoTheme.BUTTON_PRIMARY);
    	VerticalLayout vertical = new VerticalLayout ();
    	vertical.addComponents(button1, button2, button2, button4, button5, button6, button7, button8);
		return vertical;
	}
	
	 public Component showGrid(){
			final VerticalLayout layout = new VerticalLayout();
	    	final Grid viewContainer = new Grid("This is Grid where will be measured data!");
	        viewContainer.setWidth("500px");
	        layout.addComponent(viewContainer);
			return layout;
	    }
	 
	 public Component showPanel(){
		 Panel panel = new Panel("This is a rooms view Panel");
		 panel.setWidth(1000, Unit.PIXELS);
		 panel.setHeight(500, Unit.PIXELS);
		 VerticalLayout panelContent = new VerticalLayout();

		 panelContent.addComponent(new Label("Hello!"));
		 panel.setContent(panelContent);
			return panel;
	    }

	 public Component showMenuPanel(){
		 Panel panel = new Panel("This is a menu view Panel");
		// panel.setWidth(200, Unit.PIXELS);
		// panel.setHeight(500, Unit.PIXELS);
		 VerticalLayout panelContent = new VerticalLayout();

		 panelContent.addComponent(getButtons());
		 panel.setContent(panelContent);
			return panel;
	    }
}
