package com.smarthome.flat.svc.vaadin;

import org.springframework.beans.factory.annotation.Autowired;

import com.smarthome.flat.svc.controller.ApplicationController;
import com.smarthome.flat.svc.model.Sensors;
import com.smarthome.flat.svc.vaadin.menu.DefaultView;
import com.smarthome.flat.svc.vaadin.menu.HomeView;
import com.smarthome.flat.svc.vaadin.menu.NotificationView;
import com.smarthome.flat.svc.vaadin.menu.ScenesView;
import com.smarthome.flat.svc.vaadin.menu.StatusView;
import com.smarthome.flat.svc.vaadin.menu.TestView;
import com.smarthome.flat.svc.vaadin.menu.RoomsView;
import com.vaadin.navigator.*; 
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*; 
import com.vaadin.ui.MenuBar.*; 
import com.vaadin.ui.themes.ValoTheme;

import com.vaadin.icons.VaadinIcons; 
import com.vaadin.server.VaadinRequest; 

@SpringUI(path = "/smartHome")
public class VaadinUI extends UI {
	
	@Autowired
	private ApplicationController controller;
	
	private Sensors sensors = new Sensors();
	

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Label title = new Label("Menu");
        title.addStyleName(ValoTheme.MENU_TITLE);

        /*Button view1 = new Button("Home", e -> getNavigator().navigateTo(""));
        view1.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);
        Button view2 = new Button("Scenes", e -> getNavigator().navigateTo("scenes"));
        view2.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);
        Button view3 = new Button("Rooms", e -> getNavigator().navigateTo("rooms"));
        view3.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);
        Button view4 = new Button("Status", e -> getNavigator().navigateTo("status"));
        view4.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);
        Button view5 = new Button("Notifications", e -> getNavigator().navigateTo("notifications"));
        view5.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);
        Button test = new Button("Test", e -> getNavigator().navigateTo("test"));
        test.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);*/
        
        Button home = new Button("Home", e->getNavigator().navigateTo("")); 
		home.setIcon(VaadinIcons.HOME); 
        home.addStyleNames( ValoTheme.MENU_ITEM); 
        
        Button scenes = new Button("Scenes", e->getNavigator().navigateTo("scenes")); 
        scenes.setIcon(VaadinIcons.BOOK); 
        scenes.addStyleNames(ValoTheme.MENU_ITEM); 

        Button rooms = new Button("Rooms", e->getNavigator().navigateTo("rooms")); 
        rooms.setIcon(VaadinIcons.BED); 
        rooms.addStyleNames(ValoTheme.MENU_ITEM); 

        Button status = new Button("Status", e->getNavigator().navigateTo("status")); 
        status.setIcon(VaadinIcons.LINE_BAR_CHART); 
        status.addStyleNames(ValoTheme.MENU_ITEM); 

        Button notification = new Button("Notifications", e->getNavigator().navigateTo("notifications")); 
        notification.setIcon(VaadinIcons.BELL); 
        notification.addStyleNames(/*ValoTheme.BUTTON_BORDERLESS_COLORED*/ ValoTheme.MENU_ITEM);
        
        Button test = new Button("Test", e->getNavigator().navigateTo("test"));
        test.setIcon(VaadinIcons.LINE_BAR_CHART); 
        test.addStyleNames(ValoTheme.MENU_ITEM); 

        CssLayout menu = new CssLayout(title, home, scenes, rooms, status, notification, test); 

        //CssLayout menu = new CssLayout(title, view1, view2, view3, view4, view5, test);
        menu.addStyleName(ValoTheme.MENU_ROOT);
        menu.setHeight("1000px"); //TODO natvrdo hodnona pre vysku menu

        CssLayout viewContainer = new CssLayout();

        HorizontalLayout mainLayout = new HorizontalLayout(menu, viewContainer);
        setContent(mainLayout);

        Navigator navigator = new Navigator(this, viewContainer);
        navigator.addView("", DefaultView.class);
        navigator.addView("scenes", ScenesView.class);
        navigator.addView("rooms", RoomsView.class);
        navigator.addView("status", new StatusView(controller));
        navigator.addView("notifications", NotificationView.class);
        navigator.addView("test", new TestView(controller));
           
        
    }    

}
