package com.smarthome.flat.svc.vaadin.menu;

import com.vaadin.navigator.View;
import com.vaadin.ui.Composite;
import com.smarthome.flat.svc.vaadin.menu.utils.MenuBars; 
import com.vaadin.icons.VaadinIcons; 
import com.vaadin.navigator.Navigator; 
import com.vaadin.ui.*; 
import com.vaadin.ui.MenuBar.*; 

/**
 * @author Jan Pojezdala
 */
public class DefaultView extends Composite implements View {

	public DefaultView() {   	  
	    setCompositionRoot(new MenuBars().getMenuButton("normal", false)); 
	}
}
