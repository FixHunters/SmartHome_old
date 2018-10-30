package com.smarthome.flat.svc.vaadin.menu; 

import com.smarthome.flat.svc.vaadin.menu.utils.MenuBars; 
import com.vaadin.navigator.View; 
import com.vaadin.ui.Composite; 
import com.vaadin.ui.Label; 

/** 
 * @author Jan Pojezdala 
 */ 


public class HomeView extends Composite implements View { 
    public HomeView() { 
    	 setCompositionRoot(new Label ("HOME")); 
    } 
} 