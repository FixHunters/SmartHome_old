package com.smarthome.flat.svc.vaadin.menu;

import com.smarthome.flat.svc.vaadin.menu.utils.ViewUtils;
import com.vaadin.navigator.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Composite;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Jan Pojezdala
 */
public class RoomsView extends Composite implements View {

	ViewUtils viewUtils = new ViewUtils();
    public RoomsView() {
        setCompositionRoot(roomLayout());
    }
    
    public HorizontalLayout roomLayout(){
    	// Set the root layout for the UI
    	HorizontalLayout content = new HorizontalLayout();
    	content.setSizeFull();
    	
    	
    	//Layout getButtons = viewUtils.getButtons();
    	//content.setaddComponents(getButtons);
    	//content.setComponentAlignment(getButtons, Alignment.BOTTOM_RIGHT);
    	
    	content.addComponents(viewUtils.getButtons());
    	//content.addComponents(viewUtils.showMenuPanel());
    	content.addComponents(viewUtils.showPanel());
		return content;   	
    }
    

    
}
