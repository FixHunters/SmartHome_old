package com.smarthome.flat.svc.vaadin.menu;

import com.smarthome.flat.svc.vaadin.menu.utils.MenuBars;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.MenuBar.MenuItem;

/**
 * @author Jan Pojezdala
 */
public class DefaultView extends Composite implements View {

	public DefaultView() {   	 
    setCompositionRoot(new MenuBars().getMenuButton("normal", false));
	}
}
