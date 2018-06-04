package com.smarthome.flat.svc.vaadin;

import com.smarthome.flat.svc.vaadin.menu.DefaultView;
import com.smarthome.flat.svc.vaadin.menu.NotificationView;
import com.smarthome.flat.svc.vaadin.menu.ScenesView;
import com.smarthome.flat.svc.vaadin.menu.StatusView;
import com.smarthome.flat.svc.vaadin.menu.RoomsView;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.PushStateNavigation;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

@SpringUI(path = "/smartHome")
@PushStateNavigation
public class VaadinUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Label title = new Label("Menu");
        title.addStyleName(ValoTheme.MENU_TITLE);

        Button view1 = new Button("Home", e -> getNavigator().navigateTo(""));
        view1.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);
        Button view2 = new Button("Scenes", e -> getNavigator().navigateTo("scenes"));
        view2.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);
        Button view3 = new Button("Rooms", e -> getNavigator().navigateTo("rooms"));
        view3.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);
        Button view4 = new Button("Status", e -> getNavigator().navigateTo("status"));
        view4.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);
        Button view5 = new Button("Notifications", e -> getNavigator().navigateTo("notifications"));
        view5.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);

        CssLayout menu = new CssLayout(title, view1, view2, view3, view4, view5);
        menu.addStyleName(ValoTheme.MENU_ROOT);
        menu.setHeight("1000px"); //TODO natvrdo hodnona pre vysku menu

        CssLayout viewContainer = new CssLayout();

        HorizontalLayout mainLayout = new HorizontalLayout(menu, viewContainer);
        //mainLayout.setSizeFull();
        setContent(mainLayout);

        Navigator navigator = new Navigator(this, viewContainer);
        navigator.addView("", DefaultView.class);
        navigator.addView("scenes", ScenesView.class);
        navigator.addView("rooms", RoomsView.class);
        navigator.addView("status", StatusView.class);
        navigator.addView("notifications", NotificationView.class);
    }

}
