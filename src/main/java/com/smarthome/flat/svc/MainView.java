package com.smarthome.flat.svc;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Sizeable;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;
import com.vaadin.ui.themes.ValoTheme;

/** Main view with a menu (with declarative layout design) */
@DesignRoot
public class MainView extends VerticalLayout implements View {
    public static final String NAME = "";

    public MainView() {

        Link lnk = new Link("Count", new ExternalResource("#!"
                + CountView.NAME));
       //W setContent(lnk);
        

       

    }

     public void enter(ViewChangeEvent event) {

    }
     


}