package com.smarthome.flat.svc;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

public class CountView extends Panel implements View {
    public static final String NAME = "count";

    private static int count = 1;

    public CountView() {
        setContent(new Label("Created: " + count++));
        System.out.println("som v counte");
    }

	@Override
	public void enter(ViewChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}