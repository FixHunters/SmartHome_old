package com.smarthome.flat.svc.vaadin;

import com.smarthome.flat.svc.vaadin.menu.DefaultView;
import com.smarthome.flat.svc.vaadin.menu.HomeView;
import com.smarthome.flat.svc.vaadin.menu.NotificationView;
import com.smarthome.flat.svc.vaadin.menu.ScenesView;
import com.smarthome.flat.svc.vaadin.menu.StatusView;
import com.smarthome.flat.svc.vaadin.menu.RoomsView;

import com.vaadin.navigator.*;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.MenuBar.*;
import com.vaadin.ui.themes.ValoTheme;

/*import com.smarthome.flat.svc.vaadin.menu.DefaultView;
import com.smarthome.flat.svc.vaadin.menu.HomeView;
import com.smarthome.flat.svc.vaadin.menu.NotificationView;
import com.smarthome.flat.svc.vaadin.menu.ScenesView;
import com.smarthome.flat.svc.vaadin.menu.StatusView;
import com.smarthome.flat.svc.vaadin.menu.RoomsView;*/


import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;


@SpringUI(path = "/smartHome")
@PushStateNavigation
public class VaadinUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
      
        Label title = new Label("Menu");
        title.addStyleName(ValoTheme.MENU_TITLE);

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

        CssLayout menu = new CssLayout(title, home, scenes, rooms, status, notification);
        menu.addStyleName(ValoTheme.MENU_ROOT);
        menu.setHeight("1000px"); //TODO natvrdo hodnona pre vysku menu

        CssLayout viewContainer = new CssLayout();

        HorizontalLayout mainLayout = new HorizontalLayout(menu, viewContainer);
        setContent(mainLayout);

        Navigator navigator = new Navigator(this, viewContainer);
        navigator.addView("", DefaultView.class);
        navigator.addView("scenes", ScenesView.class);
        navigator.addView("rooms", RoomsView.class);
        navigator.addView("status", StatusView.class);
        navigator.addView("notifications", NotificationView.class);


//MENU_BAR------------------------------------------------------------------------------------    	
    	        
    	/*MenuBar barmenu = new MenuBar();
    	CssLayout viewContainer = new CssLayout();
    	VerticalLayout mainLayout = new VerticalLayout();
    	mainLayout.setSizeFull();
    	mainLayout.setStyleName(ValoTheme.LAYOUT_WELL);
    	
    	setContent(mainLayout);
    	
    	HorizontalLayout menuLayout = new HorizontalLayout(viewContainer, barmenu);
    	mainLayout.addComponent(menuLayout);
    	
    	MenuItem home = barmenu.addItem("Home", VaadinIcons.HOME, e->getNavigator().navigateTo(""));   	
    	MenuItem scenes = barmenu.addItem("Scenes", VaadinIcons.BOOK, e->getNavigator().navigateTo("scenes"));
    	MenuItem rooms = barmenu.addItem("Rooms", VaadinIcons.BED, e->getNavigator().navigateTo("rooms"));
    	rooms.addItem("Living room", null, null);
    	rooms.addItem("Bedroom", null, null);
    	rooms.addItem("Study room", null, null);
    	rooms.addItem("Kitchen", null, null);
    	rooms.addItem("Coridor", null, null);
    	rooms.addItem("Bathroom", null, null);
    	rooms.addItem("Balcony", null, null);
    	MenuItem notification = barmenu.addItem("Notification", VaadinIcons.BELL, e->getNavigator().navigateTo("notification"));
    	MenuItem status = barmenu.addItem("Status", VaadinIcons.LINE_BAR_CHART, e->getNavigator().navigateTo("status"));
   	            	
    	
    	Navigator navigator = new Navigator(this, viewContainer);
        navigator.addView("", HomeView.class);
        navigator.addView("scenes", ScenesView.class);
        navigator.addView("rooms", RoomsView.class);
        navigator.addView("status", StatusView.class);
        navigator.addView("notifications", NotificationView.class);
    	
        menuLayout.addComponent(barmenu);
        
        HorizontalLayout mainDisplay = new HorizontalLayout();
        mainLayout.addComponent(mainDisplay);
        
        mainDisplay.addComponent(new Label("Ahoj"));*/
    	
//--------------------------------------------------------------------------------------------     	
    	
//LINE----------------------------------------------------------------------------------------

//-------------------------------------------------------------------------------------------- 

    }

}

