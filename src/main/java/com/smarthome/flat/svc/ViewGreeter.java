package com.smarthome.flat.svc;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@SpringComponent
@ViewScope
public class ViewGreeter {
    public String sayHello() {
        return "Hello from a view scoped bean " + toString();
    }
    
    public Component showPanel(){
		final VerticalLayout layout = new VerticalLayout();
    	final Panel viewContainer = new Panel();
        viewContainer.setSizeFull();
        layout.addComponent(viewContainer);
		return layout;
    }
    
    public Component showGrid(){
		final VerticalLayout layout = new VerticalLayout();
    	final Grid viewContainer = new Grid();
        viewContainer.setSizeFull();
        layout.addComponent(viewContainer);
		return layout;
    }
}