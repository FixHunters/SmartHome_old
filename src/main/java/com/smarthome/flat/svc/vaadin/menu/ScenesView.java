package com.smarthome.flat.svc.vaadin.menu;

import com.smarthome.flat.svc.vaadin.menu.utils.MenuBars;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Composite;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Jan Pojezdala
 */
public class ScenesView extends Composite implements View {

    public ScenesView() {
    	HorizontalLayout panel = new HorizontalLayout();
    	panel.setSizeFull();
    	//HorizontalLayout panel1 = new HorizontalLayout();
    	Button btn = new Button();
    	btn.setHeight("500");
    	btn.setWidth("500");
    	
    	panel.addComponent(btn);
    	//panel1.addComponent(new Label("SCENES1"));
        setCompositionRoot(panel);
    	//setContent(panel);
        //setCompositionRoot(panel1);
    }
}
